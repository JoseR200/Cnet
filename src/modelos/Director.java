package modelos;

import java.util.ArrayList;
import java.util.List;

public class Director {
	private String usuarioDirector;
	private List<String> profesores;
	private List<String> asignaturas;
	
	public Director(String usuarioDirector) {
		this.usuarioDirector = usuarioDirector;
		this.profesores = new ArrayList<>();
		this.asignaturas = new ArrayList<>();
	}
	
	public String getUsuarioDirector() {
		return usuarioDirector;
	}
	public void setUsuarioDirector(String usuarioDirector) {
		this.usuarioDirector = usuarioDirector;
	}
	
	public List<String> getProfesores() {
		return profesores;
	}
	public void addProfesor(String profesor) {
    	this.profesores.add(profesor);
    }
	public void deleteProfesor(String profesor) {
    	this.profesores.remove(profesor);
    }
	
	public List<String> getAsignaturas() {
		return asignaturas;
	}
	public void addAsignatura(String asignatura) {
    	this.asignaturas.add(asignatura);
    }
}
