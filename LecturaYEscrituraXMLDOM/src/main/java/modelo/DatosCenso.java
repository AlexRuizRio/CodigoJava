package modelo;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "datos_censo")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatosCenso {

    private String titulo;
    private int total_votantes;
    private int total_concejales;
    private float total_porblanco;

    public float getTotal_porblanco() {
		return total_porblanco;
	}
	public void setTotal_porblanco(float total_porblanco) {
		this.total_porblanco = total_porblanco;
	}
	@XmlElementWrapper(name = "ayuntamientos")
    @XmlElement(name = "ayuntamiento")
    private List<Ayuntamiento> ayuntamientos;

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getTotal_votantes() { return total_votantes; }
    public void setTotal_votantes(int total_votantes) { this.total_votantes = total_votantes; }

    public int getTotal_concejales() { return total_concejales; }
    public void setTotal_concejales(int total_concejales) { this.total_concejales = total_concejales; }

    public List<Ayuntamiento> getAyuntamientos() { return ayuntamientos; }
    public void setAyuntamientos(List<Ayuntamiento> ayuntamientos) { this.ayuntamientos = ayuntamientos; }
}
