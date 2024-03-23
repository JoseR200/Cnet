package vista;

import modelos.DirectorProfesores;
import modelos.Modelo;

public class Main {
	public static void main(String[] args) {
		ConsolePrint consolePrint = new ConsolePrint();
		Modelo modelo = new Modelo();
		int opcionInicioDeSesion = -1;
		String[] credenciales;
		
		consolePrint.bienvenida();
		
		while (opcionInicioDeSesion != 4) {
			try {
				opcionInicioDeSesion = Integer.parseInt(consolePrint.menuPrincipal());
			} catch (NumberFormatException e) {
				consolePrint.errorSolicitudOpcion();
				continue;
			}
			
			if (opcionInicioDeSesion == 1) {
				credenciales = consolePrint.inicioSesion();
				if (modelo.loginDirector(credenciales)) {
					int opcionDirector = -1;
					
					consolePrint.bienvenidaDirector();
					
					while (opcionDirector != 3) {
						try {
							opcionDirector = Integer.parseInt(consolePrint.menuDirector());
						} catch (NumberFormatException e) {
							consolePrint.errorSolicitudOpcion();
							continue;
						}
						
						if (opcionDirector == 1) {
							int opcionDirectorProfesores = -1;
							
							DirectorProfesores directorProfesores = modelo.getDirectorProfesoresByDirectorUsername(credenciales[0]);
							if (directorProfesores.getProfesores().size() == 0 ) {
								while (opcionDirectorProfesores != 2) {
									try {
										opcionDirectorProfesores = Integer.parseInt(consolePrint.errorProfesoresEnCampusVacio());
									} catch (NumberFormatException e) {
										consolePrint.errorSolicitudOpcion();
										continue;
									}
									
									if (opcionDirectorProfesores == 1) {
										if (modelo.writeProfesor(consolePrint.crearProfe(), directorProfesores)) {
											modelo.modifyDirectorProfesores(directorProfesores);
											consolePrint.profesorCreado();
											break;
										} else {
											consolePrint.errorCrearProfesor();
											continue;
										}
									} else if (opcionDirectorProfesores == 2) {
										continue;
									} else {
										consolePrint.errorSolicitudOpcion();
										continue;
									}
								}
							} else {
								while (opcionDirectorProfesores != 3) {
									try {
										opcionDirectorProfesores = Integer.parseInt(consolePrint.gestionarProfesoresDirector(directorProfesores.getProfesores()));
									} catch (NumberFormatException e) {
										consolePrint.errorSolicitudOpcion();
										continue;
									}
									
									if (opcionDirectorProfesores == 1) {
										consolePrint.verProfe();
									} else if (opcionDirectorProfesores == 2) {
										if (modelo.writeProfesor(consolePrint.crearProfe(), directorProfesores)) {
											modelo.modifyDirectorProfesores(directorProfesores);
											consolePrint.profesorCreado();
										} else {
											consolePrint.errorCrearProfesor();
											continue;
										}
									} else if (opcionDirectorProfesores == 3) {
										continue;
									} else {
										consolePrint.errorSolicitudOpcion();
										continue;
									}
								}
							}
						} else if (opcionDirector == 2) {
							consolePrint.gestionarAsignaturasDirector();
						} else if (opcionDirector == 3) {
							continue;
						} else {
							consolePrint.errorSolicitudOpcion();
						}
					}
				} else {
					consolePrint.errorInicioSesion();
				}
			} else if (opcionInicioDeSesion == 2) {
				credenciales = consolePrint.inicioSesion();
				if (modelo.loginProfesor(credenciales)) {
					int opcionProfesor = -1;
					
					consolePrint.bienvenidaProfesor();
					
					while (opcionProfesor != 3) {
						try {
							opcionProfesor = Integer.parseInt(consolePrint.menuProfesor());
						} catch (NumberFormatException e) {
							consolePrint.errorSolicitudOpcion();
							continue;
						}
						
						if (opcionProfesor == 1) {
							consolePrint.gestionarAsignaturasProfesor();
						} else if (opcionProfesor == 2) {
							//TO DO
						} else if (opcionProfesor == 3) {
							continue;
						} else {
							consolePrint.errorSolicitudOpcion();
						}
					}
				} else {
					consolePrint.errorInicioSesion();
				}
			} else if (opcionInicioDeSesion == 3) {
				credenciales = consolePrint.inicioSesion();
				if (modelo.loginAlumno(credenciales)) {
					int opcionAlumno = -1;
					
					consolePrint.bienvenidaAlumno();
					
					while (opcionAlumno != 3) {
						try {
							opcionAlumno = Integer.parseInt(consolePrint.menuAlumno());
						} catch (NumberFormatException e) {
							consolePrint.errorSolicitudOpcion();
							continue;
						}
						
						if (opcionAlumno == 1) {
							consolePrint.gestionarAsignaturasAlumno();
						} else if (opcionAlumno == 2) {
							// TO DO
						} else if (opcionAlumno == 3) {
							continue;
						} else {
							consolePrint.errorSolicitudOpcion();
						}
					}
				} else {
					consolePrint.errorInicioSesion();
				}
			} else if (opcionInicioDeSesion == 4) {
				continue;
			} else {
				consolePrint.errorSolicitudOpcion();
			}
		}
		
		consolePrint.cerrarPrograma();
	}
}
