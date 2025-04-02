package modelo;

public class Libro {

	 String titulo;
	 String tipo;
	 String editorial;
	 String idioma;
	 int anyo;
	 String autor;
	public Libro(String titulo, String tipo, String editorial, String idioma, int anyo, String autor) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.editorial = editorial;
		this.idioma = idioma;
		this.anyo = anyo;
		this.autor = autor;
	}
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	public Libro(String titulo, String tipo, String editorial, String idioma, int anyo) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.editorial = editorial;
		this.idioma = idioma;
		this.anyo = anyo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", tipo=" + tipo + ", editorial=" + editorial + ", idioma=" + idioma
				+ ", anyo=" + anyo + ", autor=" + autor + "]";
	}
	
}
