import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estanteria {
	public final static Semaphore sem = new Semaphore(7);
	static int contador = 0;
	static ArrayList <Juguete> estanteria = new ArrayList<Juguete>();
	public static String[] tipos = {"muñeco", "vehiculo", "arma", "pelota"};
	
	public static synchronized void addJuguete() {
		if (estanteria.size() < 7)
		{
			 Random ran = new Random();
			 String tipo = tipos [ran.nextInt(tipos.length)];
			Juguete juguete = new Juguete (contador, tipo);
			estanteria.add(juguete);
			contador++;
		}
	}
	
	public static synchronized Juguete sacarJuguete() {
		if (estanteria.isEmpty())
			return null;
		Juguete juguete = estanteria.get(0);
		estanteria.remove(0);
		return (juguete);
	}
	
	public static  synchronized void dejarJuguete(Juguete juguete) {
		estanteria.add(juguete);
	}
	public static synchronized int getTamañoEstanteria() {
	    return estanteria.size();
	}

}
