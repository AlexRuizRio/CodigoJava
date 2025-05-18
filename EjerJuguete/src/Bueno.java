import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Bueno implements Runnable{
	Random rand = new Random();
	public void run () {
		boolean bandera = true;;
		
		while(bandera) {
			try {
			boolean conseguido = Estanteria.sem.tryAcquire(1, TimeUnit.SECONDS);
			
			if (conseguido && Elfo.elfosQueTerminaron != 3) {
				Juguete juguete = Estanteria.sacarJuguete();
				if (juguete != null) {
					System.out.println("El niño bueno cogio un juguete");
					System.out.println("En la estanteria quedan: " + Estanteria.getTamañoEstanteria() + " juguetes");
					Thread.sleep(rand.nextInt(3001) + 2000);
					Estanteria.dejarJuguete(juguete);
					System.out.println("El niño bueno devolvio un juguete");
					System.out.println("En la estanteria quedan: " + Estanteria.getTamañoEstanteria() + " juguetes");
					Estanteria.sem.release();
				}else {
					Estanteria.sem.release();
				}
			} else {
				if (Elfo.elfosQueTerminaron == 3) {
					bandera = false;
					System.out.println("El niño bueno se marcho porque no hya juguetes ni elfos");
				}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
