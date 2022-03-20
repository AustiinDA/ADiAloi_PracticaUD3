package Hibernate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Departamento departamento;

    @Column(name = "id_emp")
    private Short idEmp;

    @Column(name = "apellido", length = 10)
    private String apellido;

    @Column(name = "oficio", length = 10)
    private String oficio;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "salario")
    private Float salario;

    @Column(name = "comision")
    private Float comision;

    @Column(name = "id_dep")
    private Byte idDep;

    public Byte getIdDep() {
        return idDep;
    }

    public void setIdDep(Byte idDep) {
        this.idDep = idDep;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Short getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Short idEmp) {
        this.idEmp = idEmp;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}