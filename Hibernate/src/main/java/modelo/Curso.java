package modelo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Cursos")
public class Curso implements Serializable {

    @Id
    @Column(name = "IdCurso")
    private int idCurso;

    @Column(name = "Curso")
    private String curso;

    // Constructor vacío
    public Curso() {
    }

    // Constructor con parámetros
    public Curso(int idCurso, String curso) {
        this.idCurso = idCurso;
        this.curso = curso;
    }

    // Getters y Setters
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Implementación de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso1 = (Curso) o;
        return idCurso == curso1.idCurso && Objects.equals(curso, curso1.curso);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idCurso, curso);
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", curso='" + curso + '\'' +
                '}';
    }
}
