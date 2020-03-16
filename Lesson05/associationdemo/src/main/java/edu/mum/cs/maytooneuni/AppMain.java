package edu.mum.cs.maytooneuni;

import edu.mum.cs.maytooneuni.domain.Car;
import edu.mum.cs.maytooneuni.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */

        emf = Persistence.createEntityManagerFactory("edu.mum.cs");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer c = new Customer("Jack", "Welsh");
        em.persist(c);

        Car car = new Car(2019, "Toyota", "Lexus", c);

        em.persist(car);

        em.getTransaction().commit();
        emf.close();
    }

}
