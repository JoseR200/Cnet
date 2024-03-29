package modelos;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	private String usuarioProfesor;
	private List<String> asignaturas;
	
	public Profesor(String usuarioProfesor) {
		this.usuarioProfesor = usuarioProfesor;
		this.asignaturas = new ArrayList<>();
	}
	
	public String getUsuarioProfesor() {
		return usuarioProfesor;
	}
	public void setUsuarioProfesor(String usuarioProfesor) {
		this.usuarioProfesor = usuarioProfesor;
	}
	
	public List<String> getAsignaturas() {
		return asignaturas;
	}
	public void addAsignatura(String asignatura) {
    	this.asignaturas.add(asignatura);
    }
}