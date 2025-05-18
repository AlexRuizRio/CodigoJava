package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDepartamento")
    private Integer idDepartamento;

    @Column(name = "Nombre")
    private String nombre;

    // Constructor vacío
    public Departamento() {
    }

    // Constructor con parámetros
    public Departamento(Integer idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Implementación de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(idDepartamento, that.idDepartamento) &&
               Objects.equals(nombre, that.nombre);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idDepartamento, nombre);
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
