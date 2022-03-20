package Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_prod")
    private Integer idProd;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "stockactual")
    private Integer stockactual;

    @Column(name = "stockminimo")
    private Integer stockminimo;

    @Column(name = "precio")
    private Float precio;

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(Integer stockminimo) {
        this.stockminimo = stockminimo;
    }

    public Integer getStockactual() {
        return stockactual;
    }

    public void setStockactual(Integer stockactual) {
        this.stockactual = stockactual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}