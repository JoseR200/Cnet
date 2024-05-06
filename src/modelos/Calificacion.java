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
    
    public double getValor() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
