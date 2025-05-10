package jugueteria;

public class Juguete {
	private int id;
	private String tipo;
	
	public Juguete (int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
