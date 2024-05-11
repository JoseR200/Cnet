package vista;

import java.util.List;

import modelos.Asignatura;
import modelos.Calificacion;
import modelos.Director;
import modelos.Modelo;
import modelos.Profesor;

public class GestionarAsignaturas {
    Modelo modelo = new Modelo();

    public void crearAsignatura(Director director) {
        if (modelo.writeAsignatura(ConsolePrint.crearAsignatura(), director)) {
            modelo.modifyDirector(director);
            ConsolePrint.asignaturaCreado();
        } else {
            ConsolePrint.errorCrearAsignatura();
        }
    }

    public void asignarProfeAsignatura(Director director) {
        String[] profesorAsignatura = ConsolePrint.asignarProfesorAsignatura();

        if (modelo.existeProfesorExisteAsignatura(profesorAsignatura[0], profesorAsignatura[1])) {
            Profesor profesor = modelo.getProfesorByProfesorUsername(profesorAsignatura[0]);
            profesor.addAsignatura(profesorAsignatura[1]);

            Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(profesorAsignatura[1]);
            asignatura.setUserProfesor(profesorAsignatura[0]);

            modelo.modifyProfesor(profesor);
            modelo.modifyAsignatura(asignatura);

            ConsolePrint.profesorAsignado();
        } else {
            ConsolePrint.errorAsignarProfe();
        }
    }

    public void obtenerAsignatura(Director director) {
        int opcionInfoAsignatura = -1;

        try {
            opcionInfoAsignatura = Integer.parseInt(ConsolePrint.ingresarIndiceAsignatura());

            if (opcionInfoAsignatura < director.getAsignaturas().size() && opcionInfoAsignatura >= 0) {
                Asignatura asignatura = modelo.getAsignaturaByAsignaturaName(director.getAsignaturas().get(opcionInfoAsignatura));
                                
                int opcionObtener = -1;
				while (opcionObtener != 3) {
					try {
						opcionObtener = Integer.parseInt(ConsolePrint.verAsignatura(asignatura));

						if (opcionObtener == 1) {
							if (asignatura.getAlumnos().size() > 0) {
								if (ConsolePrint.crearCalificacion(asignatura)) {
									modelo.modifyAsignatura(asignatura);
								}
							} else {
								ConsolePrint.errorCrearCalificacion();
							}
						} else if (opcionObtener == 2) {
                            List<Calificacion> calificaciones = asignatura.getCalificaciones();
                            if (!calificaciones.isEmpty()) {
                                
                                double maxNota = calificaciones.stream()
                                                               .flatMap(calificacion -> calificacion.getNotas().stream())
                                                               .mapToDouble(Double::doubleValue)
                                                               .max()
                                                               .orElse(Double.NaN); 
                                double minNota = calificaciones.stream()
                                                               .flatMap(calificacion -> calificacion.getNotas().stream())
                                                               .mapToDouble(Double::doubleValue)
                                                               .min()
                                                               .orElse(Double.NaN);
                                double mediaNota = calificaciones.stream()
                                                                 .flatMap(calificacion -> calificacion.getNotas().stream())
                                                                 .mapToDouble(Double::doubleValue)
                                                                 .average()
                                                                 .orElse(Double.NaN); 
                        
                                if (!Double.isNaN(maxNota)) { 
                                    ConsolePrint.mostrarEstadisticasCalificaciones(maxNota, minNota, mediaNota);
                                } else {
                                    ConsolePrint.errorNoCalificaciones();
                                }
                            } else {
                                ConsolePrint.errorNoCalificaciones();
                            }
						} else if (opcionObtener == 3) {
							continue;
						} else {
							ConsolePrint.errorSolicitudOpcion();
						}
					} catch (NumberFormatException e) {
						ConsolePrint.errorSolicitudOpcion();
					}
				}
            } else {
                ConsolePrint.errorSolicitudOpcion();
            }
        } catch (NumberFormatException e) {
            ConsolePrint.errorSolicitudOpcion();
        }
    }
}
