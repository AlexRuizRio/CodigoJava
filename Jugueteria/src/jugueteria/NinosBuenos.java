package jugueteria;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class NinosBuenos implements Runnable{
	
	private final int id;
	private final String tipoJuguete;
	private static final Random ran = new Random();
	
	public NinosBuenos (int id, String tipoJuguete)
	{
		this.id = id;
		this.tipoJuguete = tipoJuguete;
	}
	
	public void run() {
		try {
			Jugueteria.semJugueteDis.acquire();
			Juguete juguete;
			synchronized (Jugueteria.estanteria) {
				juguete = Jugueteria.estanteria.remove(0);
			}
		}catch (Exception e) {
			
		}
	}
}
