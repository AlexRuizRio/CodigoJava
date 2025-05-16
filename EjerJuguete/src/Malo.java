
public class Malo implements Runnable{
	int juguetesRotos = 3;
	
	public void run () {
		for(int x = 0; x < 3; x++) {
			try {
			Estanteria.sem.acquire();
			Estanteria.sacarJuguete();
			Thread.sleep(3000, 6000);
			Estanteria.sem.release();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
