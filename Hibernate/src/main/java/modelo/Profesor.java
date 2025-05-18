package modelo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Profesores")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAllOrderedById",
                query = "SELECT p FROM Profesor p ORDER BY p.idProfesor"),
    @NamedQuery(name = "Profesor.findByApellidoPattern",
                query = "SELECT p FROM Profesor p WHERE p.apellido LIKE :apellidoPattern")
})
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProfesor")
    private Integer idProfesor;
    
    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tutoria> tutorias;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "Provincia")
    private String provincia;

    @Column(name = "CodPostal")
    private String codPostal;

    // Relación con Departamento (muchos Profesores pueden tener un Departamento)
    @ManyToOne
    @JoinColumn(name = "Departamento", referencedColumnName = "IdDepartamento")
    private Departamento departamento;

    // Constructor vacío
    public Profesor() {
    }

    // Constructor con parámetros
    public Profesor(Integer idProfesor, String nombre, String apellido, String direccion,
                    String ciudad, String provincia, String codPostal, Departamento departamento) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codPostal = codPostal;
        this.departamento = departamento;
    }

    // Getters y Setters
    public List<Tutoria> getTutorias() {
        return tutorias;
    }

    public void setTutorias(List<Tutoria> tutorias) {
        this.tutorias = tutorias;
    }
    
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    // Implementación de equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(idProfesor, profesor.idProfesor) &&
                Objects.equals(nombre, profesor.nombre) &&
                Objects.equals(apellido, profesor.apellido) &&
                Objects.equals(direccion, profesor.direccion) &&
                Objects.equals(ciudad, profesor.ciudad) &&
                Objects.equals(provincia, profesor.provincia) &&
                Objects.equals(codPostal, profesor.codPostal) &&
                Objects.equals(departamento, profesor.departamento);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idProfesor, nombre, apellido, direccion, ciudad, provincia, codPostal, departamento);
    }


    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
