import java.io.*;
import java.util.concurrent.*;

public class colaborar {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        String nombreFichero = "granFicheroDePalabras.txt";

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            final int cantidadPalabras = i * 10;

            executor.submit(() -> {
                try {
                    String[] comando = {"java", "lenguaje", String.valueOf(cantidadPalabras)};
                    Process proceso = new ProcessBuilder(comando).start();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    String linea;

                    while ((linea = reader.readLine()) != null) {
                        synchronized (lock) {
                            try (FileWriter writer = new FileWriter(nombreFichero, true)) {
                                writer.write(linea + "\n");
                            } catch (IOException e) {
                                System.err.println("Error al escribir en el archivo: " + e.getMessage());
                            }
                        }
                    }

                    proceso.waitFor();
                } catch (IOException | InterruptedException e) {
                    System.err.println("Error al ejecutar el proceso: " + e.getMessage());
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        
        System.out.println("Generación de palabras completada. Archivo final escrito.");
    }
}
