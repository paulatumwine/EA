package application01.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

    private static final ThreadLocal<EntityManager> threadLocal;

    static {

        threadLocal = new ThreadLocal<EntityManager>();
    }

    public static EntityManager getCurrent(EntityManagerFactory emf) {
        EntityManager em = threadLocal.get();
        if (em == null) {
            em = emf.createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }


}