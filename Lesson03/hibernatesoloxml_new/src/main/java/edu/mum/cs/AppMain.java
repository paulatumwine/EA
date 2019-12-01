package edu.mum.cs;

import edu.mum.cs.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppMain {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

    private void persist(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        em.getTransaction().commit();
        System.out.println("3");
        emf.close();
    }

    private void findVsReference(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        long id = p.getId();
        System.out.println("3");
        em.find(Person.class, id);
        System.out.println("4");
        em.getReference(Person.class, id);
        System.out.println("5");
        em.getTransaction().commit();
        System.out.println("6");

        emf.close();
    }

    public void update(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        p.setName("Updated Name");
        System.out.println("3");
        em.getTransaction().commit();
        System.out.println("4");
    }

    public void remove(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        em.remove(p);
        System.out.println("3");
        em.getTransaction().commit();
        System.out.println("4");
    }

    public void pushBeforeQuery(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        p.setName("Updated Name");
        System.out.println("3");
        em.remove(p);
        System.out.println("4");
        TypedQuery<Person> q = em.createQuery("from Person", Person.class);
        System.out.println("5");
        List<Person> people = q.getResultList();
        System.out.println("6");
        em.getTransaction().commit();
        System.out.println("7");
    }

    public void flush(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        em.remove(p);
        System.out.println("3");
        em.flush();
        System.out.println("4");
        TypedQuery<Person> q = em.createQuery("from Person", Person.class);
        System.out.println("5");
        List<Person> people = q.getResultList();
        System.out.println("6");
        em.getTransaction().commit();
        System.out.println("7");
    }

    public void refresh() throws InterruptedException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Aaron James");
        System.out.println("1");
        em.persist(p);
        System.out.println("2");
        Thread.sleep(5000); // sleep for 5 secs (other program changes db)
        System.out.println("3");
// tries to 'get again’ from db, but receives cached version
        p = em.find(Person.class, p.getId());
        System.out.println(p.getName());
        System.out.println("4");
        em.refresh(p); // forced to go to db again
        System.out.println(p.getName());
        em.getTransaction().commit();
    }

    public void contains(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person("Aaron James");
        System.out.println(em.contains(p));
        em.persist(p);
        System.out.println(em.contains(p));
        em.getTransaction().commit();
    }

    public void detach(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John");
        Person p2 = new Person("Jane");
        em.persist(p1);
        em.persist(p2);
        em.detach(p1);
        System.out.println(em.contains(p1));
        System.out.println(em.contains(p2));
        em.getTransaction().commit();

    }

    public void clear(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("John");
        Person p2 = new Person("Jane");
        em.persist(p1);
        em.persist(p2);
        em.clear();
        System.out.println(em.contains(p1));
        System.out.println(em.contains(p2));
        em.getTransaction().commit();

    }

    public static void main(String[] args) throws Exception {
        /* Reads META-INF/persistence.xml and looks for specified unit name */
        AppMain main = new AppMain();
        main.persist();
//        main.findVsReference();
//        main.update();
//        main.remove();
//        main.pushBeforeQuery();
//        main.flush();
//        main.refresh();
//        main.contains();
//        main.detach();
//        main.clear();
    }

}
