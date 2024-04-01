package modelos;

import java.util.ArrayList;
import java.util.List;

public class Director {
	private String nombre;
	private String apellido;
	private String usuario;
	private String contraseña;
	private String dni;
	private List<String> profesores;
	private List<String> asignaturas;
	
	public Director(String usuario) {
		this.usuario = usuario;
		this.profesores = new ArrayList<>();
		this.asignaturas = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
