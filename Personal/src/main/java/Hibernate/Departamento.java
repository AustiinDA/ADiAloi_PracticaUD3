package Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_dep")
    private Byte idDep;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "localidad", length = 15)
    private String localidad;

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getIdDep() {
        return idDep;
    }

    public void setIdDep(Byte idDep) {
        this.idDep = idDep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}