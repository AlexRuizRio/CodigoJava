import java.util.Random;

public class aleatorios 
{

	public static void main(String[] args) 
	{
		Random random = new Random();
        int cantidadNumeros = 40;

        for (int i = 0; i < cantidadNumeros; i++) 
            System.out.print(random.nextInt(101) + " ");
	}

}
