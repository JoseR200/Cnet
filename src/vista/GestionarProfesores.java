package vista;

import modelos.Director;
import modelos.Modelo;

public class GestionarProfesores {
	ConsolePrint consolePrint = new ConsolePrint();
	Modelo modelo = new Modelo();
	
	public void crearProfesor(Director director) {
		if (modelo.writeProfesor(consolePrint.crearProfe(), director)) {
			modelo.modifyDirectorProfesores(director);
			consolePrint.profesorCreado();
		} else {
			consolePrint.errorCrearProfesor();
		}
	}
	
	public void despedirProfesor() {
		
	}
	
	public void obtenerProfesor() {
		
	}
}
