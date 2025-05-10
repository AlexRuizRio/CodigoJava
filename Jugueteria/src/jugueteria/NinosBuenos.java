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
		while(true)
		{
			try {
				Jugueteria.semJugueteDis.acquire();
				if(Jugueteria.latchElfos.getCount() == 0 && Jugueteria.semJugueteDis.availablePermits() == 0)
				{
					System.out.println("El niño bueno " + id + " se marcha de la tienda");
					Jugueteria.semJugueteDis.release();
					break;
				}
				Juguete juguete;
				
				synchronized (Jugueteria.estanteria) {
					juguete = Jugueteria.estanteria.remove(0);
				}
				Jugueteria.semHuecosEstan.release();
				System.out.println("El niño bueno " + id + " ha cogido el/la " + juguete.getTipo());
				
				Thread.sleep(1000, ran.nextInt(5000));
				
				Jugueteria.semHuecosEstan.acquire();
				synchronized (Jugueteria.estanteria) {
					Jugueteria.estanteria.add(juguete);
				}
				Jugueteria.semJugueteDis.release();
				System.out.println("El niño bueno " + id + " devolvio el/la " + juguete.getTipo());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
