package edu.mum.cs.onetoone;


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
        Address address = new Address("1000 N 4th St.", "Fairfield", "IA", "52556");
        c.setAddress(address);
        em.persist(c);

        em.getTransaction().commit();
        emf.close();
    }

}
