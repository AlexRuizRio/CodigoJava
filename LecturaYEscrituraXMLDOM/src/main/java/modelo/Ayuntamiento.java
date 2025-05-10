package modelo;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ayuntamiento {
    private String ts;
    private String nombre;
    private int concejales;
    private int votantes;
    private float porBlancos;

    @XmlElement
    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public int getConcejales() {
        return concejales;
    }

    public void setConcejales(int concejales) {
        this.concejales = concejales;
    }

    @XmlElement
    public int getVotantes() {
        return votantes;
    }

    public void setVotantes(int votantes) {
        this.votantes = votantes;
    }

    @XmlElement
    public float getPorBlancos() {
        return porBlancos;
    }

    public void setPorBlancos(float porBlancos) {
        this.porBlancos = porBlancos;
    }
}