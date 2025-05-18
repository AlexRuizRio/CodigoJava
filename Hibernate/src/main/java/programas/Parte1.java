package programas;

import modelo.Actividad;
import modelo.Alumno;
import modelo.Calendario;
import modelo.CalendarioId;
import modelo.Equipo;
import modelo.Participante;
import modelo.Profesor;
import modelo.Tutoria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Parte1 {

	public static void obtenerDetallesEncuentro(Session session) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Introduce el ID de la actividad:");
	    int idActividad = scanner.nextInt();

	    scanner.nextLine();

	    System.out.println("Introduce la fecha del encuentro (YYYY-MM-DD):");
	    String fechaString = scanner.nextLine();

	    Date fecha = null;
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        fecha = sdf.parse(fechaString);
	    } catch (Exception e) {
	        System.out.println("Formato de fecha inválido.");
	        return;
	    }

	    System.out.println("Introduce la hora del encuentro (HH:MM:SS):");
	    String hora = scanner.nextLine();

	    System.out.println("Introduce el lugar del encuentro:");
	    String lugar = scanner.nextLine();

	    Calendario calendario = session.get(Calendario.class, new CalendarioId(idActividad, fecha, hora, lugar));

	    if (calendario != null) {
	        System.out.println("Actividad: " + calendario.getActividad().getActividad());
	        System.out.println("Equipos enfrentados: " + calendario.getEquipoA().getNombre() + " vs " + calendario.getEquipoB().getNombre());

	        System.out.println("Participantes de " + calendario.getEquipoA().getNombre() + ":");
	        for (Participante participante : calendario.getEquipoA().getParticipantes()) {
	            Alumno alumno = participante.getAlumno();
	            System.out.println("Nombre: " + alumno.getNombre() + " " + alumno.getApellidos());
	            System.out.println("Expediente: " + alumno.getExpediente());
	            System.out.println("Fecha de nacimiento: " + alumno.getFechaNacimiento());
	            System.out.println("---");
	        }

	        System.out.println("Participantes de " + calendario.getEquipoB().getNombre() + ":");
	        for (Participante participante : calendario.getEquipoB().getParticipantes()) {
	            Alumno alumno = participante.getAlumno();
	            System.out.println("Nombre: " + alumno.getNombre() + " " + alumno.getApellidos());
	            System.out.println("Expediente: " + alumno.getExpediente());
	            System.out.println("Fecha de nacimiento: " + alumno.getFechaNacimiento());
	            System.out.println("---");
	        }
	    } else {
	        System.out.println("No se encontró el encuentro.");
	    }
	}


	public static void obtenerDetallesProfesor(Session session) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Introduce el ID del profesor:");
	    int idProfesor = scanner.nextInt();

	    Profesor profesor = session.get(Profesor.class, idProfesor);

	    if (profesor != null) {
	        System.out.println("Nombre: " + profesor.getNombre() + " " + profesor.getApellido());
	        System.out.println("Departamento: " + profesor.getDepartamento().getNombre());

	        for (Tutoria tutoria : profesor.getTutorias()) {
	            System.out.println("Curso: " + tutoria.getCurso().getCurso());
	            System.out.println("Día: " + tutoria.getDiaSemana());
	            System.out.println("Hora: " + tutoria.getHoraTutoria());
	            System.out.println("---");
	        }
	    } else {
	        System.out.println("No se encontró al profesor.");
	    }
	}

	public static void actualizarEncuentro(Session session) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Introduce el ID de la actividad:");
	    int idActividad = scanner.nextInt();
	    scanner.nextLine();

	    System.out.println("Introduce la fecha del encuentro (YYYY-MM-DD):");
	    String fechaString = scanner.nextLine();

	    Date fecha = null;
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        fecha = sdf.parse(fechaString);
	    } catch (Exception e) {
	        System.out.println("Formato de fecha inválido.");
	        return;
	    }
	    System.out.println("Introduce la hora del encuentro (HH:MM):");
	    String hora = scanner.next();

	    System.out.println("Introduce el lugar del encuentro:");
	    String lugar = scanner.next();

	    System.out.println("Introduce el resultado del Equipo A:");
	    int resultadoEquipoA = scanner.nextInt();

	    System.out.println("Introduce el resultado del Equipo B:");
	    int resultadoEquipoB = scanner.nextInt();

	    Calendario calendario = session.get(Calendario.class, new CalendarioId(idActividad, fecha, hora, lugar));

	    if (calendario != null) {
	        calendario.setResultadoEquipoA(resultadoEquipoA);
	        calendario.setResultadoEquipoB(Integer.toString(resultadoEquipoB));
	        session.beginTransaction();
	        session.update(calendario);
	        session.getTransaction().commit();
	        System.out.println("El resultado ha sido actualizado.");
	    } else {
	        System.out.println("El encuentro no existe.");
	    }
	}

}
