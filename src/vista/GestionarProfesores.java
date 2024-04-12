package vista;

import java.util.List;

import modelos.Asignatura;
import modelos.Director;
import modelos.Modelo;
import modelos.Profesor;

public class GestionarProfesores {
	ConsolePrint consolePrint = new ConsolePrint();
	Modelo modelo = new Modelo();
	
	public void crearProfesor(Director director) {
		if (modelo.writeProfesor(consolePrint.crearProfe(), director)) {
			modelo.modifyDirector(director);
			consolePrint.profesorCreado();
		} else {
			consolePrint.errorCrearProfesor();
		}
	}
	
	public void despedirProfesor(Director director) {
		String profeEliminar = consolePrint.despedirProfe();
		
		Boolean pedirReemplazo = modelo.profesorTieneAsignatura(profeEliminar);
		
		if (pedirReemplazo) {
			String profeReemplazo = consolePrint.reemplazoDeProfe();
			
			if (modelo.existeProfesor(profeEliminar) && modelo.existeProfesor(profeReemplazo)) {
				List<String> asignaturasProfesor = modelo.getProfesorByProfesorUsername(profeEliminar).getAsignaturas();
				Profesor profesorRemplazo = modelo.getProfesorByProfesorUsername(profeReemplazo);
				
				for (String asignatura: asignaturasProfesor) {
					Asignatura asignaturaCambiar = modelo.getAsignaturaByAsignaturaName(asignatura);
					asignaturaCambiar.setUserProfesor(profeReemplazo);
					modelo.modifyAsignatura(asignaturaCambiar);
					
					profesorRemplazo.addAsignatura(asignatura);
				}
				
				modelo.deleteProfesor(profeEliminar, director);
				modelo.modifyDirector(director);
				modelo.modifyProfesor(profesorRemplazo);
				consolePrint.profesorEliminado();
			} else {
				consolePrint.errorEliminarProfesor();
			}
		} else {
			if (modelo.existeProfesor(profeEliminar)) {
				modelo.deleteProfesor(profeEliminar, director);
				modelo.modifyDirector(director);
				consolePrint.profesorEliminado();
			} else {
				consolePrint.errorEliminarProfesor();
			}
		}
	}
	
	public void obtenerProfesor(Director director) {
		int opcionInfoProfesor = -1;
		
		try {
			opcionInfoProfesor = Integer.parseInt(consolePrint.ingresarIndiceProfe());
			
			if (opcionInfoProfesor < director.getProfesores().size() && opcionInfoProfesor >= 0) {
				Profesor profesor = modelo.getProfesorByProfesorUsername(director.getProfesores().get(opcionInfoProfesor));
				
				int opcionActualizar = -1;
				while (opcionActualizar != 2) {
					try {
						opcionActualizar = Integer.parseInt(consolePrint.verProfe(profesor));

						if (opcionActualizar == 1) {
							profesor = consolePrint.actualProfe(profesor);
							modelo.modifyProfesor(profesor);
							consolePrint.profesorActualizado();
						} else if (opcionActualizar == 2) {
							continue;
						} else {
							consolePrint.errorSolicitudOpcion();
						}
					} catch (NumberFormatException e) {
						consolePrint.errorSolicitudOpcion();
					}
				}
			} else {
				consolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			consolePrint.errorSolicitudOpcion();
		}
	}
}
