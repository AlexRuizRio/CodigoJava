import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class ProgramadorTareas {

	public static void main(String[] args) {
		
		File archivo = new File("C:\\Users\\alex_\\Documents\\tareas8.txt");
		
		
		Usuario accesoU = new Usuario();
		Tareas accesoT = new Tareas();
		
		accesoU.leerFichero();
		accesoT.leerFichero(archivo);
		TreeSet<String> listaU =accesoU.obtenerUsuario();
		HashSet<String> listaT=accesoT.obtenerUsuario();
		Iterator<String> itU=listaU.iterator();
		Iterator<String> itT=listaT.iterator();
		Iterator<String> itT1=listaT.iterator();
		
		
		while(itU.hasNext() && itT.hasNext()) { 
				System.out.println("El usuario "+ itU.next() +" tiene que realizar la tarea "+itT.next() );
					itU.remove();
				if(itT.hasNext()==false) {
					while(itU.hasNext() || itT.hasNext()) {
					System.out.println("El usuario "+ itU.next() +" tiene que realizar la tarea "+itT1.next() );
					}
				}
		}
	}

}
