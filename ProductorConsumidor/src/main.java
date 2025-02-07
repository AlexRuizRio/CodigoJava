
public class main {

	public static void main(String[] args) {
		 Buffer buffer = new Buffer(15);

	        Thread productor = new Thread(new Productor(buffer, 15));
	        Thread consumidor = new Thread(new Consumidor(buffer, 15));

	        productor.start();
	        consumidor.start();
	    }

	}

