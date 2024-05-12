package vista;

import java.util.List;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
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
					menuProfesor.gestionarPerfil(credenciales[0]);
				} else if (opcionProfesor == 2) {
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
			Alumno alumno = modelo.getAlumnoByAlumnoUsername(credenciales[0]);

			ConsolePrint.bienvenidaAlumno();
			
			double sumaMediaFinal = 0;
			for (String a: alumno.getAsignaturas()) {
				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(a);
				
				List<Calificacion> calificaciones = asignatura.getCalificaciones();
	            int indexAlumno = asignatura.getAlumnos().indexOf(alumno.getUsuario());

	            double sumaNotas = 0;
	            for (Calificacion cal : calificaciones) {
	                sumaNotas += cal.getNotas().get(indexAlumno);
	            }
	            sumaNotas = sumaNotas / calificaciones.size();
	            
	            sumaMediaFinal += sumaNotas;
			}
			sumaMediaFinal = sumaMediaFinal / alumno.getAsignaturas().size();
			
			while (opcionAlumno != 2) {
				try {
					opcionAlumno = Integer.parseInt(ConsolePrint.menuAlumno(alumno, sumaMediaFinal));
				} catch (NumberFormatException e) {
					ConsolePrint.errorSolicitudOpcion();
					continue;
				}
				
				if (opcionAlumno == 1) {
					menuAlumno.gestionarAsignaturas(alumno);
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
