package vista;

import java.util.List;
import java.util.Scanner;

import modelos.Asignatura;
import modelos.Profesor;

public class ConsolePrint {
	private Scanner input = new Scanner(System.in);
	
	public void bienvenida() {
		System.out.println("Bienvenido a Cnet");
		System.out.println("");
	}
	
	public String menuPrincipal() {
		String opcionString = "";
		
		System.out.println("Menú principal:");
		System.out.println("1. Ingresar como Director");
		System.out.println("2. Ingresar como Profesor");
		System.out.println("3. Ingresar como Alumno");
		System.out.println("4. Salir");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public void errorSolicitudOpcion() {
		System.out.println("Error al ingresar la opcion, intente de nuevo");
		System.out.println("");
	}
	
	public void cerrarPrograma() {
		System.out.println("Gracias por usar Cnet");
	}
	
	public String[] inicioSesion() {
		String usuario = "";
		String contraseña = "";
		
		System.out.println("Ingrese su usuario, presione ENTER y luego ingrese su contraseña");
		System.out.print("Usuario: ");
		usuario = input.nextLine();
		System.out.print("Contraseña: ");
		contraseña = input.nextLine();
		System.out.println("");
		
		return new String[] {usuario, contraseña};
	}
	
	public void errorInicioSesion() {
		System.out.println("Error al iniciar sesion, intente de nuevo");
		System.out.println("");
	}
	
	public void bienvenidaDirector() {
		System.out.println("Bienvenido Director");
		System.out.println("");
	}
	
	public void bienvenidaProfesor() {
		System.out.println("Bienvenido Profesor");
		System.out.println("");
	}
	
	public void bienvenidaAlumno() {
		System.out.println("Bienvenido Alumno");
		System.out.println("");
	}
	
	public String menuDirector() {
		String opcionString = "";
		
		System.out.println("1. Gestionar Profesores");
		System.out.println("2. Gestionar Asignaturas");
		System.out.println("3. Gestionar Alumnos");
		System.out.println("4. Cerrar sesion");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String menuProfesor() {
		String opcionString = "";
		
		System.out.println("1. Ver informacion personal");
		System.out.println("2. Gestionar asignaturas");
		System.out.println("3. Cerrar sesion");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String menuAlumno() {
		String opcionString = "";
		
		System.out.println("1. Gestionar asignaturas");
		System.out.println("2. Cerrar sesion");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String gestionarProfesoresDirector(List<String> profesores) {
		String opcionString = "";
		
		System.out.println("Aqui estan los profesores que estan en el campus:");
		for (int i = 0; i < profesores.size(); i++) {
		    System.out.println(i + ". " + profesores.get(i));
		}
		System.out.println("");
		System.out.println("1. Crear nuevo profesor");
		System.out.println("2. Despedir profesor");
		System.out.println("3. Ver informacion de un profesor");
		System.out.println("4. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String gestionarAsignaturasDirector(List<String> asignaturas) {
		String opcionString = "";
		
		System.out.println("Aqui estan las asignaturas que se imparten en el campus");
		for (int i = 0; i < asignaturas.size(); i++) {
		    System.out.println(i + ". " + asignaturas.get(i));
		}
		System.out.println("");
		System.out.println("1. Crear nueva asignatura");
		System.out.println("2. Asignar asignatura a profesor");
		System.out.println("3. Ver informacion de una asignatura");
		System.out.println("4. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String gestionarAlumnosDirector() {
		String opcionString = "";
		
		System.out.println("1. Crear nueva alumno");
		System.out.println("2. Asignar alumno a asignatura");
		System.out.println("3. Ver informacion de un alumno");
		System.out.println("4. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public void gestionarAsignaturasProfesor() {
		System.out.println("Aqui estan las asignaturas que estas impartiendo ahora");
		System.out.println("");
	}
	
	public void gestionarAsignaturasAlumno() {
		System.out.println("Aqui estan las asignaturas que estas matriculado ahora");
		System.out.println("");
	}
	
	public String errorProfesoresEnCampusVacio() {
		String opcionString = "";
		
		System.out.println("Error al obtener profesores en campus, intente de nuevo o cree un profesor");
		System.out.println("");
		System.out.println("1. Crear profesor");
		System.out.println("2. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String errorAsignaturasEnCampusVacio() {
		String opcionString = "";
		
		System.out.println("Error al obtener asignaturas en campus, intente de nuevo o cree una asignatura");
		System.out.println("");
		System.out.println("1. Crear asignatura");
		System.out.println("2. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public Profesor crearProfe() {
		Profesor profesor = new Profesor();
		
		System.out.println("Ingrese informacion de profe");
		System.out.print("Ingrese nombre: ");
		profesor.setNombre(input.nextLine());
		System.out.print("Ingrese apellido: ");
		profesor.setApellido(input.nextLine());
		System.out.print("Ingrese usuario para ingresar a la aplicacion: ");
		profesor.setUsuario(input.nextLine());
		System.out.print("Ingrese contraseña: ");
		profesor.setContraseña(input.nextLine());
		System.out.print("Ingrese dni: ");
		profesor.setDni(input.nextLine());
		System.out.println("");
		
		return profesor;
	}
	
	public Profesor actualProfe(Profesor profesor) {
		
		System.out.println("Ingrese nueva informacion del profesor:");
		System.out.print("Ingrese nombre (Nombre original '" + profesor.getNombre() + "'): ");
		profesor.setNombre(input.nextLine());
		System.out.print("Ingrese apellido (Apellido original '" + profesor.getApellido() + "'): ");
		profesor.setApellido(input.nextLine());
		System.out.println("");
		
		return profesor;
	}
	
	public String ingresarIndiceProfe() {
		String opcionProfesor = "";
		
		System.out.print("Ingrese el numero de orden del profesor: ");
		opcionProfesor = input.nextLine();
		System.out.println("");
		
		return opcionProfesor;
	}
	
	public String verProfe(Profesor profesor) {
		String opcionString = "";
		
		System.out.println("Informacion de profesor");
		System.out.println("Nombre: " + profesor.getNombre());
		System.out.println("Apellido: " + profesor.getApellido());
		System.out.println("Usuario: " + profesor.getUsuario());
		System.out.println("Dni: " + profesor.getDni());
		System.out.println("");
		
		if (profesor.getAsignaturas().size() > 0) {
			System.out.println("Aqui estan las asignaturas que el profesor imparte");
			for (String a: profesor.getAsignaturas()) {
				System.out.println(a);
			}
		} else {
			System.out.println("Este profesor no tiene asignaturas");
		}
		System.out.println("");
		System.out.println("Actualizar el profesor:");
		System.out.println("1. Actualizar profesor");
		System.out.println("2. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public String despedirProfe() {
		String deleteProfeUser = "";
		System.out.print("Ingrese el usuario del profeso a despedir: ");
		deleteProfeUser = input.nextLine();
		System.out.println("");
		
		return deleteProfeUser;
	}
	
	public String reemplazoDeProfe() {
		String reemplazoProfeUser = "";
		System.out.println("El profesor a despedir cuenta con asignaturas");
		System.out.print("Ingrese el usuario del profeso que reemplazara al despedido: ");
		reemplazoProfeUser = input.nextLine();
		System.out.println("");
		
		return reemplazoProfeUser;
	}
	
	public void profesorCreado() {
		System.out.println("Profesor creado exitosamente");
		System.out.println("");
	}
	
	public void errorCrearProfesor() {
		System.out.println("Error al crear profesor, uno existente con los mismos datos, intente de nuevo");
		System.out.println("");
	}
	
	public void profesorEliminado() {
		System.out.println("Profesor eliminado exitosamente");
		System.out.println("");
	}
	
	public void errorEliminarProfesor() {
		System.out.println("Error al eliminar profesor, no existe uno con los datos proporcionados, intente de nuevo");
		System.out.println("");
	}
	
	public Asignatura crearAsignatura() {
		Asignatura asignatura = new Asignatura();
		
		System.out.println("Ingrese informacion de asignatura");
		System.out.print("Ingrese nombre de asignatura: ");
		asignatura.setNombre(input.nextLine());
		System.out.println(asignatura.getNombre());
		System.out.println("");
		
		return asignatura;
	}
	
	public void asignaturaCreado() {
		System.out.println("Asignatura creada exitosamente");
		System.out.println("");
	}
	
	public void errorCrearAsignatura() {
		System.out.println("Error al crear asignatura, uno existente con los mismos datos, intente de nuevo");
		System.out.println("");
	}
	
	public String[] asignarProfesorAsignatura() {
		String usuarioProfesor = "";
		String nombreAsignatura = "";
		
		System.out.println("Ingrese el usuario del profesor y luego el  nombre de la asignatura");
		System.out.print("Usuario: ");
		usuarioProfesor = input.nextLine();
		System.out.print("Asignatura: ");
		nombreAsignatura = input.nextLine();
		System.out.println("");
		
		return new String[] {usuarioProfesor, nombreAsignatura};
	}
	
	public void profesorAsignado() {
		System.out.println("Profesor asignado a asignatura exitosamente");
		System.out.println("");
	}
	
	public void errorAsignarProfe() {
		System.out.println("Error al asignar profesor a asignatura, intente de nuevo");
		System.out.println("Puede deberse a que no existe el profesor, no existe la asignatura o la asignatura ya cuenta con profesor");
		System.out.println("");
	}
	
	public String ingresarIndiceAsignatura() {
		String opcionAsignatura = "";
		
		System.out.print("Ingrese el numero de orden de la asignatura: ");
		opcionAsignatura = input.nextLine();
		System.out.println("");
		
		return opcionAsignatura;
	}
	
	public void verAsignatura(Asignatura asignatura) {
		System.out.println("Informacion de asignatura");
		System.out.println("Nombre: " + asignatura.getNombre());
		System.out.println("Profesor: " + asignatura.getUserProfesor());
		System.out.println("");
		
		if (asignatura.getAlumnos().size() > 0) {
			System.out.println("Aqui estan los alumnos que estan llevando esta asignatura");
			for (String a: asignatura.getAlumnos()) {
				System.out.println(a);
			}
		} else {
			System.out.println("Esta asignatura no tiene alumnos matriculados");
		}
		System.out.println("");
	}
	
	public void profesorActualizado() {
		System.out.println("Profesor actualizado exitosamente");
		System.out.println("");
	}
}
