package vista;

import modelos.Modelo;

public class MenuInicioSesion {
	ConsolePrint consolePrint = new ConsolePrint();
	MenuDirector menuDirector = new MenuDirector();
	MenuProfesor menuProfesor = new MenuProfesor();
	MenuAlumno menuAlumno = new MenuAlumno();
	Modelo modelo = new Modelo();
	
	String[] credenciales;
	
	public void menuInicioSesionDirector() {
		credenciales = consolePrint.inicioSesion();
		if (modelo.loginDirector(credenciales)) {
			int opcionDirector = -1;
			
			consolePrint.bienvenidaDirector();
			
			while (opcionDirector != 4) {
				try {
					opcionDirector = Integer.parseInt(consolePrint.menuDirector());
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionDirector == 1) {
					menuDirector.gestionarProfesores(credenciales[0]);
				} else if (opcionDirector == 2) {
					menuDirector.gestionarAsignaturas(credenciales[0]);
				} else if (opcionDirector == 3) {
					//TODO no se ha empezdo
					menuDirector.gestionarAlumnos();
				} else if (opcionDirector == 4) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			consolePrint.errorInicioSesion();
		}
	}
	
	public void menuInicioSesionProfesor() {
		credenciales = consolePrint.inicioSesion();
		if (modelo.loginProfesor(credenciales)) {
			int opcionProfesor = -1;
			
			consolePrint.bienvenidaProfesor();
			
			while (opcionProfesor != 3) {
				try {
					opcionProfesor = Integer.parseInt(consolePrint.menuProfesor());
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionProfesor == 1) {
					//TODO falta hacer todo
					menuProfesor.gestionarPerfil();
				} else if (opcionProfesor == 2) {
					//TODO falta hacer todo
					menuProfesor.gestionarAsignaturas(credenciales[0]);
				} else if (opcionProfesor == 3) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			consolePrint.errorInicioSesion();
		}
	}
	
	public void menuInicioSesionAlumno() {
		credenciales = consolePrint.inicioSesion();
		if (modelo.loginAlumno(credenciales)) {
			int opcionAlumno = -1;
			
			consolePrint.bienvenidaAlumno();
			
			while (opcionAlumno != 2) {
				try {
					opcionAlumno = Integer.parseInt(consolePrint.menuAlumno());
				} catch (NumberFormatException e) {
					consolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionAlumno == 1) {
					//TODO falta hacer todo
					menuAlumno.gestionarAsignaturas(credenciales[0]);
				} else if (opcionAlumno == 2) {
					continue;
				} else {
					consolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			consolePrint.errorInicioSesion();
		}
	}
}
