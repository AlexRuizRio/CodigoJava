package modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Calendario")
@NamedQueries({
	@NamedQuery(
		    name = "Calendario.listarEncuentros",
		    query = "SELECT a.actividad AS actividad, eA.nombre AS equipoA, eB.nombre AS equipoB, " +
		            "c.id.fecha, c.id.hora, c.id.lugar " +
		            "FROM Calendario c " +
		            "JOIN Actividad a ON c.id.actividad = a.id " +
		            "LEFT JOIN Equipo eA ON c.equipoA.id = eA.id " +
		            "LEFT JOIN Equipo eB ON c.equipoB.id = eB.id " +
		            "ORDER BY a.actividad, c.id.fecha, c.id.hora"
		),
		@NamedQuery(
		    name = "Calendario.listarResultadosPorDeporte",
		    query = "SELECT c.id.fecha, c.id.hora, eA.nombre, eA.id, eB.nombre, eB.id, " +
		            "c.resultadoEquipoA, c.resultadoEquipoB " +
		            "FROM Calendario c " +
		            "JOIN Actividad a ON c.id.actividad = a.id " +
		            "LEFT JOIN Equipo eA ON c.equipoA.id = eA.id " +
		            "LEFT JOIN Equipo eB ON c.equipoB.id = eB.id " +
		            "WHERE a.actividad = :deporte " +
		            "ORDER BY c.id.fecha, c.id.hora"
		)
})
public class Calendario implements Serializable {

    @EmbeddedId
    private CalendarioId id;

    @ManyToOne
    @JoinColumn(name = "Actividad", referencedColumnName = "idActividad") // Asumiendo que idActividad es la clave primaria de la clase Actividad
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "EquipoA", referencedColumnName = "IdEquipo")
    private Equipo equipoA;

    @ManyToOne
    @JoinColumn(name = "EquipoB", referencedColumnName = "IdEquipo")
    private Equipo equipoB;

    @Column(name = "ResultadoEquipoA")
    private Integer resultadoEquipoA;

    @Column(name = "ResultadoEquipoB")
    private String resultadoEquipoB;

    // Getters y Setters
    public CalendarioId getId() {
        return id;
    }

    public void setId(CalendarioId id) {
        this.id = id;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public Integer getResultadoEquipoA() {
        return resultadoEquipoA;
    }

    public void setResultadoEquipoA(Integer resultadoEquipoA) {
        this.resultadoEquipoA = resultadoEquipoA;
    }

    public String getResultadoEquipoB() {
        return resultadoEquipoB;
    }

    public void setResultadoEquipoB(String resultadoEquipoB) {
        this.resultadoEquipoB = resultadoEquipoB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendario that = (Calendario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
