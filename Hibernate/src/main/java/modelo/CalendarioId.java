package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class CalendarioId implements Serializable {

    private Integer actividad;
    private Date fecha;
    private String hora;
    private String lugar;

    // Constructor vacío
    public CalendarioId() {}

    public CalendarioId(Integer actividad, Date fecha, String hora, String lugar) {
        this.actividad = actividad;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    // Getters y Setters
    public Integer getActividad() {
        return actividad;
    }

    public void setActividad(Integer actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarioId that = (CalendarioId) o;
        return actividad.equals(that.actividad) &&
                fecha.equals(that.fecha) &&
                hora.equals(that.hora) &&
                lugar.equals(that.lugar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actividad, fecha, hora, lugar);
    }
}
