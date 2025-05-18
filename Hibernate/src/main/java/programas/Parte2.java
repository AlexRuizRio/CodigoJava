package programas;

import java.util.List;
import java.util.Scanner;
import modelo.Alumno;
import modelo.Profesor;
import org.hibernate.Session;

public class Parte2 {
    public static void ejecutarConsultas(Session session) {
        Scanner scanner = new Scanner(System.in);

        List<Alumno> alumnos = session.createNamedQuery("Alumno.findAllOrderedByExpediente", Alumno.class).getResultList();
        System.out.println("Alumnos ordenados por ID:");
        for (Alumno a : alumnos) {
            System.out.println(a.getExpediente() + " - " + a.getNombre() + " " + a.getApellidos());
        }

        List<Profesor> profesores = session.createNamedQuery("Profesor.findAllOrderedById", Profesor.class).getResultList();
        System.out.println("\nProfesores ordenados por ID:");
        for (Profesor p : profesores) {
            System.out.println(p.getIdProfesor() + " - " + p.getNombre() + " " + p.getApellido());
        }

        System.out.println("\nIntroduce un patrón de apellido para buscar alumnos:");
        String patron = scanner.next();
        List<Alumno> alumnosFiltrados = session.createNamedQuery("Alumno.findByApellidoPattern", Alumno.class)
                                               .setParameter("apellidoPattern", "%" + patron + "%")
                                               .getResultList();
        System.out.println("Alumnos con apellido que contiene '" + patron + "':");
        for (Alumno a : alumnosFiltrados) {
            System.out.println(a.getExpediente() + " - " + a.getNombre() + " " + a.getApellidos());
        }

        List<Object[]> encuentros = session.createNamedQuery("Calendario.listarEncuentros").getResultList();
        System.out.println("\nLista de encuentros:");
        for (Object[] e : encuentros) {
            System.out.println("Actividad: " + e[0] + " | Equipos: " + e[1] + " vs " + e[2] +" | Fecha: " + e[3] + " | Hora: " + e[4] + " | Lugar: " + e[5]);
        }

        System.out.println("\nIntroduce el nombre del deporte para ver los resultados:");
        String deporte = scanner.next();
        List<Object[]> resultados = session.createNamedQuery("Calendario.listarResultadosPorDeporte").setParameter("deporte", deporte).getResultList();
        System.out.println("Resultados de " + deporte + ":");
        for (Object[] r : resultados) {
            System.out.println("Fecha: " + r[0] + " | Hora: " + r[1] +" | " + r[2] + " (ID: " + r[3] + ") vs " + r[4] + " (ID: " + r[5] + ")" +" | Resultado: " + r[6] + " - " + r[7]);
        }
    }
}
