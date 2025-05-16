import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Estanteria {
	public final static Semaphore sem = new Semaphore(7);
	static ArrayList <Juguete> estanteria = new ArrayList<Juguete>();
	public static String[] tipos = {"muñeco", "vehiculo", "arma", "pelota"};
	
	public static void  addJuguete() {
		int contador = 1;

		 Random ran = new Random();
		 String tipo = tipos [ran.nextInt(tipos.length)];
		Juguete juguete = new Juguete (contador, tipo);
		estanteria.add(juguete);
	}
	
	public static Juguete sacarJuguete() {
		if (estanteria.isEmpty())
			return null;
		Juguete juguete = estanteria.get(0);
		estanteria.remove(0);
		return (juguete);
	}
	
	public static void dejarJuguete(Juguete juguete) {
		estanteria.add(juguete);
	}
	
}
