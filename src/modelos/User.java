package modelos;

public class User {
	private String nombre;
	private String apellido;
	private String usuario;
	private String contraseña;
	private String dni;
	
	public User(String nombre, String apellido, String usuario, String contraseña, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.dni = dni;
	}
	public User() {
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
}
