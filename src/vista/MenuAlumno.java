package vista;

import java.util.ArrayList;
import java.util.List;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
import modelos.Modelo;

public class MenuAlumno {
	Modelo modelo = new Modelo();

	public void gestionarAsignaturas(Alumno alumno) {
		int opcionObtenerAsignatura = -1;
		
		try {
			opcionObtenerAsignatura = Integer.parseInt(ConsolePrint.ingresarIndiceAsignaturaAlumno());
			
			if (opcionObtenerAsignatura < alumno.getAsignaturas().size() && opcionObtenerAsignatura >= 0) {
				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(alumno.getAsignaturas().get(opcionObtenerAsignatura));
				
				ConsolePrint.verAsignaturaAlumno(asignatura);
				
				if (asignatura.getCalificaciones().size() > 0 ) {
					int indexAlumno = asignatura.getAlumnos().indexOf(alumno.getUsuario());
					
					List<Double> notas = new ArrayList<>();
	                
	                for (Calificacion c : asignatura.getCalificaciones()) {
	                    notas.add(c.getNotas().get(indexAlumno));
	                }
	    
	                ConsolePrint.mostrarNotas(alumno, asignatura, notas);
	                
	                ConsolePrint.mostrarMedia(notas);
	                
	                int opcionGrupoCalificaciones = -1;
	                
	                while (opcionGrupoCalificaciones != 2) {
	                	try {
	                		opcionGrupoCalificaciones = Integer.parseInt(ConsolePrint.obtenerGrupoCalificacion());
	                		
	                		if (opcionGrupoCalificaciones == 1) {
	                			int indiceGrupoCalificacion = -1;
	                			
	                			try {
	                				indiceGrupoCalificacion = Integer.parseInt(ConsolePrint.ingresarIndiceGrupoCalificacion());
	                    			
	                    			if (indiceGrupoCalificacion <= asignatura.getCalificaciones().size() && indiceGrupoCalificacion >= 1) {
	                    				ConsolePrint.mostrarGrupoCalificacion(asignatura, indiceGrupoCalificacion);
	                    			} else {
	                    				ConsolePrint.errorSolicitudOpcion();
	                    			}
	                    		} catch (NumberFormatException e) {
	                    			ConsolePrint.errorSolicitudOpcion();
	                    		}
	                		} else if (opcionGrupoCalificaciones == 2) {
	                			continue;
	                		} else {
	                			ConsolePrint.errorSolicitudOpcion();
	                		}
	            		} catch (NumberFormatException e) {
	            			ConsolePrint.errorSolicitudOpcion();
	            		}
	                }
				}
			} else {
				ConsolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			ConsolePrint.errorSolicitudOpcion();
		}
	}
}
