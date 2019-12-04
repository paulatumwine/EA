package application01.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cs544");
        ctx.setAttribute("entityManagerFactory", entityManagerFactory);
        System.out.println("EntityManagerFactory initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) ctx.getAttribute("entityManagerFactory");
        entityManagerFactory.close();
        System.out.println("EntityManagerFactory closed for Application.");
    }
}