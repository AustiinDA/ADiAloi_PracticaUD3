package Hibernate;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Venta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_venta")
    private int idVenta;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic
    @Column(name = "id_producto")
    private int idProducto;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
