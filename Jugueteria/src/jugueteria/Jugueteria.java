package jugueteria;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class Jugueteria {
	public static final Semaphore semJugueteDis = new Semaphore (0, true);
	public static final Semaphore semHuecosEstan = new Semaphore (7, true);
	private static final Random ran = new Random();
	
	public static final List<Juguete> estanteria = Collections.synchronizedList(new ArrayList<>());
	private static int idJuguete = 1;
	
	public static synchronized int getNextId() {
		return idJuguete;
	}
	public static void main(String[] args) {
		for( int x = 1; x <= 3; x++)
		{
			int maxjuguetes = ran.nextInt(10, 20);
			new Thread(new Elfos(x, maxjuguetes)).start();;
		}
		for (int x = 1; x<= 5; x++)
		{
			new Thread(new NinosBuenos(x)).start();
		}
		for (int x = 1; x <= 20; x++) {
			new Thread(new NinosMalos(x)).start();
		}

	}

}
