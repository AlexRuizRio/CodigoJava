
class Buffer {
	 private final char[] buffer;
	    private int size = 0;

	    public Buffer(int capacity) {
	        buffer = new char[capacity];
	    }

	    public synchronized void producir(char c) throws InterruptedException {
	        while (size == buffer.length) {
	            wait(); // Espera si el búfer está lleno
	        }
	        buffer[size] = c; // Inserta al final
	        size++;
	        notifyAll(); // Notifica a los consumidores que hay datos disponibles
	    }

	    public synchronized char consumir() throws InterruptedException {
	        while (size == 0) {
	            wait(); // Espera si el búfer está vacío
	        }
	        char c = buffer[size - 1]; // Consume desde el final
	        size--;
	        notifyAll(); // Notifica a los productores que hay espacio disponible
	        return c;
	    }

	    public synchronized boolean puedeProducir(int cantidad) {
	        return (size + cantidad) <= buffer.length;
	    }

	    public synchronized boolean puedeConsumir(int cantidad) {
	        return size >= cantidad;
	    }
}

