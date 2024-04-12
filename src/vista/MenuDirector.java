package vista;

import modelos.Director;
import modelos.Modelo;

import java.util.stream.Collectors;

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
                    break;
                } else {
                    ConsolePrint.errorSolicitudOpcion();
                }
            }
            return;
        }
        while (true) {
            try {
                opcionDirectorProfesores = Integer.parseInt(ConsolePrint.gestionarProfesoresDirector(director.getProfesores()));
            } catch (NumberFormatException e) {
                ConsolePrint.errorSolicitudOpcion();
                continue;
            }
            if (opcionDirectorProfesores == 0) {
                break;
            }

            switch (opcionDirectorProfesores) {
                case 1:
                    gestionarProfesores.crearProfesor(director);
                    break;
                case 2:
                    gestionarProfesores.despedirProfesor(director);
                    break;
                case 3:
                    //TODO CUARTO NIVEL DE ACTUALIZAR INFORMACION DE PROFESOR
                    gestionarProfesores.obtenerProfesor(director);
                    break;
                case 4:
                    var exportFormat = ConsolePrint.exportarProfesores();
                    var profesores = director.getProfesores().stream().map(
                            (professor) -> modelo.getProfesorByProfesorUsername(professor)
                    ).collect(Collectors.toList());
                    switch (exportFormat) {
                        case "CSV":
                            Modelo.Export(profesores, Modelo.ExportFormat.CSV, "profesores");
                            break;
                        case "JSON":
                            Modelo.Export(profesores, Modelo.ExportFormat.JSON, "profesores");
                            break;
                        case "XML":
                            Modelo.Export(profesores, Modelo.ExportFormat.XML, "profesores");
                            break;
                        default:
                            ConsolePrint.errorSolicitudOpcion();
                            break;
                    }
                    break;
                default:
                    ConsolePrint.errorSolicitudOpcion();
                    break;
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
                    gestionarAsignaturas.asignarProfeAsignatura();
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

        while (opcionDirectorAlumnos != 4) {
            try {
                opcionDirectorAlumnos = Integer.parseInt(ConsolePrint.gestionarAlumnosDirector());
            } catch (NumberFormatException e) {
                ConsolePrint.errorSolicitudOpcion();
                continue;
            }

            if (opcionDirectorAlumnos == 0) {
                break;
            }
            if (opcionDirectorAlumnos == 1) {
                //TODO falta hacer todo
                gestionarAlumnos.crearAlumno();
            } else if (opcionDirectorAlumnos == 2) {
                //TODO falta hacer todo
                gestionarAlumnos.asignarAlumnoAsignatura();
            } else if (opcionDirectorAlumnos == 3) {
                //TODO falta hacer todo
                gestionarAlumnos.obtenerAlumno();
            } else if (opcionDirectorAlumnos == 4) {
                gestionarAlumnos.obtenerAlumnos();
            } else {
                ConsolePrint.errorSolicitudOpcion();
            }
        }
    }
}
