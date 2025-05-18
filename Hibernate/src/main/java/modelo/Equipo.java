package modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Equipos")
public class Equipo {

    @Id
    @Column(name = "IdEquipo")
    private Integer idEquipo;

    @Column(name = "Nombre")
    private String nombre;

    // Relación OneToMany con Participante
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participante> participantes;

    // Getters and Setters
    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return idEquipo.equals(equipo.idEquipo);
    }

    @Override
    public int hashCode() {
        return idEquipo.hashCode();
    }
}
