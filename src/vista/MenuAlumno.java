package vista;

import modelos.Director;
import modelos.Modelo;

public class MenuAlumno {
	ConsolePrint consolePrint = new ConsolePrint();
	GestionarProfesores gestionarProfesores = new GestionarProfesores();
	GestionarAsignaturas gestionarAsignaturas = new GestionarAsignaturas();
	GestionarAlumnos gestionarAlumnos = new GestionarAlumnos();
	Modelo modelo = new Modelo();
	
	public void gestionarAsignaturas(String usuario) {
		int opcionDirectorAsignaturas = -1;
		
		Director director = modelo.getDirectorByDirectorUsername(usuario);
		if (director.getAsignaturas().size() == 0 ) {
			while (opcionDirectorAsignaturas != 2) {
				try {
					opcionDirectorAsignaturas = Integer.parseInt(consolePrint.errorAsignaturasEnCampusVacio());
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionDirectorAsignaturas == 1) {
					gestionarAsignaturas.crearAsignatura();
				} else if (opcionDirectorAsignaturas == 2) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			while (opcionDirectorAsignaturas != 4) {
				try {
					opcionDirectorAsignaturas = Integer.parseInt(consolePrint.gestionarAsignaturasDirector(director.getAsignaturas()));
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionDirectorAsignaturas == 1) {
					gestionarAsignaturas.crearAsignatura();
				} else if (opcionDirectorAsignaturas == 2) {
					gestionarAsignaturas.asignarProfeAsignatura();
				} else if (opcionDirectorAsignaturas == 3) {
					gestionarAsignaturas.obtenerAsignatura();
				} else if (opcionDirectorAsignaturas == 4) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		}
	}
}
