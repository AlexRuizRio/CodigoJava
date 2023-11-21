import java.util.Scanner;

public class Agenda {
	
	static Academia Ingles = new Academia ("Ingles");
	static Academia Musica = new Academia ("Musica");
	static Academia Baile = new Academia ("Baile");
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);

		int alumnospreguntados = 0;
		boolean continuar = true;
		do {
			System.out.println("Introduzca el nombre del alumno o ponga FIN");
			String alumno =teclado.nextLine();
			if (alumno.equalsIgnoreCase("FIN")) {
				continuar = false;
			}
			if (continuar) 
			{
				String actividad = "";
				do  {
				System.out.println("¿Que actividad quieres baile, musica o ingles?");
				 actividad =teclado.nextLine();
				}while (!actividad.equalsIgnoreCase("baile") && !actividad.equalsIgnoreCase("musica") && !actividad.equalsIgnoreCase("ingles"));
				String sesion = "";
				do  {
				System.out.println("¿Que sesion quieres la de las 10 o las 11?");
				 sesion =teclado.nextLine();
				}while (!sesion.equalsIgnoreCase("10") && !sesion.equalsIgnoreCase("11"));
				int ses = Integer.parseInt(sesion);
				if (actividad.equalsIgnoreCase("baile")) {
					Baile.reservarPlaza(ses, alumno);
					
				}else {
					if (actividad.equalsIgnoreCase("musica")) {
						Musica.reservarPlaza(ses, alumno);
					}else {
						Ingles.reservarPlaza(ses, alumno);
					}
				}
					
			}
			alumnospreguntados++;
		}while (continuar && alumnospreguntados < 4);
		mostrarAgenda ();
	}
	private static void mostrarAgenda () {
		
			System.out.println(Ingles.infoSesion(10));
			System.out.println(Ingles.infoSesion(11));
			System.out.println(Musica.infoSesion(10));
			System.out.println(Musica.infoSesion(11));
			System.out.println(Baile.infoSesion(10));
			System.out.println(Baile.infoSesion(11));
	}

}