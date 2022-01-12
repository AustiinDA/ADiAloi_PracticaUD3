package Hibernate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Empleado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private byte id;
    @Basic
    @Column(name = "id_emp")
    private Short idEmp;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "oficio")
    private String oficio;
    @Basic
    @Column(name = "fecha_alta")
    private Date fechaAlta;
    @Basic
    @Column(name = "salario")
    private Double salario;
    @Basic
    @Column(name = "comision")
    private Double comision;
    @Basic
    @Column(name = "id_dep")
    private Byte idDep;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Short getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Short idEmp) {
        this.idEmp = idEmp;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Byte getIdDep() {
        return idDep;
    }

    public void setIdDep(Byte idDep) {
        this.idDep = idDep;
    }
}
