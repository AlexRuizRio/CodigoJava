import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;


class Tareas {
	HashSet listareas = new HashSet();
	Scanner EntradaP = new Scanner (System.in);
	
	
	
	public void leerFichero (File archivo) {
		String linea;
	try {
		Scanner Entrada = new Scanner (archivo);
		
		while (Entrada.hasNextLine()) {
			linea=Entrada.nextLine();
			listareas.add(linea);
		}
		
		
	} catch (IOException e) {
		System.out.println("Proporcine las 5 tareas a realizar");
		for(int i =0; i<5;i++) {
			String tarea;
			System.out.println("Escriba la "+ (i+1) +" tarea y pulse ENTER");
			tarea=EntradaP.nextLine();
			listareas.add(tarea);
			}
		
		}
		List<String> list = new ArrayList<String>(listareas);
		Collections.shuffle(list);
		listareas= new HashSet<String>(list);
		
	 }
	
	public HashSet<String> obtenerUsuario() {
		return listareas;
	}
}

