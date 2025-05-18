package modelo;
import modelo.Alumno; 
import modelo.Participante;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Participantes")
@IdClass(ParticipanteId.class)  // Usamos una clase de ID compuesta
public class Participante {

    @Id
    @ManyToOne
    @JoinColumn(name = "ParticipanteActividad", referencedColumnName = "IdActividad", insertable = false, updatable = false)
    private Actividad actividad;

    @Id
    @ManyToOne
    @JoinColumn(name = "ParticipanteEquipo", referencedColumnName = "IdEquipo", insertable = false, updatable = false)
    private Equipo equipo;

    @Id
    @ManyToOne
    @JoinColumn(name = "Alumno", referencedColumnName = "Expediente", insertable = false, updatable = false)
    private Alumno alumno;

    // Constructor vacío
    public Participante() {}

    // Constructor con parámetros
    public Participante(Actividad actividad, Equipo equipo, Alumno alumno) {
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
        Participante that = (Participante) o;
        return Objects.equals(actividad, that.actividad) &&
               Objects.equals(equipo, that.equipo) &&
               Objects.equals(alumno, that.alumno);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(actividad, equipo, alumno);
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Participante{" +
                "actividad=" + actividad +
                ", equipo=" + equipo +
                ", alumno=" + alumno +
                '}';
    }
}
