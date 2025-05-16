

public class Main {

	public static void main(String[] args) {
		for( int x = 1; x <= 3; x++)
		{
			new Thread(new Elfo()).start();;
		}
		for (int x = 1; x<= 5; x++)
		{
			new Thread(new Bueno()).start();
		}
		for (int x = 1; x <= 20; x++) {
			new Thread(new Malo()).start();
		}

	}

}
