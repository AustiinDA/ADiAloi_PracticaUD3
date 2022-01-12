package Hibernate;

import javax.persistence.*;

@Entity
public class Departamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private byte id;
    @Basic
    @Column(name = "id_dep")
    private Byte idDep;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "localidad")
    private String localidad;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Byte getIdDep() {
        return idDep;
    }

    public void setIdDep(Byte idDep) {
        this.idDep = idDep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
