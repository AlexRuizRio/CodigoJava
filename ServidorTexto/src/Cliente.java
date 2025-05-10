import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String host = "localhost";
		int puerto = 2000;
		
		System.out.println("Hola, inserte una cadena de texto por favor:");
		String cadena = scan.nextLine();
		try (Socket socket = new Socket(host, puerto)) {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			String cmodificada;
			salida.println(cadena);
			while((cmodificada = entrada.readLine()) != null && !cmodificada.isEmpty()) {
				System.out.println("La cadena que devolvio el servidor es:");
				System.out.println(cmodificada);
				
				salida.println(cmodificada);	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
