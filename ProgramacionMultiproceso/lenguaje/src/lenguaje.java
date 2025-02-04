

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class lenguaje 
{
	
	public static void main(String[] args) 
	{
		if (args.length < 2) 
		{
            System.out.println("Uso: java lenguaje <cantidad> <nombreFichero>");
            return;
        }
        int cantidad = Integer.parseInt(args[0]);
        String nombreFichero = args[1];
        Random random = new Random();

        try (FileWriter writer = new FileWriter(nombreFichero)) 
        {
            for (int i = 0; i < cantidad; i++) 
            {
                int longitudPalabra = random.nextInt(6) + 3;
                StringBuilder palabra = new StringBuilder();

                for (int j = 0; j < longitudPalabra; j++) 
                {
                    char letra = (char) ('a' + random.nextInt(26));
                    palabra.append(letra);
                }
                writer.write(palabra.toString() + "\n");
            }
            System.out.println("Archivo generado: " + nombreFichero);
        } catch (IOException e) 
        {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
}
