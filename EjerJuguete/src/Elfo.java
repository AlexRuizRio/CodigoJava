import java.util.Random;

public class Elfo implements Runnable{
	Random ran =  new Random();
	public static int elfosQueTerminaron = 0;
	public void run() {
		int maxjuguetes = ran.nextInt(11) + 10;
		

	    for (int x = 0; x < maxjuguetes; ) {
	        try {
	            Estanteria.sem.acquire(); // entro a la sección crítica

	            if (Estanteria.estanteria.size() < 7) {
	                Thread.sleep(ran.nextInt(2001) + 1000);
	                Estanteria.addJuguete();
	                System.out.println("El elfo dejo un juguete");
					System.out.println("En la estanteria quedan: " + Estanteria.getTamañoEstanteria() + " juguetes");
	                x++; // solo avanzo si efectivamente añado
	            } 
	            // si no hay espacio, no avanzo, solo suelto y reintento
	            Estanteria.sem.release();
	            Thread.sleep(500); // pequeña espera antes de intentar de nuevo
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		elfosQueTerminaron++;
		System.out.println("El elfo acabo su trabajo");

	}
}
