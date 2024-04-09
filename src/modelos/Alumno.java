package modelos;

import java.util.ArrayList;
import java.util.List;

public final class Alumno extends Entity {
    private String nombre;
    private String apellido;
    private String dni;
    private List<String> asignaturas;

    public Alumno() {
        super();
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