
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "datos_censo")
@XmlType(propOrder = {"titulo", "totalVotantes", "totalConcejales", "ayuntamientos"})
public class DatosCenso {

    private String titulo;
    private int totalVotantes;
    private int totalConcejales;
    private List<Ayuntamiento> ayuntamientos;

    // Getter and Setter methods for the fields

    @XmlElement(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement(name = "total_votantes")
    public int getTotalVotantes() {
        return totalVotantes;
    }

    public void setTotalVotantes(int totalVotantes) {
        this.totalVotantes = totalVotantes;
    }

    @XmlElement(name = "total_concejales")
    public int getTotalConcejales() {
        return totalConcejales;
    }

    public void setTotalConcejales(int totalConcejales) {
        this.totalConcejales = totalConcejales;
    }

    @XmlElement(name = "ayuntamientos")
    public List<Ayuntamiento> getAyuntamientos() {
        return ayuntamientos;
    }

    public void setAyuntamientos(List<Ayuntamiento> ayuntamientos) {
        this.ayuntamientos = ayuntamientos;
    }
}