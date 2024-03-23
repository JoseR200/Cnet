package modelos;

import java.util.ArrayList;
import java.util.List;

public class DirectorProfesores {
	private String usuarioDirector;
	private List<String> profesores;
	public DirectorProfesores(String usuarioDirector) {
		this.usuarioDirector = usuarioDirector;
		this.profesores = new ArrayList<>();
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
}
