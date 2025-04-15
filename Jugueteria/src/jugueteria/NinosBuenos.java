package jugueteria;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class NinosBuenos implements Runnable{
	
	private final int id;
	private static final Random ran = new Random();
	
	public NinosBuenos (int id)
	{
		this.id = id;
	}
	
	public void run() {
		try {
			Jugueteria.semJugueteDis.acquire();
			Juguete juguete;
			synchronized (Jugueteria.estanteria) {
				juguete = Jugueteria.estanteria.remove(0);
			}
			Jugueteria.semHuecosEstan.release();
			System.out.println("El niño bueno " + id + " ha cogido el/la " + juguete.getTipo());
			
			Thread.sleep(1000, ran.nextInt(5000));
			
			synchronized (Jugueteria.estanteria) {
				Jugueteria.estanteria.add(juguete);
			}
			
			System.out.println("El niño bueno " + id + " devolvio el/la " + juguete.getTipo());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
