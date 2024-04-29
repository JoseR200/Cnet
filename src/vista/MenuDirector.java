package vista;

import java.util.List;

import modelos.Alumno;
import modelos.Director;
import modelos.Modelo;

public class MenuDirector {
    GestionarProfesores gestionarProfesores = new GestionarProfesores();
    GestionarAsignaturas gestionarAsignaturas = new GestionarAsignaturas();
    GestionarAlumnos gestionarAlumnos = new GestionarAlumnos();
    Modelo modelo = new Modelo();

    public void gestionarProfesores(String user) {
        int opcionDirectorProfesores = -1;

        Director director = modelo.getDirectorByDirectorUsername(user);
        if (director.getProfesores().isEmpty()) {
            while (opcionDirectorProfesores != 2) {
                try {
                    opcionDirectorProfesores = Integer.parseInt(ConsolePrint.errorProfesoresEnCampusVacio());
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                    continue;
                }

                if (opcionDirectorProfesores == 1) {
                    gestionarProfesores.crearProfesor(director);
                    opcionDirectorProfesores = 2;
                } else if (opcionDirectorProfesores == 2) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
            return;
        } else {
            while (opcionDirectorProfesores != 4) {
                try {
                    opcionDirectorProfesores = Integer.parseInt(ConsolePrint.gestionarProfesoresDirector(director.getProfesores()));
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                    continue;
                }

                if (opcionDirectorProfesores == 1) {
                    gestionarProfesores.crearProfesor(director);
                } else if (opcionDirectorProfesores == 2) {
                    gestionarProfesores.despedirProfesor(director);
                } else if (opcionDirectorProfesores == 3) {
                    gestionarProfesores.obtenerProfesor(director);
                } else if (opcionDirectorProfesores == 4) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
        }
    }

    public void gestionarAsignaturas(String user) {
        int opcionDirectorAsignaturas = -1;

        Director director = modelo.getDirectorByDirectorUsername(user);
        if (director.getAsignaturas().isEmpty()) {
            while (opcionDirectorAsignaturas != 2) {
                try {
                    opcionDirectorAsignaturas = Integer.parseInt(ConsolePrint.errorAsignaturasEnCampusVacio());
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                    continue;
                }

                if (opcionDirectorAsignaturas == 1) {
                    gestionarAsignaturas.crearAsignatura(director);
                    opcionDirectorAsignaturas = 2;
                } else if (opcionDirectorAsignaturas == 2) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
        } else {
            while (opcionDirectorAsignaturas != 4) {
                try {
                    opcionDirectorAsignaturas = Integer.parseInt(ConsolePrint.gestionarAsignaturasDirector(director.getAsignaturas()));
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                    continue;
                }

                if (opcionDirectorAsignaturas == 1) {
                    gestionarAsignaturas.crearAsignatura(director);
                } else if (opcionDirectorAsignaturas == 2) {
                    gestionarAsignaturas.asignarProfeAsignatura(director);
                } else if (opcionDirectorAsignaturas == 3) {
                	//TODO CUARTO NIVEL CREAR GRUPO DE CALIFICACIONES Y OBTENER GRUPO DE CALIFICACIONES
                    gestionarAsignaturas.obtenerAsignatura(director);
                } else if (opcionDirectorAsignaturas == 4) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
        }
    }

    public void gestionarAlumnos() {
        int opcionDirectorAlumnos = -1;

        List<Alumno> alumnos = modelo.readAlumnosFromJson();

        if (alumnos.size() == 0) {
            while (opcionDirectorAlumnos != 2) {
                try {
                    opcionDirectorAlumnos = Integer.parseInt(ConsolePrint.errorAlumnosEnCampusVacio());
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                    continue;
                }

                if (opcionDirectorAlumnos == 1) {
                    gestionarAlumnos.crearAlumno();
                    opcionDirectorAlumnos = 2;
                } else if (opcionDirectorAlumnos == 2) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
        } else {
            while (opcionDirectorAlumnos != 5) {
                try {
                    opcionDirectorAlumnos = Integer.parseInt(ConsolePrint.gestionarAlumnosDirector());
                } catch (NumberFormatException e) {
                    ConsolePrint.errorSolicitudOpcion();
                    continue;
                }

                if (opcionDirectorAlumnos == 1) {
                    gestionarAlumnos.crearAlumno();
                } else if (opcionDirectorAlumnos == 2) {
                    gestionarAlumnos.asignarAlumnoAsignatura();
                } else if (opcionDirectorAlumnos == 3) {
                	//TODO CUARTO NIVEL DE OBTENER UNA ASIGNATURA Y QUINTO NIVEL ACTUALIZAR CALIFICACION ALUMNO
                    gestionarAlumnos.obtenerAlumno();
                } else if (opcionDirectorAlumnos == 4) {
                    gestionarAlumnos.obtenerAlumnos();
                } else if (opcionDirectorAlumnos == 5) {
                    continue;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
        }
    }
}
