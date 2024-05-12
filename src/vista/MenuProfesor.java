package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
import modelos.Modelo;
import modelos.Profesor;

public class MenuProfesor {
    GestionarAsignaturas gestionarAsignaturas = new GestionarAsignaturas();
    Modelo modelo = new Modelo();


    public void gestionarPerfil(String usuario) {
        int opcionActualizar = -1;

        Profesor profesor = modelo.getProfesorByProfesorUsername(usuario);
        while (opcionActualizar != 2) {
            try {
                opcionActualizar = Integer.parseInt(ConsolePrint.verProfe(profesor));

                if (opcionActualizar == 1) {
                    profesor = ConsolePrint.actualProfe(profesor);
                    modelo.modifyProfesor(profesor);
                    ConsolePrint.profesorActualizado();
                } else if (opcionActualizar == 2) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            } catch (NumberFormatException e) {
                ConsolePrint.errorSolicitudOpcion();
            }
        }
    }


    public void gestionarAsignaturas(String usuario) {
        int opcionObtener = -1;

        Profesor profesor = modelo.getProfesorByProfesorUsername(usuario);
        if (profesor.getAsignaturas().isEmpty()) {
            ConsolePrint.profesorAsignaturasVacio();
        } else {
            while (opcionObtener != 2) {
                try {
                    opcionObtener = Integer.parseInt(ConsolePrint.gestionarAsignaturasProfesor(profesor.getAsignaturas()));

                    if (opcionObtener == 1) {
                        int opcionInfoAsignatura = -1;

                        try {
                            opcionInfoAsignatura = Integer.parseInt(ConsolePrint.obtenerAsignaturaProfesor());

                            if (opcionInfoAsignatura < profesor.getAsignaturas().size() && opcionInfoAsignatura >= 0) {
                                int opcioncalificacion = -1;
                                Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(profesor.getAsignaturas().get(opcionInfoAsignatura));

                                while (opcioncalificacion != 4) {
                                    try {
                                        opcioncalificacion = Integer.parseInt(ConsolePrint.verAsignaturaProfe(asignatura));

                                        if (opcioncalificacion == 1) {
                                            String opcionInfoAlumno = ConsolePrint.ingresarAlumno();

                                            if (modelo.existeAlumnoDentroDeAsignatura(opcionInfoAlumno, asignatura)) {
                                                Alumno alumno = modelo.getAlumnoByAlumnoUsername(opcionInfoAlumno);

                                                ConsolePrint.verAlumnoProfesor(alumno);

                                                int indexAlumno = asignatura.getAlumnos().indexOf(opcionInfoAlumno);

                                                List<Double> notas = new ArrayList<>();

                                                for (Calificacion c : asignatura.getCalificaciones()) {
                                                    notas.add(c.getNotas().get(indexAlumno));
                                                }

                                                ConsolePrint.mostrarNotas(alumno, asignatura, notas);
                                            } else {
                                                ConsolePrint.errorSolicitudOpcion();
                                            }
                                        } else if (opcioncalificacion == 2) {
                                            if (asignatura.getAlumnos().size() > 0) {
                                                if (ConsolePrint.crearCalificacion(asignatura)) {
                                                    modelo.modifyAsignatura(asignatura);
                                                }
                                            } else {
                                                ConsolePrint.errorCrearCalificacion();
                                            }
                                        } else if (opcioncalificacion == 3) {
                                            var notas = IntStream.range(0, asignatura.getAlumnos().size()).mapToObj(
                                                    (indexAlumno) -> {
                                                        List<AlumnoNota> notasAlumno = new ArrayList<>();
                                                        for (Calificacion c : asignatura.getCalificaciones()) {
                                                            var index = asignatura.getCalificaciones().indexOf(c);
                                                            notasAlumno.add(new AlumnoNota(
                                                                    asignatura.getAlumnos().get(indexAlumno),
                                                                    c.getNotas().get(indexAlumno),
                                                                    index
                                                            ));
                                                        }
                                                        return notasAlumno;
                                                    }
                                            ).flatMap(List::stream).toList();
                                            Modelo.Export(notas, "profesoresAsignatura");
                                        } else if (opcioncalificacion == 4) {
                                            continue;
                                        } else {
                                            ConsolePrint.errorSolicitudOpcion();
                                        }
                                    } catch (NumberFormatException e) {
                                        ConsolePrint.errorSolicitudOpcion();
                                    }
                                }
                            } else {
                                ConsolePrint.errorSolicitudOpcion();
                            }
                        } catch (NumberFormatException e) {
                            ConsolePrint.errorSolicitudOpcion();
                        }
                    } else if (opcionObtener == 2) {
                        continue;
                    } else {
                        ConsolePrint.errorSolicitudOpcion();
                    }
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
        }
    }


    private static class AlumnoNota {
        public final String alumno;
        public final Double nota;
        public final Integer orden;

        public AlumnoNota(String alumno, Double nota, Integer orden) {
            this.alumno = alumno;
            this.nota = nota;
            this.orden = orden;
        }
    }
}
