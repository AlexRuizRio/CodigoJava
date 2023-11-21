

public class Academia {

	//Variables
	String nombre;
	private String reservasUnoSeSUno = "";
	private String reservasDosSeSUno = "";
	private String reservasUnoSesDos = "";
	private String reservasDosSeSDos = "";
	final int NUMPLAZAS = 2;
	int sesion10 = 0;
	int sesion11=0;
	
	// Metodos
	public  Academia (String actividad) {
		nombre = actividad;
	}
	
	  private boolean comprobarDisp (int iSesion) {
		  boolean completo = false;
		  if (iSesion == 10) {
				if (sesion10 == NUMPLAZAS) {
					completo = true;	
				}
			}else {
				if (sesion11 == NUMPLAZAS) {
					completo = true;
				}
			}
		
		return completo;
	  }
	public void reservarPlaza (int iSesion, String sNombre) {
		 boolean completo = comprobarDisp (iSesion);
		 if (completo) {
			 System.out.println("Esta sesion esta completa");
	
		 }else
			 if (iSesion == 10) {
				if (sesion10 == 0) {
					reservasUnoSeSUno = sNombre;
				}else {
					reservasDosSeSUno =sNombre;
				}
				sesion10++;
			 }else {
				 if (sesion11 == 0) {
					 	reservasUnoSesDos = sNombre;
					}else {
						reservasDosSeSDos =sNombre;
					}
					sesion11++;
			 }
		
	}
	public String infoSesion(int iSesion) {
		
		String resultado = "";
		resultado = nombre + " -- Sesion ";
			if (iSesion == 10) {
				resultado += "10 -- Asistentes " + reservasUnoSeSUno + " , " + reservasDosSeSUno;
			}else {
				resultado += "11 -- Asistentes " + reservasUnoSesDos + " , " + reservasDosSeSDos;
			}
		
		return resultado;
	}
}
