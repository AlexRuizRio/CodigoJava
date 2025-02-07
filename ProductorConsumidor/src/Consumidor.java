import java.util.Random;

public class Consumidor implements Runnable{
	 private final Buffer buffer;
	    private final int caracteresAConsumir;
	    private final Random random = new Random();

	    public Consumidor(Buffer buffer, int caracteresAConsumir) {
	        this.buffer = buffer;
	        this.caracteresAConsumir = caracteresAConsumir;
	    }

	    @Override
	    public void run() {
	        try {
	            int consumidos = 0;
	            while (consumidos < caracteresAConsumir) {
	                int lote = random.nextInt(6) + 1; // Genera un número aleatorio entre 1 y 6
	                synchronized (buffer) {
	                    while (!buffer.puedeConsumir(lote)) {
	                        buffer.wait();
	                    }
	                }
	                for (int i = 0; i < lote && consumidos < caracteresAConsumir; i++) {
	                    char c = buffer.consumir();
	                    System.out.println("Consumidor: consumido " + c);
	                    consumidos++;
	                }
	                Thread.sleep(random.nextInt(300) + 100); // Tiempo de consumo aleatorio entre 100ms y 400ms
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
}
