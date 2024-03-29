package modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String usuarioAlumno;
	private List<String> asignaturas;
	
	public Alumno(String usuarioAlumno) {
		this.usuarioAlumno = usuarioAlumno;
		this.asignaturas = new ArrayList<>();
	}
	
	public String getUsuarioAlumno() {
		return usuarioAlumno;
	}
	public void setUsuarioAlumno(String usuarioAlumno) {
		this.usuarioAlumno = usuarioAlumno;
	}
	
	public List<String> getAsignaturas() {
		return asignaturas;
	}
	public void addAsignatura(String asignatura) {
    	this.asignaturas.add(asignatura);
    }
}