package edu.mum.main;


import edu.mum.domain.User;
import edu.mum.service.UserService;
import edu.mum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Component
public class Main {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        EntityManagerFactory emf = context.getBean("entityManagerFactory", EntityManagerFactory.class);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@mail.com");
        em.persist(user);

        // em.flush();

        em.getTransaction().commit();

        /*TypedQuery<User> q = em.createQuery("from User WHERE email = 'john.doe@mail.com'", User.class);
        User user1 = q.getSingleResult();
        printUser(user1);*/

        Main main = context.getBean(Main.class);
        User user2 = main.getUserByEmail();
        printUser(user2);

    }

    static void printUser(User user) {
        System.out.println("************** User **************");
        System.out.println("User Name: " + user.getFirstName() + " " + user.getLastName());
    }

    private User getUserByEmail() {
        return userService.findByEmail("john.doe@mail.com");
    }
}