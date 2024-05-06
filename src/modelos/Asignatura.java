package modelos;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private String nombre;
    private String userProfesor;
    private List<String> alumnos;
    private List<Calificacion> calificaciones;

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public Asignatura() {
        this.userProfesor = "No profesor";
        this.alumnos = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserProfesor() {
        return userProfesor;
    }

    public void setUserProfesor(String userProfesor) {
        this.userProfesor = userProfesor;
    }

    public List<String> getAlumnos() {
        return alumnos;
    }

    public void addAlumno(String alumno) {
        this.alumnos.add(alumno);
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void addCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
  
}