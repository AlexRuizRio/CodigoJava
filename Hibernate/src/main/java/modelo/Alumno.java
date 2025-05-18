package modelo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Alumnos")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAllOrderedByExpediente",
                query = "SELECT a FROM Alumno a ORDER BY a.expediente"),
    @NamedQuery(name = "Alumno.findByApellidoPattern",
                query = "SELECT a FROM Alumno a WHERE a.apellidos LIKE :apellidoPattern")
})
public class Alumno implements Serializable{

    @Id
    @Column(name = "Expediente")
    private Integer expediente;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "Grupo")
    private Curso curso;

    @Column(name = "FechaNacimiento")
    private Date fechaNacimiento;

    // Getters and Setters
    public Integer getExpediente() {
        return expediente;
    }

    public void setExpediente(Integer expediente) {
        this.expediente = expediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return expediente.equals(alumno.expediente);
    }

    @Override
    public int hashCode() {
        return expediente.hashCode();
    }
}
