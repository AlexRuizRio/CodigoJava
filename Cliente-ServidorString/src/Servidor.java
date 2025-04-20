import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	int puerto;
	
	public Servidor(int puerto) {
		this.puerto = puerto;
	}

	public void conexionCliente() {

		try (ServerSocket servidor = new ServerSocket(puerto))
		{
			System.out.println("Servidor iniciado Puerto: " + puerto);
			while(true)
			{
				Socket clienteSocket = servidor.accept();
				System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress());
				manejoString(clienteSocket);
			}
		}catch (IOException e)
		{
			System.err.println("Error en el servidor" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void manejoString(Socket clienteSocket) {
	    try {
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
	        PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

	        String mensaje;

	        //  El servidor sigue escuchando mientras el cliente mande algo
	        while ((mensaje = entrada.readLine()) != null && !mensaje.isEmpty()) {
	            System.out.println("El cliente mando:");
	            System.out.println(mensaje);

	            String modificado = (mensaje.length() > 1) ? mensaje.substring(1) : "";

	            System.out.println("Mensaje devuelto:");
	            System.out.println(modificado);

	            salida.println(modificado); // Responde al cliente
	        }

	        //  Cierre de recursos
	        entrada.close();
	        salida.close();
	        clienteSocket.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor(2000);
		servidor.conexionCliente();
	}
}
