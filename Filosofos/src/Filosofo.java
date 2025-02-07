import java.util.concurrent.Semaphore;

class Filosofo implements Runnable {
    private final int id;
    private final Semaphore palilloIzquierdo;
    private final Semaphore palilloDerecho;

    public Filosofo(int id, Semaphore palilloIzquierdo, Semaphore palilloDerecho) {
        this.id = id;
        this.palilloIzquierdo = palilloIzquierdo;
        this.palilloDerecho = palilloDerecho;
    }


    public void run() {
        try {
            while (true) {
                pensar();
                cogerPalillos();
                comer();
                soltarPalillos();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filósofo " + id + " interrumpido.");
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 1000)); 
    }

    private void cogerPalillos() throws InterruptedException {
        if (id % 2 == 0) {
            palilloIzquierdo.acquire();
            palilloDerecho.acquire();
        } else {
            palilloDerecho.acquire();
            palilloIzquierdo.acquire();
        }
        System.out.println("Filósofo " + id + " ha cogido los palillos.");
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comiendo.");
        Thread.sleep((long) (Math.random() * 1000)); 
    }

    private void soltarPalillos() {
        palilloIzquierdo.release(); 
        palilloDerecho.release();  
        System.out.println("Filósofo " + id + " ha soltado los palillos.");
    }
}