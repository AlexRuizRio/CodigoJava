import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.*;

public class ValidadorEntrada {
	
	public void validarUsuario() {
		String nUser = new String();
		boolean bandera = true;
		Pattern pat = null;
		Matcher mat = null;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Logger log = Logger.getLogger("MyLog");
		SimpleFormatter form = new SimpleFormatter();

		try {
			log.log(Level.INFO, "Se inicio el programa");
			while(bandera) {
				FileHandler fh = new FileHandler("c:\\pruebalogs\\MyLogFile.log", true);
				fh.setFormatter(form);
				log.setLevel(Level.ALL);
				
				System.out.println("Introduzca el nombre de usuario");
				nUser = entrada.readLine();
				//System.out.println(nUser);
				pat = Pattern.compile("[a-z]{8}");
				mat = pat.matcher(nUser);
				if(mat.matches()) {
					bandera = false;
					log.log(Level.INFO, "El usuario " + nUser + " entro en la aplicacion");
				}else {
					System.out.println("El usuario tiene que ser en minusculas y de 8 caracteres");
					log.log(Level.WARNING, "El usuario " + nUser + " fallo la validacion del login");
				}
			}
			System.out.println("Bienvenido " + nUser);
			validarFichero(pat, mat, log, entrada, nUser);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void validarFichero(Pattern pat, Matcher mat, Logger log, BufferedReader entrada, String nUser) {
		String nFichero = new String();
		boolean bandera = true;
		try {
			while(bandera) {
				System.out.println("Introduzca el nombre del fichero que quieras leer");
				nFichero = entrada.readLine();
				pat = Pattern.compile("[a-zA-Z0-9]{1,8}\\.[a-zA-Z0-9]{3}");
				mat = pat.matcher(nFichero);
				if(mat.matches()) {
					log.log(Level.INFO, "El " + nUser + " solicito que se mostrase el archivo " + nFichero);
					try(BufferedReader br = new BufferedReader(new FileReader(nFichero)))
					{
						String linea;
						while ((linea = br.readLine()) != null) {
							System.out.println(linea);
						}
						log.log(Level.INFO, "El " + nUser + " se le mostro todo el fichero");
						bandera = false;
					}catch (FileNotFoundException e) {
						System.out.println("El archivo no existe");
						log.log(Level.WARNING, "El usuario " + nUser + " intento acceder a un archivo que no existe");
					}

				} else {
					System.out.println("El archivo " + nFichero + " no cumple con la validacion");
					log.log(Level.WARNING, "El usuario " + nUser + "intento acceder al fichero " + nFichero + " y se le denego el acceso");
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		ValidadorEntrada valid = new ValidadorEntrada();
		valid.validarUsuario();

	}

}
