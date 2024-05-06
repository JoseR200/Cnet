package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Modelo {
    private final static String DIRECTOR_JSON_FILE = "director.json";
    private final static String PROFESOR_JSON_FILE = "profesor.json";
    private final static String ALUMNO_JSON_FILE = "alumno.json";
    private final static String ASIGNATURA_JSON_FILE = "asignatura.json";

    //Create
    public Boolean writeProfesor(Profesor profesor, Director director) {
        List<Profesor> profesores = readProfesorFromJson();

        for (Profesor existingProfesor : profesores) {
            if (existingProfesor.getUsuario().equals(profesor.getUsuario()) || existingProfesor.getDni().equals(profesor.getDni())) {
                return false;
            }
        }

        profesores.add(profesor);
        director.addProfesor(profesor.getUsuario());

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(PROFESOR_JSON_FILE)) {
            prettyGson.toJson(profesores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean writeAsignatura(Asignatura asignatura, Director director) {
        List<Asignatura> asignaturas = readAsignaturasFromJson();

        for (Asignatura existingAsignatura : asignaturas) {
            if (existingAsignatura.getNombre().equals(asignatura.getNombre())) {
                return false;
            }
        }

        asignaturas.add(asignatura);
        director.addAsignatura(asignatura.getNombre());

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(ASIGNATURA_JSON_FILE)) {
            prettyGson.toJson(asignaturas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean writeAlumno(Alumno alumno) {
        List<Alumno> alumnos = readAlumnosFromJson();

        for (Alumno existingAlumno : alumnos) {
            if (existingAlumno.getUsuario().equals(alumno.getUsuario()) || existingAlumno.getDni().equals(alumno.getDni())) {
                return false;
            }
        }

        alumnos.add(alumno);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(ALUMNO_JSON_FILE)) {
            prettyGson.toJson(alumnos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    //Get All
    public List<Director> readDirectorFromJson() {
        List<Director> director = new ArrayList<>();

        try (Reader reader = new FileReader(DIRECTOR_JSON_FILE)) {
            Gson gson = new Gson();
            Type tipoListaDirector = new TypeToken<List<Director>>() {
            }.getType();
            director = gson.fromJson(reader, tipoListaDirector);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return director;
    }

    public List<Profesor> readProfesorFromJson() {
        List<Profesor> profesor = new ArrayList<>();

        try (Reader reader = new FileReader(PROFESOR_JSON_FILE)) {
            Gson gson = new Gson();
            Type tipoListaProfesor = new TypeToken<List<Profesor>>() {
            }.getType();
            profesor = gson.fromJson(reader, tipoListaProfesor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profesor;
    }

    public List<Alumno> readAlumnosFromJson() {
        List<Alumno> alumnos = new ArrayList<>();

        try (Reader reader = new FileReader(ALUMNO_JSON_FILE)) {
            Gson gson = new Gson();
            Type tipoListaAlumnos = new TypeToken<List<Alumno>>() {
            }.getType();
            alumnos = gson.fromJson(reader, tipoListaAlumnos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    public List<Asignatura> readAsignaturasFromJson() {
        List<Asignatura> asignaturas = new ArrayList<>();

        try (Reader reader = new FileReader(ASIGNATURA_JSON_FILE)) {
            Gson gson = new Gson();
            Type tipoListaAsignaturas = new TypeToken<List<Asignatura>>() {
            }.getType();
            asignaturas = gson.fromJson(reader, tipoListaAsignaturas);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }

    //Login
    public boolean loginDirector(String[] userCredentials) {
        for (Director dir : readDirectorFromJson()) {
            if (dir.getUsuario().equals(userCredentials[0]) && dir.getContraseña().equals(userCredentials[1])) {
                return true;
            }
        }
        return false;
    }

    public boolean loginProfesor(String[] userCredentials) {
        for (Profesor pro : readProfesorFromJson()) {
            if (pro.getUsuario().equals(userCredentials[0]) && pro.getContraseña().equals(userCredentials[1])) {
                return true;
            }
        }
        return false;
    }

    public boolean loginAlumno(String[] userCredentials) {
        for (Alumno al : readAlumnosFromJson()) {
            if (al.getUsuario().equals(userCredentials[0]) && al.getContraseña().equals(userCredentials[1])) {
                return true;
            }
        }
        return false;
    }

    //Get One
    public Director getDirectorByDirectorUsername(String usernameDirector) {
        for (Director dp : readDirectorFromJson()) {
            if (dp.getUsuario().equals(usernameDirector)) {
                return dp;
            }
        }
        return null;
    }

    public Profesor getProfesorByProfesorUsername(String usernameProfesor) {
        for (Profesor pa : readProfesorFromJson()) {
            if (pa.getUsuario().equals(usernameProfesor)) {
                return pa;
            }
        }
        return null;
    }

    public Asignatura getAsignaturaByAsignaturaName(String asignaturaName) {
        for (Asignatura a : readAsignaturasFromJson()) {
            if (a.getNombre().equals(asignaturaName)) {
                return a;
            }
        }
        return null;
    }
    
    public Alumno getAlumnoByAlumnoUsername(String usernameAlumno) {
        for (Alumno al : readAlumnosFromJson()) {
            if (al.getUsuario().equals(usernameAlumno)) {
                return al;
            }
        }
        return null;
    }

    //Update
    public void modifyDirector(Director directorNuevo) {
        List<Director> directores = readDirectorFromJson();
        directores.removeIf(dp -> dp.getUsuario().equals(directorNuevo.getUsuario()));
        directores.add(directorNuevo);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(DIRECTOR_JSON_FILE)) {
            prettyGson.toJson(directores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modifyProfesor(Profesor profesorNuevo) {
        List<Profesor> profesores = readProfesorFromJson();
        profesores.removeIf(p -> p.getUsuario().equals(profesorNuevo.getUsuario()));
        profesores.add(profesorNuevo);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(PROFESOR_JSON_FILE)) {
            prettyGson.toJson(profesores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modifyAsignatura(Asignatura asignaturaNuevo) {
        List<Asignatura> asignaturas = readAsignaturasFromJson();
        asignaturas.removeIf(a -> a.getNombre().equals(asignaturaNuevo.getNombre()));
        asignaturas.add(asignaturaNuevo);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(ASIGNATURA_JSON_FILE)) {
            prettyGson.toJson(asignaturas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void modifyAlumno(Alumno alumnoNuevo) {
        List<Alumno> alumnos = readAlumnosFromJson();
        alumnos.removeIf(a -> a.getUsuario().equals(alumnoNuevo.getUsuario()));
        alumnos.add(alumnoNuevo);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(ALUMNO_JSON_FILE)) {
            prettyGson.toJson(alumnos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Delete
    public void deleteProfesor(String userProfesor, Director director) {
        List<Profesor> profesores = readProfesorFromJson();

        profesores.removeIf(p -> p.getUsuario().equals(userProfesor));
        director.deleteProfesor(userProfesor);

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(PROFESOR_JSON_FILE)) {
            prettyGson.toJson(profesores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Verifier
    public Boolean existeProfesorExisteAsignatura(String profesor, String asignatura) {
        Boolean condicionProfe = false;
        Boolean condicionAsignatura = false;

        for (Profesor pro : readProfesorFromJson()) {
            if (pro.getUsuario().equals(profesor)) {
                condicionProfe = true;
            }
        }
        for (Asignatura asg : readAsignaturasFromJson()) {
            if (asg.getNombre().equals(asignatura) && asg.getUserProfesor().equals("No profesor")) {
                condicionAsignatura = true;
            }
        }

        return condicionProfe && condicionAsignatura;
    }
    
    public boolean existeAlumnoExisteAsignatura(String alumno, String asignatura) {
    	Boolean condicionAlumno = false;
        Boolean condicionAsignatura = false;
        
        for (Alumno al : readAlumnosFromJson()) {
            if (al.getUsuario().equals(alumno)) {
            	condicionAlumno = true;
            }
        }
        for (Asignatura asg : readAsignaturasFromJson()) {
            if (asg.getNombre().equals(asignatura) && !asg.getAlumnos().contains(alumno)) {
                condicionAsignatura = true;
            }
        }

        return condicionAlumno && condicionAsignatura;
    }

    public Boolean profesorTieneAsignatura(String profesor) {
        Boolean condicionProfe = false;

        for (Profesor pro : readProfesorFromJson()) {
            if (pro.getUsuario().equals(profesor)) {
                if (pro.getAsignaturas().size() > 0) {
                    condicionProfe = true;
                }
            }
        }

        return condicionProfe;
    }

    public Boolean existeProfesor(String profesor) {
        Boolean condicionProfe = false;

        for (Profesor pro : readProfesorFromJson()) {
            if (pro.getUsuario().equals(profesor)) {
                condicionProfe = true;
            }
        }

        return condicionProfe;
    }
    
    public boolean existeAlumno(String alumno) {
    	Boolean condicionAlumno = false;
    	
        for (Alumno al : readAlumnosFromJson()) {
            if (al.getUsuario().equals(alumno)) {
            	condicionAlumno = true;
            }
        }
        return condicionAlumno;
    }
    
    public boolean existeAlumnoDentroDeAsignatura(String alumno, Asignatura asignatura) {
    	Boolean condicionAlumno = false;
    	
    	for (String al : asignatura.getAlumnos()) {
            if (al.equals(alumno)) {
            	condicionAlumno = true;
            }
        }
        return condicionAlumno;
    }
    
    public boolean existeAsignatura(String asignaturaString) {
    	Boolean condicionAlumno = false;
    	
        for (Alumno al : readAlumnosFromJson()) {
            if (al.getUsuario().equals(asignaturaString)) {
            	condicionAlumno = true;
            }
        }
        return condicionAlumno;
    }
    
    //Export
    public static void Export(List<?> entities, String fileName) {
        System.out.println("Exportando...");
        try {
            ExportCSV(entities, fileName);
            System.out.println("Datos exportados correctamente");
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar los datos", e);
        }
    }

    private static <T> void ExportCSV(List<T> entities, String FileName) throws IOException {
        if (entities.isEmpty()) {
            System.out.println("No hay datos para exportar");
            return;
        }

        Writer writer = new FileWriter(FileName + ".csv");

        var lines = new StringBuilder();

        Stream.of(entities.get(0).getClass().getDeclaredFields()).forEach(field -> {
            lines.append(field.getName()).append(",");
        });

        lines.append("\n");

        entities.forEach(entity -> {
            Stream.of(entity.getClass().getDeclaredFields()).forEach(field -> {
                try {
                    field.setAccessible(true);
                    lines.append(field.get(entity)).append(",");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error al exportar los datos", e);
                }
            });
            lines.append("\n");
        });

        writer.write(lines.toString());
        writer.close();
    }
}
