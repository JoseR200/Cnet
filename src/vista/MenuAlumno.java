package vista;

import java.util.ArrayList;
import java.util.List;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
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
				
				int indexAlumno = asignatura.getAlumnos().indexOf(alumno.getUsuario());
				
				List<Double> notas = new ArrayList<>();
                
                for (Calificacion c : asignatura.getCalificaciones()) {
                    notas.add(c.getNotas().get(indexAlumno));
                }
    
                ConsolePrint.mostrarNotas(alumno, asignatura, notas);
			} else {
				ConsolePrint.errorSolicitudOpcion();
			}
		} catch (NumberFormatException e) {
			ConsolePrint.errorSolicitudOpcion();
		}
	}
}
