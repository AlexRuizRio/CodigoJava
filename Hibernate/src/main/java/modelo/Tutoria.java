package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Tutorias")
public class Tutoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTutoria")
    private Integer idTutoria;

    @ManyToOne
    @JoinColumn(name = "Profesor", referencedColumnName = "IDProfesor")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "Curso", referencedColumnName = "IdCurso")
    private Curso curso;

    @Column(name = "DiaSemana")
    private String diaSemana;

    @Column(name = "HoraTutoria")
    private String horaTutoria;

    // Constructor vacío
    public Tutoria() {
    }

    // Constructor con parámetros
    public Tutoria(Integer idTutoria, Profesor profesor, Curso curso, String diaSemana, String horaTutoria) {
        this.idTutoria = idTutoria;
        this.profesor = profesor;
        this.curso = curso;
        this.diaSemana = diaSemana;
        this.horaTutoria = horaTutoria;
    }

    // Getters y Setters
    public Integer getIdTutoria() {
        return idTutoria;
    }

    public void setIdTutoria(Integer idTutoria) {
        this.idTutoria = idTutoria;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraTutoria() {
        return horaTutoria;
    }

    public void setHoraTutoria(String horaTutoria) {
        this.horaTutoria = horaTutoria;
    }

    // Implementación de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutoria tutoria = (Tutoria) o;
        return Objects.equals(idTutoria, tutoria.idTutoria) &&
               Objects.equals(profesor, tutoria.profesor) &&
               Objects.equals(curso, tutoria.curso) &&
               Objects.equals(diaSemana, tutoria.diaSemana) &&
               Objects.equals(horaTutoria, tutoria.horaTutoria);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idTutoria, profesor, curso, diaSemana, horaTutoria);
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Tutoria{" +
                "idTutoria=" + idTutoria +
                ", profesor=" + profesor +
                ", curso=" + curso +
                ", diaSemana='" + diaSemana + '\'' +
                ", horaTutoria='" + horaTutoria + '\'' +
                '}';
    }
}
