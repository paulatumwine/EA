package edu.mum.cs544;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        long start = System.nanoTime();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*TypedQuery<Owner> query = em.createQuery("from Owner o join fetch o.pets p", Owner.class);
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }*/

        /*TypedQuery<Owner> query1 = em.createNamedQuery("Owner.Pets", Owner.class);
        List<Owner> ownerlist = query1.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }*/

        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addAttributeNodes("name");
        graph.addSubgraph("pets").addAttributeNodes("name");

        TypedQuery<Owner> query2 = em.createQuery("from Owner", Owner.class);
        query2.setHint("javax.persistence.fetchgraph", graph);

        List<Owner> ownerlist = query2.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}
