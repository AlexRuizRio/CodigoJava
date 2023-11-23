import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ayuntamiento")
@XmlType(propOrder = {"nombre", "concejales", "votantes"})
public class Ayuntamiento {

    private int ts;
    private String nombre;
    private int concejales;
    private int votantes;

    // Getter and Setter methods for the fields

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "concejales")
    public int getConcejales() {
        return concejales;
    }

    public void setConcejales(int concejales) {
        this.concejales = concejales;
    }

    @XmlElement(name = "votantes")
    public int getVotantes() {
        return votantes;
    }

    public void setVotantes(int votantes) {
        this.votantes = votantes;
    }
}