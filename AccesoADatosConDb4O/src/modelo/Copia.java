package modelo;

public class Copia {

public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
int id;
String estado;
Libro  libro;
	public Copia(int id, String estado, Libro libro) {
	super();
	this.id = id;
	this.estado = estado;
	this.libro = libro;
}
	public Copia() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Copia [id=" + id + ", estado=" + estado + ", libro=" + libro + "]";
	}

}
