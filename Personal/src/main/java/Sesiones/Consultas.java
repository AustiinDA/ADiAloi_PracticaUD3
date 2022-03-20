package Sesiones;

import Hibernate.Departamento;
import Hibernate.Empleado;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class Consultas {
    public static void main(String[] args) {
        //modificarDep("prueba", "prueba");
        insertarEmp("Quichu", "Transporte", 1300, 3.3);
    }
    //Modificación de departamento
    public static void modificarDep(String nombreDep, String localidadDep) {
        // inicializar el entorno Hibernate
        Configuration cfg = new Configuration().configure();

        // crear el ejemplar de Session Factory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // obtener un objeto sesión
        Session sesion = sessionFactory.openSession();

        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de dep
            Departamento dep = sesion.load(Departamento.class, 1);

            // código de persistencia
            System.out.println("Departamento Id: " + dep.getIdDep()
            + "\n Localidad: " + dep.getLocalidad()
            + "\n Nombre: " + dep.getNombre()
            );

            dep.setNombre(nombreDep);
            dep.setLocalidad(localidadDep);

            sesion.update(dep);
            // validar la transacción
            tx.commit();

            System.out.println("Sesión realizada, datos de departamente actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }
    //Insercción de un empleado
    public static void insertarEmp(String apellido, String oficio, double salario, double comision){
        // inicializar el entorno Hibernate
        Configuration cfg = new Configuration().configure();

        // crear el ejemplar de Session Factory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // obtener un objeto sesión
        Session sesion = sessionFactory.openSession();

        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de dep
            Empleado emp = new Empleado();


            // código de persistencia
            String str="2015-03-31";
            Date date=Date.valueOf(str);


            emp.setId(6);
            emp.setIdEmp((short) 6);
            emp.setApellido(apellido);
            emp.setOficio(oficio);
            emp.setFechaAlta(date);
            emp.setSalario(salario);
            emp.setComision(comision);
            emp.setIdDep((byte) 60);

            sesion.save(emp);
            // validar la transacción
            tx.commit();

            sesion.load(Empleado.class, 6);

            System.out.println("Sesión realizada, datos de departamente actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }
}
