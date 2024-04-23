package vista;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Modelo;

public class MenuAlumno {
	Modelo modelo = new Modelo();

	public void gestionarAsignaturas(Alumno alumno) {
		int opcionObtenerAsignatura = -1;
		
		try {
			opcionObtenerAsignatura = Integer.parseInt(ConsolePrint.ingresarIndiceAsignaturaAlumno());
			
			if (opcionObtenerAsignatura < alumno.getAsignaturas().size() && opcionObtenerAsignatura >= 0) {
				Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(alumno.getAsignaturas().get(opcionObtenerAsignatura));
				
				ConsolePrint.verAsignaturaAlumno(asignatura);
			} else {
				ConsolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			ConsolePrint.errorSolicitudOpcion();
		}
	}
}
