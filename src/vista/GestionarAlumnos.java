package vista;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Modelo;

import java.util.List;
import java.util.Objects;

public class GestionarAlumnos {
    Modelo modelo = new Modelo();

    public void crearAlumno() {
        if (modelo.writeAlumno(ConsolePrint.crearAlumno())) {
            ConsolePrint.alumnoCreado();
        } else {
            ConsolePrint.errorCrearAlumno();
        }
    }

    public void asignarAlumnoAsignatura() {
        String[] alumnoAsignatura = ConsolePrint.asignarAlumnoAsignatura();
        
        if (modelo.existeAlumnoExisteAsignatura(alumnoAsignatura[0], alumnoAsignatura[1])) {            
            Alumno alumno = modelo.getAlumnoByAlumnoUsername(alumnoAsignatura[0]);
			alumno.addAsignatura(alumnoAsignatura[1]);
			
			Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(alumnoAsignatura[1]);
			asignatura.addAlumno(alumnoAsignatura[0]);
			
			modelo.modifyAlumno(alumno);
			modelo.modifyAsignatura(asignatura);
			
			ConsolePrint.alumnoAsignado();
        } else {
            ConsolePrint.errorAsignarAlumno();
        }
    }

    public void obtenerAlumno() {
        String alumnoString = ConsolePrint.ingresarAlumno().trim();
        
        if (modelo.existeAlumno(alumnoString)) {
        	Alumno alumno = modelo.getAlumnoByAlumnoUsername(alumnoString);
        	
            ConsolePrint.verAlumno(alumno);
        } else {
            ConsolePrint.errorSolicitudOpcion();
        }

    }

    public void obtenerAlumnos() {
    	List<Alumno> alumnos = modelo.readAlumnosFromJson();

    	for (int i = 0; i < alumnos.size();) {
    		for (int j = 0; j < 5; j++) {
                if (i >= alumnos.size()) {
                    break;
                }
                ConsolePrint.verAlumno(alumnos.get(i));
                i++;
            }
    		if (i < alumnos.size()) {
                var opcion = ConsolePrint.verMasAlumnos(i, alumnos.size());
                if (Objects.equals(opcion, "0")) {
                    i = alumnos.size();
                }
            }
        }
    }
}
