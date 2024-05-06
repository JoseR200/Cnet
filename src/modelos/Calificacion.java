package modelos;

import java.util.ArrayList;
import java.util.List;

public class Calificacion {
	private List<Double> notas;

    public Calificacion() {
        this.notas = new ArrayList<>();
    }
    public Calificacion(List<Double> notas) {
        this.notas = notas;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void addNota(Double nota) {
        this.notas.add(nota);
    }
}
