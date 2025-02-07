import java.util.concurrent.Semaphore;

public class main {

	public static void main(String[] args) {
		final int NUM_FILOSOFOS = 5;
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];
        Semaphore[] palillos = new Semaphore[NUM_FILOSOFOS];

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            palillos[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            filosofos[i] = new Filosofo(i, palillos[i], palillos[(i + 1) % NUM_FILOSOFOS]);
            new Thread(filosofos[i]).start();
        }

	}

}
