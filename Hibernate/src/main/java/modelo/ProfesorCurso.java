package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ProfesoresCursos")
public class ProfesorCurso implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "Profesor", referencedColumnName = "IDProfesor")
    private Profesor profesor;

    @Id
    @ManyToOne
    @JoinColumn(name = "Curso", referencedColumnName = "IdCurso")
    private Curso curso;

    @Column(name = "Tutor")
    private String tutor;

    // Constructor vacío
    public ProfesorCurso() {
    }

    // Constructor con parámetros
    public ProfesorCurso(Profesor profesor, Curso curso, String tutor) {
        this.profesor = profesor;
        this.curso = curso;
        this.tutor = tutor;
    }

    // Getters y Setters
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

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    // Implementación de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorCurso that = (ProfesorCurso) o;
        return Objects.equals(profesor, that.profesor) &&
               Objects.equals(curso, that.curso) &&
               Objects.equals(tutor, that.tutor);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(profesor, curso, tutor);
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "ProfesorCurso{" +
                "profesor=" + profesor +
                ", curso=" + curso +
                ", tutor='" + tutor + '\'' +
                '}';
    }
}
