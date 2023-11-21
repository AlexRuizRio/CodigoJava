import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;



class Usuario {
	TreeSet <String>listusuarios = new TreeSet();

	
	public void  leerFichero () {
		String linea;
	try {
		
		FileReader unReader = new FileReader("C:\\Users\\alex_\\Documents\\usuario.txt");
		BufferedReader br = new BufferedReader(unReader);
		
		while((linea = br.readLine()) !=null) {
			listusuarios.add(linea);
		}
		
	} catch (IOException e) {
		System.out.println("No se encuentra el archivo");
		}
	
	 }
	 public TreeSet<String> obtenerUsuario() {
		 return listusuarios;
	 }

}