package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelos.Alumno;
import modelos.Asignatura;
import modelos.Calificacion;
import modelos.Profesor;

public abstract class ConsolePrint {
    private static final Scanner input = new Scanner(System.in);

    public static void bienvenida() {
        System.out.println("Bienvenido a Cnet");
        System.out.println();
    }

    public static String menuPrincipal() {
        String opcionString;

        System.out.println("Menú principal:");
        System.out.println("1. Ingresar como Director");
        System.out.println("2. Ingresar como Profesor");
        System.out.println("3. Ingresar como Alumno");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static void errorSolicitudOpcion() {
        System.out.println("Error al ingresar la opcion, intente de nuevo");
        System.out.println();
    }

    public static void cerrarPrograma() {
        System.out.println("Gracias por usar Cnet");
    }

    public static String[] inicioSesion() {
        String usuario;
        String contraseña;

        System.out.println("Ingrese su usuario, presione ENTER y luego ingrese su contraseña");
        System.out.print("Usuario: ");
        usuario = input.nextLine();
        System.out.print("Contraseña: ");
        contraseña = input.nextLine();
        System.out.println();

        return new String[]{usuario, contraseña};
    }

    public static void errorInicioSesion() {
        System.out.println("Error al iniciar sesion, intente de nuevo");
        System.out.println();
    }

    public static void bienvenidaDirector() {
        System.out.println("Bienvenido Director");
        System.out.println();
    }

    public static void bienvenidaProfesor() {
        System.out.println("Bienvenido Profesor");
        System.out.println();
    }

    public static void bienvenidaAlumno() {
        System.out.println("Bienvenido Alumno");
        System.out.println();
    }

    public static String menuDirector() {
        String opcionString;

        System.out.println("1. Gestionar Profesores");
        System.out.println("2. Gestionar Asignaturas");
        System.out.println("3. Gestionar Alumnos");
        System.out.println("4. Cerrar sesion");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String menuProfesor() {
        String opcionString;

        System.out.println("1. Ver informacion personal");
        System.out.println("2. Gestionar asignaturas");
        System.out.println("3. Cerrar sesion");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String menuAlumno(Alumno alumno) {
        String opcionString;
        
        if (!alumno.getAsignaturas().isEmpty()) {
            System.out.println("Aqui estan las asignaturas en las que estas matriculado");
            for (int i = 0; i < alumno.getAsignaturas().size(); i++) {
                System.out.println(i + ". " + alumno.getAsignaturas().get(i));
            }
        } else {
            System.out.println("No estas matriculado en ninguna asignatura");
        }
        System.out.println();

        System.out.println("1. Gestionar asignaturas");
        System.out.println("2. Cerrar sesion");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String gestionarProfesoresDirector(List<String> profesores) {
        String opcionString;

        System.out.println("Aqui estan los profesores que estan en el campus:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println(i + ". " + profesores.get(i));
        }
        System.out.println();
        System.out.println("1. Crear nuevo profesor");
        System.out.println("2. Despedir profesor");
        System.out.println("3. Ver informacion de un profesor");
        System.out.println("4. Regresar");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String gestionarAsignaturasDirector(List<String> asignaturas) {
        String opcionString;

        System.out.println("Aqui estan las asignaturas que se imparten en el campus");
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println(i + ". " + asignaturas.get(i));
        }
        System.out.println();
        System.out.println("1. Crear nueva asignatura");
        System.out.println("2. Asignar asignatura a profesor");
        System.out.println("3. Ver informacion de una asignatura");
        System.out.println("4. Regresar");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String gestionarAlumnosDirector() {
        String opcionString;

        System.out.println("1. Crear nuevo alumno");
        System.out.println("2. Asignar alumno a asignatura");
        System.out.println("3. Ver informacion de un alumno");
        System.out.println("4. Ver todos los alumnos");
        System.out.println("5. Regresar");

        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static void gestionarAsignaturasProfesor() {
        System.out.println("Aqui estan las asignaturas que estas impartiendo ahora");
        System.out.println();
    }

    public static void gestionarAsignaturasAlumno() {
        System.out.println("Aqui estan las asignaturas que estas matriculado ahora");
        System.out.println();
    }

    public static String errorProfesoresEnCampusVacio() {
        String opcionString;

        System.out.println("Error al obtener profesores en campus, intente de nuevo o cree un profesor");
        System.out.println();
        System.out.println("1. Crear profesor");
        System.out.println("2. Regresar");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String errorAsignaturasEnCampusVacio() {
        String opcionString;

        System.out.println("Error al obtener asignaturas en campus, intente de nuevo o cree una asignatura");
        System.out.println();
        System.out.println("1. Crear asignatura");
        System.out.println("2. Regresar");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static String errorAlumnosEnCampusVacio() {
        String opcionString;

        System.out.println("Error al obtener alumnos en campus, intente de nuevo o cree un alumno");
        System.out.println();
        System.out.println("1. Crear alumno");
        System.out.println("2. Regresar");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
    }

    public static Profesor crearProfe() {
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
        System.out.println();

        return profesor;
    }

    public static Alumno crearAlumno() {
        Alumno alumno = new Alumno();

        System.out.println("Ingrese informacion de alumno");
        System.out.print("Ingrese nombre: ");
        alumno.setNombre(input.nextLine());
        System.out.print("Ingrese apellido: ");
        alumno.setApellido(input.nextLine());
        System.out.print("Ingrese usuario para ingresar a la aplicacion: ");
        alumno.setUsuario(input.nextLine());
        System.out.print("Ingrese contraseña: ");
        alumno.setContraseña(input.nextLine());
        System.out.print("Ingrese dni: ");
        alumno.setDni(input.nextLine());
        System.out.println();

        return alumno;
    }

    public static String ingresarIndiceProfe() {
        String opcionProfesor;

        System.out.print("Ingrese el numero de orden del profesor: ");
        opcionProfesor = input.nextLine();
        System.out.println();

        return opcionProfesor;
    }

    public static String verProfe(Profesor profesor) {
        String opcionString = "";

        System.out.println("Informacion de profesor");
        System.out.println("Nombre: " + profesor.getNombre());
        System.out.println("Apellido: " + profesor.getApellido());
        System.out.println("Usuario: " + profesor.getUsuario());
        System.out.println("Dni: " + profesor.getDni());
        System.out.println("");

        if (profesor.getAsignaturas().size() > 0) {
            System.out.println("Aqui estan las asignaturas que el profesor imparte");
            for (String a : profesor.getAsignaturas()) {
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

    public static String despedirProfe() {
        String deleteProfeUser;
        System.out.print("Ingrese el usuario del profeso a despedir: ");
        deleteProfeUser = input.nextLine();
        System.out.println();

        return deleteProfeUser;
    }

    public static String reemplazoDeProfe() {
        String reemplazoProfeUser;
        System.out.println("El profesor a despedir cuenta con asignaturas");
        System.out.print("Ingrese el usuario del profeso que reemplazara al despedido: ");
        reemplazoProfeUser = input.nextLine();
        System.out.println();

        return reemplazoProfeUser;
    }

    public static void profesorCreado() {
        System.out.println("Profesor creado exitosamente");
        System.out.println();
    }

    public static void errorCrearProfesor() {
        System.out.println("Error al crear profesor, uno existente con los mismos datos, intente de nuevo");
        System.out.println();
    }

    public static void profesorEliminado() {
        System.out.println("Profesor eliminado exitosamente");
        System.out.println();
    }

    public static void errorEliminarProfesor() {
        System.out.println("Error al eliminar profesor, no existe uno con los datos proporcionados, intente de nuevo");
        System.out.println();
    }

    public static Asignatura crearAsignatura() {
        Asignatura asignatura = new Asignatura();

        System.out.println("Ingrese informacion de asignatura");
        System.out.print("Ingrese nombre de asignatura: ");
        asignatura.setNombre(input.nextLine());
        System.out.println();

        return asignatura;
    }

    public static void asignaturaCreado() {
        System.out.println("Asignatura creada exitosamente");
        System.out.println();
    }

    public static void errorCrearAsignatura() {
        System.out.println("Error al crear asignatura, uno existente con los mismos datos, intente de nuevo");
        System.out.println();
    }

    public static String[] asignarProfesorAsignatura() {
        String usuarioProfesor;
        String nombreAsignatura;

        System.out.println("Ingrese el usuario del profesor y luego el  nombre de la asignatura");
        System.out.print("Usuario: ");
        usuarioProfesor = input.nextLine();
        System.out.print("Asignatura: ");
        nombreAsignatura = input.nextLine();
        System.out.println();

        return new String[]{usuarioProfesor, nombreAsignatura};
    }

    public static void profesorAsignado() {
        System.out.println("Profesor asignado a asignatura exitosamente");
        System.out.println();
    }

    public static void errorAsignarProfe() {
        System.out.println("Error al asignar profesor a asignatura, intente de nuevo");
        System.out.println("Puede deberse a que no existe el profesor, no existe la asignatura o la asignatura ya cuenta con profesor");
        System.out.println();
    }

    public static String ingresarIndiceAsignatura() {
        String opcionAsignatura;

        System.out.print("Ingrese el numero de orden de la asignatura: ");
        opcionAsignatura = input.nextLine();
        System.out.println();

        return opcionAsignatura;
    }


    public static void calificacionAsignada() {
        System.out.println("Calificacion creada exitosamente");
    }

    public static String verAsignatura(Asignatura asignatura) {
        String opcionString;

        System.out.println("Informacion de asignatura");
        System.out.println("Nombre: " + asignatura.getNombre());
        System.out.println("Profesor: " + asignatura.getUserProfesor());
        System.out.println();

        if (!asignatura.getAlumnos().isEmpty()) {
            System.out.println("Aqui estan los alumnos que estan llevando esta asignatura");
            for (String a : asignatura.getAlumnos()) {
                System.out.println(a);
            }
        } else {
            System.out.println("Esta asignatura no tiene alumnos matriculados");
        }
        System.out.println();
        System.out.println("Calificaciones de asignatura:");
        System.out.println("1. Crear nueva calificacion");
        System.out.println("2. Obtener grupo de calificaciones");
        System.out.println("3. Regresar");
        System.out.print("Ingrese una opcion: ");
        opcionString = input.nextLine();
        System.out.println("");

        return opcionString;
    }

    public static void alumnoCreado() {
        System.out.println("Alumno creado exitosamente");
        System.out.println();
    }

    public static void errorCrearAlumno() {
        System.out.println("Error al crear alumno, uno existente con los mismos datos, intente de nuevo");
        System.out.println();
    }

    public static String[] asignarAlumnoAsignatura() {
        String usuarioAlumno;
        String nombreAsignatura;

        System.out.println("Ingrese el usuario del alumno y luego el  nombre de la asignatura");
        System.out.print("Usuario: ");
        usuarioAlumno = input.nextLine();
        System.out.print("Asignatura: ");
        nombreAsignatura = input.nextLine();
        System.out.println();

        return new String[]{usuarioAlumno, nombreAsignatura};
    }

    public static void errorAsignarAlumno() {
        System.out.println("Error al asignar alumno a asignatura, intente de nuevo");
        System.out.println("Puede deberse a que no existe el alumno, no existe la asignatura o el alumno ya esta matriculado en la asignatura");
        System.out.println();
    }
    
    public static void errorAsignarAlumnoNuevo() {
        System.out.println("Error al asignar alumno a asignatura");
        System.out.println("La asignatura ya cuenta con calificaciones");
        System.out.println();
    }

    public static void alumnoAsignado() {
        System.out.println("Alumno asignado a asignatura exitosamente");
        System.out.println();
    }

    public static String ingresarAlumno() {
        String opcionAlumno;

        System.out.print("Ingrese el usuario del alumno: ");
        opcionAlumno = input.nextLine();
        System.out.println();

        return opcionAlumno;
    }

    public static void mostrarNotas(Alumno alumno, Asignatura asignatura, List<Double> notas) {
        System.out.println("Notas de " + alumno.getNombre() + " en la asignatura " + asignatura.getNombre() + ":");
        for (Double nota : notas) {
            System.out.print(nota + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public static String verAlumno(Alumno alumno) {
    	String opcionString = "";
    	
        System.out.println("Informacion de alumno");
        System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Apellido: " + alumno.getApellido());
        System.out.println("Usuario: " + alumno.getUsuario());
        System.out.println("Dni: " + alumno.getDni());
        System.out.println();

        if (!alumno.getAsignaturas().isEmpty()) {
            System.out.println("Aqui estan las asignaturas en las que estas matriculado");
            for (int i = 0; i < alumno.getAsignaturas().size(); i++) {
                System.out.println(i + ". " + alumno.getAsignaturas().get(i));
            }
        } else {
            System.out.println("Este alumno no esta matriculado en ninguna asignatura");
        }
        System.out.println("");
		System.out.println("Gestionar alumno:");
		System.out.println("1. Obtener 1 asignatura");
		System.out.println("2. Actualizar alumno");
		System.out.println("3. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
    }

    public static String verMasAlumnos(int index, int total) {
        System.out.println("Alumnos mostrados: " + index + " de " + total);
        System.out.print("Ingrese 0 para regresar o cualquier otra tecla para ver mas alumnos: ");
        return input.nextLine();
    }

    public static Profesor actualProfe(Profesor profesor) {

        System.out.println("Ingrese nueva informacion del profesor:");
        System.out.print("Ingrese nombre (Nombre original '" + profesor.getNombre() + "'): ");
        profesor.setNombre(input.nextLine());
        System.out.print("Ingrese apellido (Apellido original '" + profesor.getApellido() + "'): ");
        profesor.setApellido(input.nextLine());
        System.out.println("");

        return profesor;
    }

    public static void profesorActualizado() {
        System.out.println("Profesor actualizado exitosamente");
        System.out.println("");
    }
    
    public static void profesorAsignaturasVacio() {
		System.out.println("Usted no tiene asignaturas");
        System.out.println();
    }
	
	public static String gestionarAsignaturasProfesor(List<String> asignaturas) {
		String opcionString;

        System.out.println("Aqui estan las asignaturas que impartes");
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.println(i + ". " + asignaturas.get(i));
        }
        System.out.println();
        System.out.println("Obtener Asignatura");
		System.out.println("1. Obtener Asignatura");
		System.out.println("2. Regresar");
		System.out.print("Ingrese una opcion: ");
		opcionString = input.nextLine();
		System.out.println("");
		
		return opcionString;
	}
	
	public static String obtenerAsignaturaProfesor() {
		String opcionString;

        System.out.print("Ingrese el numero de orden de la asignatura: ");
        opcionString = input.nextLine();
        System.out.println();

        return opcionString;
	}
	
	public static String verAsignaturaProfe(Asignatura asignatura) {
		String opcionString;
		
        System.out.println("Informacion de asignatura");
        System.out.println("Nombre: " + asignatura.getNombre());
        System.out.println("Profesor: " + asignatura.getUserProfesor());
        System.out.println();

        if (!asignatura.getAlumnos().isEmpty()) {
            System.out.println("Aqui estan los alumnos que estan llevando esta asignatura");
            for (String a : asignatura.getAlumnos()) {
                System.out.println(a);
            }
        } else {
            System.out.println("Esta asignatura no tiene alumnos matriculados");
        }
        System.out.println();
        System.out.println("Gestionar asignatura");
    	System.out.println("1. Crear Calificacion");
    	System.out.println("2. Regresar");
    	System.out.print("Ingrese una opcion: ");
    	opcionString = input.nextLine();
    	System.out.println("");
    	
    	return opcionString;
    }
    
    public static boolean crearCalificacion(Asignatura asignatura) {
    	List<String> nuevasNotas = new ArrayList<>();
    	
    	for (String a : asignatura.getAlumnos()) {
			System.out.print("Ingrese la nota para (" + a + "): ");
			nuevasNotas.add(input.nextLine());
        }
    	
    	List<Double> nuevasNotasDouble = new ArrayList<>();
    	
    	for (String a: nuevasNotas) {
    		try {
    			Double nota = Double.parseDouble(a);
    			if (nota < 0 || nota > 10) {
    	            System.out.println("Una nota ingresada no es válida, la nota debe estar entre 0 y 10.");
    	        } else {
    	        	nuevasNotasDouble.add(nota);
    	        }
    		} catch(NumberFormatException e) {
    			continue;
    		}
    	}
        
    	if (nuevasNotasDouble.size() != asignatura.getAlumnos().size()) {
    		System.out.println("Error al agregar calificaciones.");
    		System.out.println("");
    		return false;
    	} else {
    		asignatura.addCalificacion(new Calificacion(nuevasNotasDouble));
    		System.out.println("Calificaciones agregadas con éxito.");
    		System.out.println("");
    	}
    	
    	return true;
    }
    
    public static void errorCrearCalificacion() {
        System.out.println("Error al crear calificacion, asignatura no tiene alumnos");
        System.out.println();
    }
    
    public static Alumno actualAlumno(Alumno alumno) {
		System.out.println("Ingrese nueva informacion del alumno:");
		System.out.print("Ingrese nombre (Nombre original '" + alumno.getNombre() + "'): ");
		alumno.setNombre(input.nextLine());
		System.out.print("Ingrese apellido (Apellido original '" + alumno.getApellido() + "'): ");
		alumno.setApellido(input.nextLine());
		System.out.println("");
		
		return alumno;
	}
	
	public static void alumnoActualizado() {
		System.out.println("Alumno actualizado exitosamente");
		System.out.println("");
	}
	
	public static String ingresarIndiceAsignaturaAlumno() {
        String opcionAsignatura;

        System.out.print("Ingrese el numero de orden de la asignatura: ");
        opcionAsignatura = input.nextLine();
        System.out.println();

        return opcionAsignatura;
    }

	public static void verAsignaturaAlumno(Asignatura asignatura) {
		System.out.println("Informacion de asignatura");
        System.out.println("Nombre: " + asignatura.getNombre());
        System.out.println("Profesor: " + asignatura.getUserProfesor());
        System.out.println();

        System.out.println("Aqui estan los alumnos que estan llevando esta asignatura");
        for (String a : asignatura.getAlumnos()) {
            System.out.println(a);
        }
        System.out.println();
	}
	
	public static void mostrarMedia(List<Double> notas) {
		double suma = 0.0;
		
        for (Double nota : notas) {
            suma += nota;
        }
        
        suma = suma / notas.size();
        
        System.out.printf("Media de la asignatura: %.2f%n", suma);
        System.out.println();
    }
}

