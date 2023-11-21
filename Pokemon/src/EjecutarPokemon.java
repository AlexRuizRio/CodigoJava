import java.util.Scanner;

public class EjecutarPokemon {
	static RaichuAlola miRaichuAlola = null;
	static RaichuKanto miRaichuKanto = null;
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Elige el tipo de Raichu: Alola o Kanto");
		String mipokemon =teclado.nextLine();
		if (mipokemon.equalsIgnoreCase("Alola")) {
			RaichuAlola miRaichuAlola = new RaichuAlola(5,5,mipokemon);
			
			System.out.println("Elige una opcion del siguiente menu");
			System.out.println("Opcion 1-> Luchar");
			System.out.println("Opcion 2-> Entrenar");
			System.out.println("Opcion 3-> Volar");
			System.out.println("Opcion 4-> Fin");
			
			boolean repite = true;
			while (repite == true) {
				String opciones = teclado.nextLine();
				if (opciones.equalsIgnoreCase("Fin") || opciones.equals("4")) {
					repite = false;
				System.out.println(miRaichuAlola.toString());
				
				}else {
				
				 if(opciones.equalsIgnoreCase("Volar") || opciones.equals("3")) {
					
					miRaichuAlola.Volar();
					
				}if(opciones.equalsIgnoreCase("Entrenar") || opciones.equals("2")) {
					miRaichuAlola.Entrenar();
					
					
				}if(opciones.equalsIgnoreCase("Luchar") || opciones.equals("1")) {
					miRaichuAlola.Luchar();
					
					}
				System.out.println(miRaichuAlola.toString());
				}
				
			}
		}
		else { if(mipokemon.equalsIgnoreCase("Kanto")) {
			System.out.println("Cuanta vida tiene tu pokemon");
				int vida = teclado.nextInt();
				System.out.println("Cuanta energia tiene tu pokemon");
				int energia = teclado.nextInt();
				RaichuKanto miRaichuKanto = new RaichuKanto(vida, energia, mipokemon);
				System.out.println("Elige una opcion del siguiente menu");
				System.out.println("Opcion 1-> Luchar");
				System.out.println("Opcion 2-> Entrenar");
				System.out.println("Opcion 3-> Fin");
				
				boolean repite = true;
				while (repite == true) {
					String opciones = teclado.nextLine();
					if (opciones.equalsIgnoreCase("Fin") || opciones.equals("3")) {
						repite = false;
					System.out.println(miRaichuKanto.toString());
					
					}else {
					
					 if(opciones.equalsIgnoreCase("Entrenar") || opciones.equals("2")) {
						miRaichuKanto.Entrenar();
						
						
					}if(opciones.equalsIgnoreCase("Luchar") || opciones.equals("1")) {
						miRaichuKanto.Luchar();
						
						}
					System.out.println(miRaichuKanto.toString());
					}
					
				}
			
				
				}
			}
	
		System.out.println("Fin del programa");
	}
}