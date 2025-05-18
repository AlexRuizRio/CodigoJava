import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Malo implements Runnable {
    int juguetesRotos = 0;
    boolean expulsado = false;
    Random ran = new Random();

    public void run() {
        while (juguetesRotos < 3) {
            try {
                boolean conseguido = Estanteria.sem.tryAcquire(1, TimeUnit.SECONDS);

                if (conseguido && Elfo.elfosQueTerminaron != 3) {
                    Juguete juguete = Estanteria.sacarJuguete();

                    if (juguete != null) {
                        System.out.println("Un niño malo saco un juguete");
                        System.out.println("En la estanteria quedan: " + Estanteria.getTamañoEstanteria() + " juguetes");

                        Thread.sleep(3000 + ran.nextInt(3000));

                        System.out.println("Un niño malo rompio un juguete");
                        juguetesRotos++; // Aquí sí cuenta como avance
                        Estanteria.sem.release();
                    } else {
                        Estanteria.sem.release();
                        // No se pudo coger un juguete, pero no cuenta como avance
                        if (Elfo.elfosQueTerminaron == 3) {
                            System.out.println("El niño malo se marchó de la tienda");
                            return; // Sale sin ser expulsado
                        }
                    }
                } else {
                    // No se pudo entrar a la estantería
                    if (Elfo.elfosQueTerminaron == 3) {
                        System.out.println("El niño malo se marchó de la tienda");
                        return;
                    }
                    Thread.sleep(500); // Espera y vuelve a intentar
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Si salió del bucle es porque rompió 3 juguetes
        System.out.println("El niño malo fue expulsado");
    }
}
