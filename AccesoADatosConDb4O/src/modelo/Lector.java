package modelo;

public class Lector {
	public Lector(int nsocio, String nombre, String ape1, String ape2, String telefono, String direccion) {
		super();
		this.nsocio = nsocio;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	int nsocio;
	String nombre;
	String ape1;
	String ape2;
	String telefono;
	String direccion;
	Multa multa;



	public Lector(int nsocio, String telefono, String nombre, String ape1, String ape2) {
		super();
		this.nsocio = nsocio;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.telefono = telefono;
	}

	public Lector() {
		// TODO Auto-generated constructor stub
	}

	public int getNsocio() {
		return nsocio;
	}

	public void setNsocio(int nsocio) {
		this.nsocio = nsocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	@Override
	public String toString() {
		return "Lector [nsocio=" + nsocio + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", telefono="
				+ telefono + ", direccion=" + direccion + ", multa=" + multa + "]";
	}

}
