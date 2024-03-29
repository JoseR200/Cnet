package vista;

import modelos.Director;
import modelos.Modelo;

public class MenuDirector {
	ConsolePrint consolePrint = new ConsolePrint();
	GestionarProfesores gestionarProfesores = new GestionarProfesores();
	GestionarAsignaturas gestionarAsignaturas = new GestionarAsignaturas();
	GestionarAlumnos gestionarAlumnos = new GestionarAlumnos();
	Modelo modelo = new Modelo();
	
	public void gestionarProfesores(String usuario) {
		int opcionDirectorProfesores = -1;
		
		Director director = modelo.getDirectorByDirectorUsername(usuario);
		if (director.getProfesores().size() == 0 ) {
			while (opcionDirectorProfesores != 2) {
				try {
					opcionDirectorProfesores = Integer.parseInt(consolePrint.errorProfesoresEnCampusVacio());
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionDirectorProfesores == 1) {
					gestionarProfesores.crearProfesor(director);
					opcionDirectorProfesores = 2;
				} else if (opcionDirectorProfesores == 2) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			while (opcionDirectorProfesores != 4) {
				try {
					opcionDirectorProfesores = Integer.parseInt(consolePrint.gestionarProfesoresDirector(director.getProfesores()));
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionDirectorProfesores == 1) {
					gestionarProfesores.crearProfesor(director);
				} else if (opcionDirectorProfesores == 2) {
					//TO DO
					gestionarProfesores.despedirProfesor();
				} else if (opcionDirectorProfesores == 3) {
					//TO DO
					gestionarProfesores.obtenerProfesor();
				} else if (opcionDirectorProfesores == 4) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		}
	}
	
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
	
	public void gestionarAlumnos() {
		int opcionDirectorAlumnos = -1;
		
		while (opcionDirectorAlumnos != 4) {
			try {
				opcionDirectorAlumnos = Integer.parseInt(consolePrint.gestionarAlumnosDirector());
			} catch (NumberFormatException e) {
				consolePrint.errorSolicitudOpcion();
				continue;
			}
			
			if (opcionDirectorAlumnos == 1) {
				gestionarAlumnos.crearAlumno();
			} else if (opcionDirectorAlumnos == 2) {
				gestionarAlumnos.asignarAlumnoAsignatura();
			} else if (opcionDirectorAlumnos == 3) {
				gestionarAlumnos.obtenerAlumno();
			} else if (opcionDirectorAlumnos == 4) {
				continue;
			} else {
				consolePrint.errorSolicitudOpcion();
			}
		}
	}
}
