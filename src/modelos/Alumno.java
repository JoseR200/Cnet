package modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private String apellido;
	private String usuario;
	private String contraseña;
	private String dni;
	private List<String> asignaturas;
	
	public Alumno(String usuario) {
		this.usuario = usuario;
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
	
	public List<String> getAsignaturas() {
		return asignaturas;
	}
	public void addAsignatura(String asignatura) {
    	this.asignaturas.add(asignatura);
    }
}