import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

final class Cliente {
	String mensaje;
	public Cliente (String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void conexionACliente (String mensaje) {
			try {
			Socket socket = new Socket("localhost", 2000);
			System.out.println("Cliente conectaco al Servidor");
			
			envioDeString(socket, mensaje);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	private void envioDeString(Socket socket, String mensaje) {
		
			try{
				BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
				while(mensaje != null && !mensaje.isBlank()) {
					salida.println(mensaje);
					System.out.println("Mensaje enviado al Servidor:");
					System.out.println(mensaje);
					
					mensaje = entrada.readLine();
					if (mensaje == null || mensaje.isEmpty())
						break;
				}
				entrada.close();
				salida.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Introduzca la cadena de texto");
		String mensaje = scan.nextLine();
		Cliente cliente = new Cliente (mensaje);
		cliente.conexionACliente(mensaje);
		scan.close();

	}

}
