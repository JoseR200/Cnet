package modelos;

import java.util.ArrayList;
import java.util.List;

public final class Alumno extends Entity {
    private List<String> asignaturas;

    public Alumno() {
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