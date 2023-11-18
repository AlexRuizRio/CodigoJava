import java.util.Scanner;

public class juegos {

	public static void main(String[] args) {
		
		BarajaEsp MiBarajaEsp = new BarajaEsp();
		BarajaFra MiBarajaFra = new BarajaFra();
		MiBarajaEsp.formarBaraja();
		MiBarajaFra.formarBaraja();
		
		String jcartas;
		
		Scanner Entrada = new Scanner(System.in);
		
		System.out.println(MiBarajaEsp.BarajaEspañola);
		System.out.println(MiBarajaEsp.BarajaEspañola.size());
		System.out.println(MiBarajaFra.BarajaFrancesa);
		System.out.println(MiBarajaFra.BarajaFrancesa.size());
		
		
		System.out.println("Elige de entre los siguientes juegos de cartas ");
		System.out.println("1 -> Mus");
		System.out.println("2 -> Poker");
		System.out.println("3 -> Cinquillo");
		System.out.println("4 -> Tute");
		System.out.println("5 -> Escoba");
		System.out.println("6 -> Mentiroso");
		jcartas =Entrada.nextLine();
		
		
	
			

		if (jcartas.equalsIgnoreCase("Mus")) {
			for(int i = 0; i < args.length; i++) {
				
				System.out.println(args[i]);
			}
			
			
			
		}else {
			if (jcartas.equalsIgnoreCase("Poker")) {
				
			}if (jcartas.equalsIgnoreCase("Cinquillo")) {
			
		
			}if (jcartas.equalsIgnoreCase("Tute")) {
				
			}if (jcartas.equalsIgnoreCase("Escoba")) {
				
			}if (jcartas.equalsIgnoreCase("Mentiroso")) {
				
			}
		}
	
	}
}

