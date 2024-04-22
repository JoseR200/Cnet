package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asignatura {
    private String nombre;
    private String userProfesor;
    private List<String> alumnos;
    private List<Calificacion> calificaciones;

    private static final Scanner input = new Scanner(System.in);

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    public Asignatura() {
        this.userProfesor = "No profesor";
        this.alumnos = new ArrayList<>();
    }

    public static void MenuAddCalificacion(Asignatura asignatura) {
        System.out.println("Ingrese el usuario del alumno: ");
        String alumno = input.nextLine();

        // Verificamos si el alumno existe
        if (!asignatura.getAlumnos().contains(alumno)) {
            System.out.println("El alumno no existe.");
            return;
        }

        System.out.println("Ingrese el concepto de la calificación: ");
        String concepto = input.nextLine();

        // Verificamos si el concepto es valido
        if (concepto == null || concepto.isEmpty()) {
            System.out.println("El concepto no es válido.");
            return;
        }

        System.out.println("Ingrese la nota: ");
        double nota = input.nextDouble();

        // Verificamos si la nota es valida
        if (nota < 0 || nota > 10) {
            System.out.println("La nota no es válida, la nota debe estar entre 0 y 10.");
            return;
        }

        asignatura.addCalificacion(alumno, concepto, nota);

        // Creamos el mismo concepto para los demás alumnos sino existen
        for (String alumnoAux : asignatura.getAlumnos()) {
            if (!alumnoAux.equals(alumno)) {
                boolean existe = false;
                for (Calificacion calificacion : asignatura.getCalificaciones()) {
                    if (calificacion.getAlumno().equals(alumnoAux) && calificacion.getConcepto().equals(concepto)) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    asignatura.addCalificacion(alumnoAux, concepto, -1);
                }
            }
        }

        System.out.println("Calificación agregada con éxito.");
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

    public void removeAlumno(String alumno) {
        this.alumnos.remove(alumno);
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void addCalificacion(String alumno, String concepto, double nota) {
        if (calificaciones == null) {
            calificaciones = new ArrayList<>();
        }
        calificaciones.add(new Calificacion(alumno, concepto, nota));
    }

    public void removeCalificacion(String alumno, String concepto) {
        for (Calificacion calificacion : calificaciones) {
            if (calificacion.getAlumno().equals(alumno) && calificacion.getConcepto().equals(concepto)) {
                calificaciones.remove(calificacion);
                break;
            }
        }
    }

    public void updateCalificacion(String alumno, String concepto, double nota) {
        for (Calificacion calificacion : calificaciones) {
            if (calificacion.getAlumno().equals(alumno) && calificacion.getConcepto().equals(concepto)) {
                calificacion.setNota(nota);
                break;
            }
        }
    }

    public class Calificacion {
        private String alumno;
        private double nota;
        private String concepto;

        public Calificacion(String alumno, String concepto, double nota) {
            this.alumno = alumno;
            this.concepto = concepto;
            this.nota = nota;
        }

        public String getAlumno() {
            return alumno;
        }

        public void setAlumno(String alumno) {
            this.alumno = alumno;
        }

        public double getNota() {
            return nota;
        }

        public void setNota(double nota) {
            this.nota = nota;
        }

        public String getConcepto() {
            return concepto;
        }

        public void setConcepto(String concepto) {
            this.concepto = concepto;
        }
    }
}