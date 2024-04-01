package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
	private final static String DIRECTOR_JSON_FILE="director.json";
	private final static String PROFESOR_JSON_FILE="profesor.json";
	private final static String ALUMNO_JSON_FILE="alumno.json";
	private final static String DIRECTOR_PROFESORES_JSON_FILE="director-profesores.json";
	
	//Create
	public Boolean writeProfesor(User user, Director director) {
		List<User> users = readProfesorsFromJson();
		
		for (User existingUser : users) {
			if (existingUser.getUsuario().equals(user.getUsuario()) || existingUser.getDni().equals(user.getDni())) {
				return false;
	        }
	    }
		
		users.add(user);
		director.addProfesor(user.getUsuario());

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(PROFESOR_JSON_FILE)){
			prettyGson.toJson(users, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return true;
	}
	
	//Get All
	public List<User> readDirectorsFromJson() {
		List<User> directors = new ArrayList<>();
		
		try (Reader reader = new FileReader(DIRECTOR_JSON_FILE)){
			Gson gson = new Gson();
			Type tipoListaDirectores = new TypeToken<List<User>>(){}.getType();
			directors = gson.fromJson(reader, tipoListaDirectores);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return directors;
	}
	public List<User> readProfesorsFromJson() {
		List<User> profesors = new ArrayList<>();
		
		try (Reader reader = new FileReader(PROFESOR_JSON_FILE)){
			Gson gson = new Gson();
			Type tipoListaProfesores= new TypeToken<List<User>>(){}.getType();
			profesors = gson.fromJson(reader, tipoListaProfesores);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return profesors;
	}
	public List<User> readStudentsFromJson() {
		List<User> students = new ArrayList<>();
		
		try (Reader reader = new FileReader(ALUMNO_JSON_FILE)){
			Gson gson = new Gson();
			Type tipoListaAlumnos = new TypeToken<List<User>>(){}.getType();
			students = gson.fromJson(reader, tipoListaAlumnos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}
	public List<Director> readDirectorFromJson() {
		List<Director> directorProfesors = new ArrayList<>();
		
		try (Reader reader = new FileReader(DIRECTOR_PROFESORES_JSON_FILE)){
			Gson gson = new Gson();
			Type tipoListaDirectorProfesores = new TypeToken<List<Director>>(){}.getType();
			directorProfesors = gson.fromJson(reader, tipoListaDirectorProfesores);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return directorProfesors;
	}
	
	//Login
	public boolean loginDirector(String[] userCredentials) {
		for (User usr: readDirectorsFromJson()) {
			if (usr.getUsuario().equals(userCredentials[0]) && usr.getContraseña().equals(userCredentials[1])) {
				return true;
			}
		}
		return false;
	}
	public boolean loginProfesor(String[] userCredentials) {
		for (User usr: readProfesorsFromJson()) {
			if (usr.getUsuario().equals(userCredentials[0]) && usr.getContraseña().equals(userCredentials[1])) {
				return true;
			}
		}
		return false;
	}
	public boolean loginAlumno(String[] userCredentials) {
		for (User usr: readStudentsFromJson()) {
			if (usr.getUsuario().equals(userCredentials[0]) && usr.getContraseña().equals(userCredentials[1])) {
				return true;
			}
		}
		return false;
	}
	
	//Get One
	public Director getDirectorByDirectorUsername(String usernameDirector) {
		for (Director dp: readDirectorFromJson()) {
			if (dp.getUsuarioDirector().equals(usernameDirector)) {
				return dp;
			}
		}
		return null;
	}
		
	//Update
	public void modifyDirectorProfesores(Director directorProfesoresNuevo) {
		List<Director> directoresProfesores = readDirectorFromJson();
		directoresProfesores.removeIf(dp -> dp.getUsuarioDirector().equals(directorProfesoresNuevo.getUsuarioDirector()));
		directoresProfesores.add(directorProfesoresNuevo);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(DIRECTOR_PROFESORES_JSON_FILE)){
			prettyGson.toJson(directoresProfesores, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
		
	//Delete
	public Boolean deleteProfesor(String userProfesor, Director director) {
		List<User> profesores = readProfesorsFromJson();
		Boolean eliminado = profesores.removeIf(p -> p.getUsuario().equals(userProfesor));
		
		director.deleteProfesor(userProfesor);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(PROFESOR_JSON_FILE)){
			prettyGson.toJson(profesores, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return eliminado;
	}
}
