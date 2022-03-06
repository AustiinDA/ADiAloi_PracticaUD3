package Hibernate;

import javax.persistence.*;

@Entity
public class Departamento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_dep")
    private byte idDep;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "localidad")
    private String localidad;

    public byte getIdDep() {
        return idDep;
    }

    public void setIdDep(byte idDep) {
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
