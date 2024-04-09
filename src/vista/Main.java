package vista;

public class Main {
	public static void main(String[] args) {
		MenuInicioSesion menuInicioSesion = new MenuInicioSesion();
		int opcionInicioDeSesion = -1;
		
		ConsolePrint.bienvenida();
		
		while (opcionInicioDeSesion != 4) {
			try {
				opcionInicioDeSesion = Integer.parseInt(ConsolePrint.menuPrincipal());
			} catch (NumberFormatException e) {
				ConsolePrint.errorSolicitudOpcion();
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
				ConsolePrint.errorSolicitudOpcion();
			}
		}
		ConsolePrint.cerrarPrograma();
	}
}
