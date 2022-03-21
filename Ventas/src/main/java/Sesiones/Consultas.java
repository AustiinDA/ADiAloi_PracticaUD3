package Sesiones;

import Hibernate.Cliente;
import Hibernate.Producto;
import Hibernate.Venta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

public class Consultas {
    public static void main(String[] args) {
        insertarCliente(5, 5, "Nails Crane", "Calle Salamandra 42", "Seattle", "982321237", "81223452B");
        insertarProducto(6, 6, "Amplificador/Dac Fiio", 400, 100, 199);
        insertarVenta(5, 5, 120);
        leerVenta();
        //Las consultas de abajo dan un error que no puedo identificar
        productosMenoresA100();
        listaProdStockIgualAMin();
        listaClientesZaragoza();
        listaClientesRNombre();
        listaVentasAnterioresA30Dias();
        listaProductoDeterminada();
        actualizadoDeIVA();
        eliminarVentaPorCliente20();
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

    //Obtener un listado de los productos que tienen un precio inferior a 100.
    public static void productosMenoresA100() {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

        Session sesion = sessionFactory.openSession();

        Query consulta = sesion.createQuery("SELECT prod.descripcion, prod.precio FROM Producto prod WHERE precio<100");
        List<Producto> listaProd = consulta.list();

        System.out.println("Productos con precios menores a 100 => ");
        for (Producto prod : listaProd) {
            System.out.println("Descripcion: " + prod.getDescripcion() + ", PVP: " + prod.getPrecio());
        }
        sessionFactory.close();
    }

    //Obtener un listado de los productos cuyo stock actual sea igual a su stock mínimo
    public static void listaProdStockIgualAMin() {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Session sesion = sessionFactory.openSession();

        Query query = sesion.createQuery("SELECT prod.descripcion, prod.stockactual FROM Producto prod WHERE stockactual=stockminimo");
        List<Producto> listaProd = query.list();

        System.out.print("Productos con stock igual al stock mínimo =>");
        for (Producto prod : listaProd) {
            System.out.println("Descripcion: " + prod.getDescripcion() + ", StockActual: " + prod.getStockactual());
        }
        sesion.close();
    }

    //Obtener un listado de los clientes que viven en Zaragoza.
    public static void listaClientesZaragoza() {
        SessionFactory sesionFac = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionFac.openSession();

        Query query = sesion.createQuery("SELECT nombre, poblacion FROM Cliente WHERE poblacion='Zaragoza'");
        List<Cliente> listaClientes = query.list();

        Iterator<Cliente> iterator = listaClientes.iterator();
        Cliente client = new Cliente();
        System.out.print("Listado de clientes de Zaragoza =>");
        while (iterator.hasNext()) {
            client = iterator.next();
            System.out.println("Nombre: " + client.getNombre() + ", Poblacion: " + client.getPoblacion());
        }
        sesion.close();
    }

    //Obtener un listado de los clientes cuyo nombre empieza por la letra R.
    public static void listaClientesRNombre() {
        SessionFactory sesionFac = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionFac.openSession();

        Query query = sesion.createQuery("SELECT nombre, poblacion FROM Cliente c WHERE nombre LIKE 'r' or nombre LIKE 'R'");
        List<Cliente> listaClientes = query.list();

        Iterator<Cliente> iterator = listaClientes.iterator();
        Cliente client;
        System.out.print("Listado de clientes cuyo nombre empieza por R =>");
        while (iterator.hasNext()) {
            client = iterator.next();
            System.out.println("Nombre: " + client.getNombre());
        }
        sesion.close();
    }

    //Obtener un listado de las ventas realizadas en los últimos 30 días.
    public static void listaVentasAnterioresA30Dias() {
        SessionFactory sesionFac = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionFac.openSession();


        String str1 = "2021-12-05";
        String str2 = "2022-01-05";
        Date date1 = Date.valueOf(str1);
        Date date2 = Date.valueOf(str2);

        Query query = sesion.createQuery("SELECT idVenta, fecha FROM Venta v WHERE fecha BETWEEN :date1 AND :date2");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);

        List<Venta> listaVentas = query.list();

        Iterator<Venta> iterator = listaVentas.iterator();
        Venta venta;
        System.out.print("Listado de ventas hechas hace 30 dias =>");
        while (iterator.hasNext()) {
            venta = iterator.next();
            System.out.println("Nombre: " + venta.getIdVenta() + ", Poblacion: " + venta.getFecha());
        }
        sesion.close();
    }

    //Obtener un listado, ordenado por id de cliente, de las ventas realizadas de un producto determinado.
    public static void listaProductoDeterminada() {
        SessionFactory sesionFac = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionFac.openSession();

        Query query = sesion.createQuery("SELECT idVenta, idCliente  FROM Venta v WHERE idProducto = '2' ORDER BY idCliente.id");

        List<Venta> listaVentas = query.list();

        Iterator<Venta> iterator = listaVentas.iterator();
        Venta venta;
        System.out.print("Listado ordenado por id de cliente de las ventas realizadas de un producto determinado =>");
        while (iterator.hasNext()) {
            venta = iterator.next();
            System.out.println("Nombre: " + venta.getIdVenta() + ", Id Clinete: " + venta.getIdCliente());
        }
        sesion.close();
    }

    //Modificar el precio de todos los productos de forma que incluyan un IVA del 21%.
    public static void actualizadoDeIVA() {
        SessionFactory sesionFac = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionFac.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de cliente

            String consulta = "UPDATE Producto p SET p.precio = p.precio * 1.21";

            Query query = sesion.createNativeQuery(consulta);

            int updatedQuery = query.executeUpdate();
            System.out.println("Consulta y modificación de entidades realizadas => ");
            System.out.print(updatedQuery);

            tx.commit();

        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }

    }

    //Eliminar las ventas realizadas por el cliente 20.
    public static void eliminarVentaPorCliente20() {
        SessionFactory sesionFac = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionFac.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de cliente

            String consulta = "DELETE FROM Venta v WHERE v.idCliente='2'";

            Query query = sesion.createNativeQuery(consulta);


            int updatedQuery = query.executeUpdate();
            System.out.println("Consulta y modificación de entidades realizadas => ");
            System.out.print(updatedQuery);

            tx.commit();

        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }

    }


}