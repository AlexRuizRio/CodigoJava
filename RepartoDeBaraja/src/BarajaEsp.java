import java.util.HashSet;



public class BarajaEsp {
	
		
	HashSet <String> BarajaEspañola =new HashSet<>();
	
		 void formarBaraja () {
			 
		for (int i = 1; i <= 7; i++) {
			BarajaEspañola.add(i + " de Oros");
			
		}
		for ( int y = 1; y <= 7; y++) {
			BarajaEspañola.add(y + " de Bastos");
			
		}
		for (int z = 1; z <= 7; z++) {
			BarajaEspañola.add(z + " de Copas");
			
		}
		for (int c = 1; c <= 7; c++) {
			BarajaEspañola.add(c + " de Espadas");
			
		}
		BarajaEspañola.add("Sota de Oros");
		BarajaEspañola.add("Caballo de Oros");
		BarajaEspañola.add("Rey de Oros");
		BarajaEspañola.add("Sota de Bastos");
		BarajaEspañola.add("Caballo de Bastos");
		BarajaEspañola.add("Rey de Bastos");
		BarajaEspañola.add("Sota de Copas");
		BarajaEspañola.add("Caballo de Copas");
		BarajaEspañola.add("Rey de Copas");
		BarajaEspañola.add("Sota de Espadas");
		BarajaEspañola.add("Caballo de Espadas");
		BarajaEspañola.add("Rey de Espadas");
	
		}
}

