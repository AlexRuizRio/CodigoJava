import java.util.Random;

public class Elfo implements Runnable{
	Random ran =  new Random();
	public void run() {
		int maxjuguetes = ran.nextInt(10, 21);
		
		for(int x = 0; x < maxjuguetes; x++)
		{
			try {
				while(Estanteria.estanteria.size() == 7)
					Thread.sleep(1000);
				
				Estanteria.sem.acquire();
				Thread.sleep(ran.nextInt(1000, 3001));
				Estanteria.addJuguete();
				System.out.println("El elfo dejo un juguete");
				Estanteria.sem.release();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
