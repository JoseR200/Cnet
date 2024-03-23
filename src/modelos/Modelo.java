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
	public Boolean writeProfesor(User user, DirectorProfesores directorProfesores) {
		List<User> users = readProfesorsFromJson();
		
		for (User existingUser : users) {
			if (existingUser.getUsuario().equals(user.getUsuario()) || existingUser.getDni().equals(user.getDni())) {
				return false;
	        }
	    }
		
		users.add(user);
		directorProfesores.addProfesor(user.getUsuario());

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(PROFESOR_JSON_FILE)){
			prettyGson.toJson(users, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return true;
	}
	/*public void writeSession(Session ses) {
		List<Session> sesions = readSessionsFromJson();
		
		sesions.add(ses);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(SESSION_JSON_FILE)){
			prettyGson.toJson(sesions, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void writeDoctor(Doctor doc) {
		List<Doctor> doctors = readDoctorsFromJson();
		
		doctors.add(doc);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(DOCTOR_JSON_FILE)){
			prettyGson.toJson(doctors, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void writePatient(Patient pat) {
		List<Patient> patients = readPatientsFromJson();
		
		patients.add(pat);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(PATIENT_JSON_FILE)){
			prettyGson.toJson(patients, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void writeFamily(Family fam) {
		List<Family> families = readFamilyFromJson();
		
		families.add(fam);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(FAMILY_JSON_FILE)){
			prettyGson.toJson(families, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void writeAlarma(AlarmaUsuario usuAlarma) {
		List<AlarmaUsuario> alarmas = readTimerFromJson();
		
		alarmas.add(usuAlarma);
		
		for (AlarmaUsuario alarmaUsuario : alarmas) {
			if(alarmaUsuario.getUsuario().equals(usuAlarma.getUsuario())){
				modifyAlarmaUsuario(alarmaUsuario, usuAlarma);
			}
		}

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(TIMERS_JSON_FILE)){
			prettyGson.toJson(alarmas, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void writeStats(UserStats stat) {
		List<UserStats> stats = readStatsFromJson();
		
		stats.add(stat);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(USER_STATS_JSON_FILE)){
			prettyGson.toJson(stats, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	*/
	
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
	public List<DirectorProfesores> readDirectorProfesorsFromJson() {
		List<DirectorProfesores> directorProfesors = new ArrayList<>();
		
		try (Reader reader = new FileReader(DIRECTOR_PROFESORES_JSON_FILE)){
			Gson gson = new Gson();
			Type tipoListaDirectorProfesores = new TypeToken<List<DirectorProfesores>>(){}.getType();
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
	public DirectorProfesores getDirectorProfesoresByDirectorUsername(String usernameDirector) {
		for (DirectorProfesores dp: readDirectorProfesorsFromJson()) {
			if (dp.getUsuarioDirector().equals(usernameDirector)) {
				return dp;
			}
		}
		return null;
	}
	/*public Doctor getDoctorByUsername(String usrname) {
		for (Doctor doctor: readDoctorsFromJson()) {
			if (doctor.getUsuario()==1) {
				return doctor;
			}
		}
		return null;
	}/*
	public Patient getPatientByUsername(String usrname) {
		for (Patient patient: readPatientsFromJson()) {
			if (patient.getUsuario().equals(usrname)) {
				return patient;
			}
		}
		return null;
	}
	public Family getFamilyByUsername(String usrname) {
		for (Family family: readFamilyFromJson()) {
			if (family.getUsuario().equals(usrname)) {
				return family;
			}
		}
		return null;
	}
	public AlarmaUsuario getTimerByUsername(String usrname) {
		for (AlarmaUsuario alarmaUsuario: readTimerFromJson()) {
			if (alarmaUsuario.getUsuario().equals(usrname)) {
				return alarmaUsuario;
			}
		}
		return null;
	}
	public UserStats getStatsByUsername(String usrname) {
		for (UserStats userStats: readStatsFromJson()) {
			if (userStats.getUser().equals(usrname)) {
				return userStats;
			}
		}
		return null;
	}*/
	
	//Update
	public void modifyDirectorProfesores(DirectorProfesores directorProfesoresNuevo) {
		List<DirectorProfesores> directoresProfesores = readDirectorProfesorsFromJson();
		directoresProfesores.removeIf(dp -> dp.getUsuarioDirector().equals(directorProfesoresNuevo.getUsuarioDirector()));
		directoresProfesores.add(directorProfesoresNuevo);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(DIRECTOR_PROFESORES_JSON_FILE)){
			prettyGson.toJson(directoresProfesores, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	/*public void modifyDoctor(Doctor doctorOriginal, Doctor doctorChanged) {
		List<Doctor> doctors = readDoctorsFromJson();
		doctors.removeIf(d -> d.getUsuario()== doctorOriginal.getUsuario());
		doctors.add(doctorChanged);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(DOCTOR_JSON_FILE)){
			prettyGson.toJson(doctors, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}/*
	public void modifyPatient(Patient patientOriginal, Patient patientChanged) {
		List<Patient> patients = readPatientsFromJson();
		patients.removeIf(p -> p.getUsuario().equals(patientOriginal.getUsuario()));
		patients.add(patientChanged);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(PATIENT_JSON_FILE)){
			prettyGson.toJson(patients, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public void modifyAlarmaUsuario(AlarmaUsuario alarmaUsuarioOriginal, AlarmaUsuario alarmaUsuarioChanged) {
		List<AlarmaUsuario> alarmasUsuario = readTimerFromJson();
		alarmasUsuario.removeIf(a -> a.getUsuario().equals(alarmaUsuarioOriginal.getUsuario()));
		alarmasUsuario.add(alarmaUsuarioChanged);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(TIMERS_JSON_FILE)){
			prettyGson.toJson(alarmasUsuario, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	//Delete
	public void deleteSession(String pcName) {
		List<Session> sesions = readSessionsFromJson();
		sesions.removeIf(s -> s.getNamePc().equals(pcName));

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

		try(FileWriter writer = new FileWriter(SESSION_JSON_FILE)){
			prettyGson.toJson(sesions, writer);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}*/
}
