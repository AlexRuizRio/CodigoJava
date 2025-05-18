package pruebajaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ayuntamiento")
public class Ayuntamiento {
	private String nombre;
	private String ts;
	private int concejales;
	
	public Ayuntamiento ( String nombre, String ts, int concejales) {
		this.nombre = nombre;
		this.ts = ts;
		this.concejales = concejales;
	}
	public Ayuntamiento () {}
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name="ts")
	public String getTs() {
		return ts;
	}
	public void setTs (String ts) {
		this.ts = ts;
	}
	@XmlElement(name="concejales")
	public int getConcejales() {
		return concejales;
	}
	public void setConcejales() {
		this.concejales = concejales;
	}
}
