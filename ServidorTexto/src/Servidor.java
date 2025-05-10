import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor implements Runnable {

	Socket socket;
	
	public Servidor (Socket socket) {
		this.socket = socket;
	}
	public void run () {
		try {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
		String mensaje;
		while((mensaje = entrada.readLine()) != null && !mensaje.isEmpty()) {
			System.out.println("REcibido");
			salida.println(mensaje.substring(1));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
