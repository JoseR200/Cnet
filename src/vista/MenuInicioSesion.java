package vista;

import modelos.Modelo;

public class MenuInicioSesion {
	MenuDirector menuDirector = new MenuDirector();
	MenuProfesor menuProfesor = new MenuProfesor();
	MenuAlumno menuAlumno = new MenuAlumno();
	Modelo modelo = new Modelo();
	
	String[] credenciales;
	
	public void menuInicioSesionDirector() {
		credenciales = ConsolePrint.inicioSesion();
		if (modelo.loginDirector(credenciales)) {
			int opcionDirector = -1;
			
			ConsolePrint.bienvenidaDirector();
			
			while (opcionDirector != 4) {
				try {
					opcionDirector = Integer.parseInt(ConsolePrint.menuDirector());
				} catch (NumberFormatException e) {
					ConsolePrint.errorSolicitudOpcion();
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
					ConsolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			ConsolePrint.errorInicioSesion();
		}
	}
	
	public void menuInicioSesionProfesor() {
		credenciales = ConsolePrint.inicioSesion();
		if (modelo.loginProfesor(credenciales)) {
			int opcionProfesor = -1;
			
			ConsolePrint.bienvenidaProfesor();
			
			while (opcionProfesor != 3) {
				try {
					opcionProfesor = Integer.parseInt(ConsolePrint.menuProfesor());
				} catch (NumberFormatException e) {
					ConsolePrint.errorSolicitudOpcion();
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
					ConsolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			ConsolePrint.errorInicioSesion();
		}
	}
	
	public void menuInicioSesionAlumno() {
		credenciales = ConsolePrint.inicioSesion();
		if (modelo.loginAlumno(credenciales)) {
			int opcionAlumno = -1;
			
			ConsolePrint.bienvenidaAlumno();
			
			while (opcionAlumno != 2) {
				try {
					opcionAlumno = Integer.parseInt(ConsolePrint.menuAlumno());
				} catch (NumberFormatException e) {
					ConsolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionAlumno == 1) {
					//TODO falta hacer todo
					menuAlumno.gestionarAsignaturas(credenciales[0]);
				} else if (opcionAlumno == 2) {
					continue;
				} else {
					ConsolePrint.errorSolicitudOpcion();
				}
			}
		} else {
			ConsolePrint.errorInicioSesion();
		}
	}
}
