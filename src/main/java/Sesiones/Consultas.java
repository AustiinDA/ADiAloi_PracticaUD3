package Sesiones;

import Hibernate.Departamento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Consultas {
    public static void main(String[] args) {
        // inicializar el entorno Hibernate
        Configuration cfg = new Configuration().configure();

        //crear el ejemplar de Session Factory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // obtener un objeto sesión
        Session sesion = sessionFactory.openSession();

        Departamento dep = new Departamento(); //instancia de dep




        // comenzar la transacción
        Transaction tx = sesion.beginTransaction();
        // código de persistencia
        //
        // validar la transacción
        tx.commit();
        // finalizar la sesión
        sesion.close();
    }
}

