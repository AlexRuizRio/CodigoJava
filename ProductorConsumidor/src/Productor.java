import java.util.Random;

public class Productor implements Runnable{
	private final Buffer buffer;
    private final int caracteresAProducir;
    private final Random random = new Random();

    public Productor(Buffer buffer, int caracteresAProducir) {
        this.buffer = buffer;
        this.caracteresAProducir = caracteresAProducir;
    }

    @Override
    public void run() {
        try {
            int producidos = 0;
            while (producidos < caracteresAProducir) {
                int lote = random.nextInt(6) + 1; // Genera un número aleatorio entre 1 y 6
                synchronized (buffer) {
                    while (!buffer.puedeProducir(lote)) {
                        buffer.wait();
                    }
                }
                for (int i = 0; i < lote && producidos < caracteresAProducir; i++) {
                    char c = (char) ('A' + (producidos % 26)); // Genera caracteres secuenciales
                    buffer.producir(c);
                    System.out.println("Productor: producido " + c);
                    producidos++;
                }
                Thread.sleep(random.nextInt(300) + 100); // Tiempo de producción aleatorio entre 100ms y 400ms
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
