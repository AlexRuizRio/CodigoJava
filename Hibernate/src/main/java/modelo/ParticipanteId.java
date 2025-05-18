package modelo;

import java.io.Serializable;
import java.util.Objects;

public class ParticipanteId implements Serializable {

    private Actividad actividad;
    private Equipo equipo;
    private Alumno alumno;

    // Constructor vacío (obligatorio para Serializable)
    public ParticipanteId() {
    }

    // Constructor con parámetros
    public ParticipanteId(Actividad actividad, Equipo equipo, Alumno alumno) {
        this.actividad = actividad;
        this.equipo = equipo;
        this.alumno = alumno;
    }

    // Getters y Setters
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    // Implementación de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipanteId that = (ParticipanteId) o;
        return Objects.equals(actividad, that.actividad) &&
               Objects.equals(equipo, that.equipo) &&
               Objects.equals(alumno, that.alumno);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(actividad, equipo, alumno);
    }
}
