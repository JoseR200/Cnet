package vista;

import modelos.Asignatura;
import modelos.Director;
import modelos.Modelo;
import modelos.Profesor;

public class GestionarAsignaturas {
	ConsolePrint consolePrint = new ConsolePrint();
	Modelo modelo = new Modelo();
	
	public void crearAsignatura(Director director) {
		if (modelo.writeAsignatura(consolePrint.crearAsignatura(), director)) {
			modelo.modifyDirector(director);
			consolePrint.asignaturaCreado();
		} else {
			consolePrint.errorCrearAsignatura();
		}
	}
	
	public void asignarProfeAsignatura() {
		String[] profesorAsignatura = consolePrint.asignarProfesorAsignatura();
		if (modelo.existeProfesorExisteAsignatura(profesorAsignatura[0], profesorAsignatura[1])) {
			Profesor profesor = modelo.getProfesorByProfesorUsername(profesorAsignatura[0]);
			profesor.addAsignatura(profesorAsignatura[1]);
			
			Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(profesorAsignatura[1]);
			asignatura.setUserProfesor(profesorAsignatura[0]);
			
			modelo.modifyProfesor(profesor);
			modelo.modifyAsignatura(asignatura);
			
			consolePrint.profesorAsignado();
		} else {
			consolePrint.errorAsignarProfe();
		}
	}
	
	public void obtenerAsignatura(Director director) {
		int opcionInfoAsignatura = -1;
		
		try {
			opcionInfoAsignatura = Integer.parseInt(consolePrint.ingresarIndiceAsignatura());
			
			if (opcionInfoAsignatura < director.getAsignaturas().size() && opcionInfoAsignatura >= 0) {
				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(director.getAsignaturas().get(opcionInfoAsignatura));
				
				consolePrint.verAsignatura(asignatura);
			} else {
				consolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			consolePrint.errorSolicitudOpcion();
		}
	}
}
