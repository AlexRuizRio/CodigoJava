import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	
	public static void main(String[] args) {
		int puerto = 2000;
		
		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor iniciado en el puerto: " + puerto);
			while (true) {
				Socket cliente = servidor.accept();
					Thread hilo = new Thread (new Servidor(cliente));
					hilo.start();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
