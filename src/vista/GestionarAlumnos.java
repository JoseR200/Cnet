package vista;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Modelo;

import java.util.List;
import java.util.Objects;

public class GestionarAlumnos {
    Modelo modelo = new Modelo();

    public void crearAlumno() {
        if (modelo.writeAlumno(ConsolePrint.crearAlumno())) {
            ConsolePrint.alumnoCreado();
        } else {
            ConsolePrint.errorCrearAlumno();
        }
    }

    public void asignarAlumnoAsignatura() {
        String[] alumnoAsignatura = ConsolePrint.asignarAlumnoAsignatura();

        if (modelo.existeAlumnoExisteAsignatura(alumnoAsignatura[0], alumnoAsignatura[1])) {
        	Alumno alumno = modelo.getAlumnoByAlumnoUsername(alumnoAsignatura[0]);
        	Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(alumnoAsignatura[1]);
        	
        	if (asignatura.getCalificaciones().size() > 0) {
        		alumno.addAsignatura(alumnoAsignatura[1]);

                
                asignatura.addAlumno(alumnoAsignatura[0]);

                modelo.modifyAlumno(alumno);
                modelo.modifyAsignatura(asignatura);

                ConsolePrint.alumnoAsignado();
        	} else {
        		ConsolePrint.errorAsignarAlumnoNuevo();
        	}
        } else {
            ConsolePrint.errorAsignarAlumno();
        }
    }

    public void obtenerAlumno() {
        String alumnoString = ConsolePrint.ingresarAlumno().trim();
    
        if (modelo.existeAlumno(alumnoString)) {
            Alumno alumno = modelo.getAlumnoByAlumnoUsername(alumnoString);
    
            int opcionActualizar = -1;
            while (opcionActualizar != 3) {
                try {
                    opcionActualizar = Integer.parseInt(ConsolePrint.verAlumno(alumno));
    
                    if (opcionActualizar == 1) {
                        obtenerAsignaturaD(alumnoString);  
                    } else if (opcionActualizar == 2) {
                        alumno = ConsolePrint.actualAlumno(alumno);
                        modelo.modifyAlumno(alumno);
                        ConsolePrint.alumnoActualizado();
                    } else if (opcionActualizar == 3) {
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
    }
    
    public void obtenerAsignaturaD(String alumnoString) {
        String asignaturaString = ConsolePrint.ingresarAsignatura().trim(); // Método para pedir el nombre de la asignatura al usuario
    
            Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(asignaturaString);
    
            if (asignatura.getAlumnos().contains(alumnoString)) {
                Alumno alumno = modelo.getAlumnoByAlumnoUsername(alumnoString);
                int indexAlumno = asignatura.getAlumnos().indexOf(alumnoString);
    
                if (indexAlumno != -1 && indexAlumno < asignatura.getCalificaciones().size()) {
                    List<Double> notas = asignatura.getCalificaciones().get(indexAlumno).getNotas();
                    ConsolePrint.mostrarNotas(alumno, asignatura, notas);
                } else {
                    ConsolePrint.errorSinNotas(alumno, asignatura);
                }
            } else {
                ConsolePrint.errorAlumnoNoInscrito(alumnoString, asignatura);
            }
    }
    

    public void obtenerAlumnos() {
        List<Alumno> alumnos = modelo.readAlumnosFromJson();

        for (int i = 0; i < alumnos.size(); ) {
            for (int j = 0; j < 5; j++) {
                if (i >= alumnos.size()) {
                    break;
                }
                ConsolePrint.verAlumno(alumnos.get(i));
                i++;
            }
            if (i < alumnos.size()) {
                var opcion = ConsolePrint.verMasAlumnos(i, alumnos.size());
                if (Objects.equals(opcion, "0")) {
                    i = alumnos.size();
                }
            }
        }
    }
}
