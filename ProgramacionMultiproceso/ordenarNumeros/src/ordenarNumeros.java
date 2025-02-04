import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ordenarNumeros 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Introduce números (escribe 'fin' para terminar):");
        while (scanner.hasNext()) 
        {
            if (scanner.hasNextInt()) 
                numeros.add(scanner.nextInt());
            else 
            {
                String input = scanner.next();
                if (input.equalsIgnoreCase("fin")) 
                    break;
                else 
                    System.out.println("Entrada no válida, intenta de nuevo.");
            }
        }
        Collections.sort(numeros);
        System.out.println("Números ordenados:");
        for (int num : numeros) 
            System.out.print(num + " ");
	}

}
