package modelo;

import javax.persistence.*;

@Entity
@Table(name = "Actividades")
public class Actividad {

    @Id
    @Column(name = "IdActividad")
    private Integer idActividad;

    @Column(name = "Actividad")
    private String actividad;

    // Getters and Setters
    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad1 = (Actividad) o;
        return idActividad.equals(actividad1.idActividad);
    }

    @Override
    public int hashCode() {
        return idActividad.hashCode();
    }
}
