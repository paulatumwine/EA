package edu.mum.cs.orphanremoval;

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

        Customer c = new Customer("John", "Doe");
        CreditCard cc1 = new CreditCard("John Doe", "1234 1234 1234 1234");
        CreditCard cc2 = new CreditCard("John Doe", "4321 4321 4321 4321");
        c.addCard(cc1);
        c.addCard(cc2);

        em.persist(c);
//        em.persist(cc1);
//        em.persist(cc2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = em.getReference(Customer.class, 1);
        CreditCard cc = em.getReference(CreditCard.class, 1);
        customer.removeCard(cc);
        em.flush();
        System.out.println(em.contains(cc));

        em.getTransaction().commit();

        emf.close();
    }
}
