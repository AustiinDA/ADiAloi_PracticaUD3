package Sesiones;

import Hibernate.Cliente;
import Hibernate.Producto;
import Hibernate.Venta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Consultas {
    public static void main(String[] args) {
        insertarCliente(5, 5, "Nails Crane", "Calle Salamandra 42", "Seattle", "982321237", "81223452B");
        insertarProducto(6, 6, "Amplificador/Dac Fiio", 400, 100, 199);
        insertarVenta(5, 5, 120);
        leerVenta();
    }


    // Insertar un cliente
    public static void insertarCliente(int id, int id_cliente, String nombre, String direccion, String poblacion, String telef, String nif) {
        // inicializar el entorno Hibernate
        Configuration cfg = new Configuration().configure();

        // crear el ejemplar de Session Factory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // obtener un objeto sesión
        Session sesion = sessionFactory.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de cliente
            Cliente client = new Cliente();

            // código de persistencia

            System.out.print("Nuevo cliente: ");
            client.setId(id);
            client.setIdCliente(id_cliente);
            client.setNombre(nombre);
            client.setDireccion(direccion);
            client.setPoblacion(poblacion);
            client.setTelef(telef);
            client.setNif(nif);

            System.out.println("Nombre: " + client.getNombre()
                    + ", Direccion: " + client.getDireccion()
                    + ", Poblacion: " + client.getPoblacion()
                    + ", Telefono: " + client.getTelef()
                    + ", Nif: " + client.getNif());
            System.out.print("Nuevo cliente introducido exitosamente!");

            sesion.save(client);
            tx.commit();

            System.out.println("Sesión realizada, datos de cliente actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }

    //Insertar un producto
    public static void insertarProducto(int id, int id_producto, String descripcion, int stockactual, int stockminimo, float precio) {
        // inicializar el entorno Hibernate
        Configuration cfg = new Configuration().configure();

        // crear el ejemplar de Session Factory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // obtener un objeto sesión
        Session sesion = sessionFactory.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de cliente
            Producto prod = new Producto();

            // código de persistencia

            System.out.print("Nuevo producto: ");

            prod.setId(id);
            prod.setIdProd(id_producto);
            prod.setDescripcion(descripcion);
            prod.setStockactual(stockactual);
            prod.setStockminimo(stockminimo);
            prod.setPrecio(precio);
            sesion.save(prod);

            System.out.println("Descripcion Producto: " + prod.getDescripcion()
                    + ", Stock Actual: " + prod.getStockactual()
                    + ", Stock Minimo: " + prod.getStockminimo()
                    + ", Precio: " + prod.getPrecio());

            System.out.println("Nuevo producto introducido exitosamente!");

            sesion.save(prod);
            tx.commit();

            System.out.println("Sesión realizada, datos de producto actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }

    // Insertar una venta
    public static void insertarVenta(int id, int id_venta, int cantidad) {
        // inicializar el entorno Hibernate
        Configuration cfg = new Configuration().configure();

        // crear el ejemplar de Session Factory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // obtener un objeto sesión
        Session sesion = sessionFactory.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de cliente
            Venta vent = new Venta();
            Producto prod = new Producto();
            Cliente client = new Cliente();

            // código de persistencia
            String str = "2019-08-21";
            java.sql.Date date = java.sql.Date.valueOf(str);

            System.out.print("Nuevo producto: ");

            vent.setId(id);
            vent.setIdVenta(id_venta);
            vent.setFecha(date);
            vent.setCantidad(cantidad);

            vent.setIdProducto(prod);
            vent.setIdCliente(client);

            System.out.println("Nuevo producto introducido exitosamente!");
            sesion.save(prod);
            sesion.save(client);
            sesion.save(vent);
            tx.commit();

            System.out.println("Sesión realizada, datos de producto actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }

    // Lectura de venta
    public static void leerVenta() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sesion = sessionFactory.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de dep

            Venta vent = sesion.load(Venta.class, 2);

            System.out.print("Datos de la venta 2: ");
            System.out.println("ID: " + vent.getId()
                    + ", ID Venta: " + vent.getIdVenta()
                    + ", Fecha: " + vent.getFecha()
                    + ", Cantidad: " + vent.getCantidad());

            // validar la transacción
            tx.commit();

            System.out.println("Sesión realizada, datos de departamento actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }
}
