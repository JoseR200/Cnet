package vista;

import java.util.List;

import modelos.Asignatura;
import modelos.Director;
import modelos.Modelo;
import modelos.Profesor;

public class GestionarProfesores {
	Modelo modelo = new Modelo();
	
	public void crearProfesor(Director director) {
		if (modelo.writeProfesor(ConsolePrint.crearProfe(), director)) {
			modelo.modifyDirector(director);
			ConsolePrint.profesorCreado();
		} else {
			ConsolePrint.errorCrearProfesor();
		}
	}
	
	public void despedirProfesor(Director director) {
		String profeEliminar = ConsolePrint.despedirProfe();
		
		Boolean pedirReemplazo = modelo.profesorTieneAsignatura(profeEliminar);
		
		if (pedirReemplazo) {
			String profeReemplazo = ConsolePrint.reemplazoDeProfe();
			
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
				ConsolePrint.profesorEliminado();
			} else {
				ConsolePrint.errorEliminarProfesor();
			}
		} else {
			if (modelo.existeProfesor(profeEliminar)) {
				modelo.deleteProfesor(profeEliminar, director);
				modelo.modifyDirector(director);
				ConsolePrint.profesorEliminado();
			} else {
				ConsolePrint.errorEliminarProfesor();
			}
		}
	}
	
	public void obtenerProfesor(Director director) {
		int opcionInfoProfesor = -1;
		
		try {
			opcionInfoProfesor = Integer.parseInt(ConsolePrint.ingresarIndiceProfe());
			
			if (opcionInfoProfesor < director.getProfesores().size() && opcionInfoProfesor >= 0) {
				Profesor profesor = modelo.getProfesorByProfesorUsername(director.getProfesores().get(opcionInfoProfesor));
				
				int opcionActualizar = -1;
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
			} else {
				ConsolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			ConsolePrint.errorSolicitudOpcion();
		}
	}
}
