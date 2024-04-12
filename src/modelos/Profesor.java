package modelos;

import java.util.ArrayList;
import java.util.List;

public final class Profesor extends Entity {
	private List<String> asignaturas;
	
	public Profesor(String usuario) {
		super();
		this.usuario = usuario;
		this.asignaturas = new ArrayList<>();
	}
	public Profesor() {
		super();
		this.asignaturas = new ArrayList<>();
	}
	
	public List<String> getAsignaturas() {
		return asignaturas;
	}
	public void addAsignatura(String asignatura) {
    	this.asignaturas.add(asignatura);
    }
}