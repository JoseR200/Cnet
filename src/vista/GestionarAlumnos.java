package vista;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
import modelos.Modelo;

import java.util.ArrayList;
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

        	if (asignatura.getCalificaciones().size() <= 0) {
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
            
            double sumaMediaFinal = 0;
			for (String a: alumno.getAsignaturas()) {
				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(a);
				
				List<Calificacion> calificaciones = asignatura.getCalificaciones();
	            int indexAlumno = asignatura.getAlumnos().indexOf(alumno.getUsuario());

	            double sumaNotas = 0;
	            for (Calificacion cal : calificaciones) {
	                sumaNotas += cal.getNotas().get(indexAlumno);
	            }
	            sumaNotas = sumaNotas / calificaciones.size();
	            
	            sumaMediaFinal += sumaNotas;
			}
			sumaMediaFinal = sumaMediaFinal / alumno.getAsignaturas().size();
    
            int opcionActualizar = -1;
            while (opcionActualizar != 3) {
                try {
                    opcionActualizar = Integer.parseInt(ConsolePrint.verAlumno(alumno, sumaMediaFinal));
    
                    if (opcionActualizar == 1) {
                    	int opcionObtenerAsignatura = -1;
                		
                		try {
                			opcionObtenerAsignatura = Integer.parseInt(ConsolePrint.ingresarIndiceAsignaturaAlumno());
                			
                			if (opcionObtenerAsignatura < alumno.getAsignaturas().size() && opcionObtenerAsignatura >= 0) {
                				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(alumno.getAsignaturas().get(opcionObtenerAsignatura));
                				
            	                int indexAlumno = asignatura.getAlumnos().indexOf(alumnoString);
            	                
            	                List<Double> notas = new ArrayList<>();
            	                
            	                for (Calificacion c : asignatura.getCalificaciones()) {
            	                    notas.add(c.getNotas().get(indexAlumno));
            	                }
            	    
        	                    ConsolePrint.mostrarNotas(alumno, asignatura, notas);
        	                    
        	                    ConsolePrint.mostrarMedia(notas);
        	                    
                			} else {
                				ConsolePrint.errorSolicitudOpcion();
                			}
                		} catch (NumberFormatException e) {
                			ConsolePrint.errorSolicitudOpcion();
                		}
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

    public void obtenerAlumnos() {
        List<Alumno> alumnos = modelo.readAlumnosFromJson();

        for (int i = 0; i < alumnos.size(); ) {
            for (int j = 0; j < 5; j++) {
                if (i >= alumnos.size()) {
                    break;
                }
                ConsolePrint.verAlumnoDentroDeAlumnos(alumnos.get(i));
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