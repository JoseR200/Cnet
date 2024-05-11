package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
import modelos.Modelo;

public class MenuAlumno {
    Modelo modelo = new Modelo();

    public void gestionarAsignaturas(Alumno alumno) {
        int opcionObtenerAsignatura = -1;

        while (opcionObtenerAsignatura != 0) {
            try {
                ConsolePrint.mostrarMenuAsignaturas();  
                opcionObtenerAsignatura = Integer.parseInt(ConsolePrint.ingresarIndiceAsignaturaAlumno());

                switch (opcionObtenerAsignatura) {
                    case 1: 
                        int asignaturaIndex = Integer.parseInt(ConsolePrint.ingresarIndiceAsignaturaAlumno());

                        if (asignaturaIndex < alumno.getAsignaturas().size() && asignaturaIndex >= 0) {
                            Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(alumno.getAsignaturas().get(asignaturaIndex));

                            ConsolePrint.verAsignaturaAlumno(asignatura);

                            int indexAlumno = asignatura.getAlumnos().indexOf(alumno.getUsuario());
                            List<Double> notas = new ArrayList<>();

                            for (Calificacion c : asignatura.getCalificaciones()) {
                                notas.add(c.getNotas().get(indexAlumno));
                            }

                            ConsolePrint.mostrarNotas(alumno, asignatura, notas);
                        } else {
                            ConsolePrint.errorSolicitudOpcion();
                        }
                        break;

                    case 2: 
                        mostrarMediaFinal(alumno);
                        break;

                    case 0: 
                        return;

                    default:
                        ConsolePrint.errorSolicitudOpcion();
                }
            } catch (NumberFormatException e) {
                ConsolePrint.errorSolicitudOpcion();
            }
        }
    }

    private void mostrarMediaFinal(Alumno alumno) {
        List<String> nombresAsignaturas = alumno.getAsignaturas(); // Esto retorna los nombres de las asignaturas.
		List<Asignatura> asignaturas = nombresAsignaturas.stream()
    		.map(nombre -> modelo.getAsignaturaByAsignaturaName(nombre))
    		.collect(Collectors.toList());
        double sumaMedia = 0;
        int totalAsignaturas = asignaturas.size();

        for (Asignatura asignatura : asignaturas) {
            List<Calificacion> calificaciones = asignatura.getCalificaciones();
            int indexAlumno = asignatura.getAlumnos().indexOf(alumno.getUsuario());

            double sumaNotas = 0;
            for (Calificacion cal : calificaciones) {
                sumaNotas += cal.getNotas().get(indexAlumno);
            }
            sumaMedia += sumaNotas / calificaciones.size();
        }

        double mediaFinal = totalAsignaturas > 0 ? sumaMedia / totalAsignaturas : 0;
        ConsolePrint.mostrarMediaFinal(alumno, mediaFinal);
    }
}
