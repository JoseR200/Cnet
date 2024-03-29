package vista;

public class Main {
	public static void main(String[] args) {
		ConsolePrint consolePrint = new ConsolePrint();
		MenuInicioSesion menuInicioSesion = new MenuInicioSesion();
		int opcionInicioDeSesion = -1;
		
		consolePrint.bienvenida();
		
		while (opcionInicioDeSesion != 4) {
			try {
				opcionInicioDeSesion = Integer.parseInt(consolePrint.menuPrincipal());
			} catch (NumberFormatException e) {
				consolePrint.errorSolicitudOpcion();
				continue;
			}
			
			if (opcionInicioDeSesion == 1) {
				menuInicioSesion.menuInicioSesionDirector();
			} else if (opcionInicioDeSesion == 2) {
				menuInicioSesion.menuInicioSesionProfesor();				
			} else if (opcionInicioDeSesion == 3) {
				menuInicioSesion.menuInicioSesionAlumno();
			} else if (opcionInicioDeSesion == 4) {
				continue;
			} else {
				consolePrint.errorSolicitudOpcion();
			}
		}
		consolePrint.cerrarPrograma();
	}
}
