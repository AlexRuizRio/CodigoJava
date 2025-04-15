package jugueteria;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class NinosMalos implements Runnable{

	private final int id;
	private static final Random ran = new Random();
	
	public NinosMalos (int id)
	{
		this.id = id;
	}
	
	public void run() {
		int juguetesrotos = 0;
		
		while (juguetesrotos < 3)
		{
			try {
			Jugueteria.semJugueteDis.acquire();
			Juguete juguete;
			synchronized (Jugueteria.estanteria) {
				juguete = Jugueteria.estanteria.remove(0);
			}
			System.out.println("El niño malo " + id + " ha cogido el/la " + juguete.getTipo());
			Thread.sleep(3000, ran.nextInt(5000));
			System.out.println("El niño malo " + id + " rompio el/la " + juguete.getTipo());
			
			juguetesrotos++;
			Jugueteria.semHuecosEstan.release();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("El niño malo numero " + id +" fue EXPULSADO de la tienda");
	}
}
