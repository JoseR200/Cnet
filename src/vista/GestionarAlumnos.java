package vista;

import modelos.Alumno;
import modelos.Modelo;

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
        if (!modelo.existeAlumnoExisteAsignatura(alumnoAsignatura[0], alumnoAsignatura[1])) {
            modelo.addAlumnoAsignatura(alumnoAsignatura[0], alumnoAsignatura[1]);
            ConsolePrint.alumnoAsignado();
        } else {
            ConsolePrint.errorAsignarAlumno();
        }
    }

    public void obtenerAlumno() {
        String alumno = ConsolePrint.ingresarAlumno();
        if (modelo.existeAlumno(alumno)) {
            ConsolePrint.verAlumno(modelo.getAlumnoByAlumnoUsername(alumno));
        } else {
            ConsolePrint.errorSolicitudOpcion();
        }

    }

    public void obtenerAlumnos() {
        Alumno[] alumnos = modelo.getAlumnos();

        var i = 0;
        while (i < alumnos.length) {
            for (int j = 0; j < 5; j++) {
                if (i >= alumnos.length) {
                    break;
                }
                ConsolePrint.verAlumno(alumnos[i]);
                i++;
            }
            if (i < alumnos.length) {
                var opcion = ConsolePrint.verMasAlumnos(i, alumnos.length);
                if (Objects.equals(opcion, "0")) {
                    i = alumnos.length;
                }
            }
        }
    }
}
