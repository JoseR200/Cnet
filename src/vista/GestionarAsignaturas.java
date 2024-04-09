package vista;

import modelos.Asignatura;
import modelos.Director;
import modelos.Modelo;
import modelos.Profesor;

public class GestionarAsignaturas {
	Modelo modelo = new Modelo();
	
	public void crearAsignatura(Director director) {
		if (modelo.writeAsignatura(ConsolePrint.crearAsignatura(), director)) {
			modelo.modifyDirector(director);
			ConsolePrint.asignaturaCreado();
		} else {
			ConsolePrint.errorCrearAsignatura();
		}
	}
	
	public void asignarProfeAsignatura() {
		String[] profesorAsignatura = ConsolePrint.asignarProfesorAsignatura();
		if (modelo.existeProfesorExisteAsignatura(profesorAsignatura[0], profesorAsignatura[1])) {
			Profesor profesor = modelo.getProfesorByProfesorUsername(profesorAsignatura[0]);
			profesor.addAsignatura(profesorAsignatura[1]);
			
			Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(profesorAsignatura[1]);
			asignatura.setUserProfesor(profesorAsignatura[0]);
			
			modelo.modifyProfesor(profesor);
			modelo.modifyAsignatura(asignatura);
			
			ConsolePrint.profesorAsignado();
		} else {
			ConsolePrint.errorAsignarProfe();
		}
	}
	
	public void obtenerAsignatura(Director director) {
		int opcionInfoAsignatura = -1;
		
		try {
			opcionInfoAsignatura = Integer.parseInt(ConsolePrint.ingresarIndiceAsignatura());
			
			if (opcionInfoAsignatura < director.getAsignaturas().size() && opcionInfoAsignatura >= 0) {
				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(director.getAsignaturas().get(opcionInfoAsignatura));
				
				ConsolePrint.verAsignatura(asignatura);
			} else {
				ConsolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			ConsolePrint.errorSolicitudOpcion();
		}
	}
}
