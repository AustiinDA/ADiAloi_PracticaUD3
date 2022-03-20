package Sesiones;

import Hibernate.Departamento;
import Hibernate.Empleado;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.CascadeType;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

public class Consultas {
    public static void main(String[] args) {
        modificarDep("hola", "adios");
        insertarEmp("Quichu", "Transporte", 1300, 3);
        leerEmpleadoYDep();
        //eliminarEmpleado();
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
    public static void insertarEmp(String apellido, String oficio, float salario, float comision) {
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
            String str = "2015-03-31";
            Date date = Date.valueOf(str);

            Departamento dep = new Departamento();
            emp.setId(6);
            emp.setIdEmp((short) 6);
            emp.setApellido(apellido);
            emp.setOficio(oficio);
            emp.setFechaAlta(date);
            emp.setSalario(salario);
            emp.setComision(comision);
            emp.setIdDep((byte) 60);
            emp.setDepartamento(dep);

            sesion.save(emp);

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

    // Lectura de empleado y departamento
    public static void leerEmpleadoYDep() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sesion = sessionFactory.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de dep

            Empleado emp = sesion.load(Empleado.class, 3);

            System.out.print("Datos del Empleado 3: ");
            System.out.println("IdEmpleado: " + emp.getIdEmp()
                    + ", Apellido: " + emp.getApellido()
                    + ", Oficio: " + emp.getOficio()
                    + ", Salario: " + emp.getSalario()
                    + ", Comisión: " + emp.getComision()
                    + ", ID Dep: " + emp.getIdDep());

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

    //Eliminación de un empleado

    public static void eliminarEmpleado() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sesion = sessionFactory.openSession();
        try {
            // comenzar la transacción
            Transaction tx = sesion.beginTransaction();
            // instancia de dep

            Empleado emp;
            emp = sesion.load(Empleado.class, 7);
            System.out.println("IdEmpleado: " + emp.getIdEmp()
                    + ", Apellido: " + emp.getApellido()
                    + ", Oficio: " + emp.getOficio()
                    + ", Salario: " + emp.getSalario()
                    + ", Comisión: " + emp.getComision()
                    + ", ID Dep: " + emp.getIdDep());
            sesion.delete(emp);

            // validar la transacción
            tx.commit();

            System.out.println("Sesión realizada, datos de empleado actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }


    }

    //Obtener un listado de los empleados que tienen un salario superior a 1000
    public static void listadoEmpleadosConSalarioM1000() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sesion = sessionFactory.openSession();
        try {
            // Consulta

            Query consulta = sesion.createQuery("SELECT emp.apellido, emp.salario FROM Empleado emp WHERE salario>=1000");

            final List<Empleado> listaEmpleados = consulta.list();
            for (Empleado emp: listaEmpleados) {
                System.out.println("Empleado :" + emp + "Apellido: " +emp.getApellido()
                        + ", Salario: " + emp.getSalario());
            }

            sesion.close();

            System.out.println("Sesión realizada, datos de empleado actualizados");
        } catch (HibernateException e) {
            System.err.println("Error al comenzar transacción: " + e);
        } finally {
            // finalizar la sesión
            sesion.close();
        }
    }


}