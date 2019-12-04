package application01.filter;

import application01.util.EMF;
import application01.util.EntityManagerHelper;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "OpenEntityManagerInView", urlPatterns = "/*")
public class OpenEntityManagerInView implements Filter {
    private EntityManagerFactory emf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        emf = (EntityManagerFactory) filterConfig.getServletContext().getAttribute("entityManagerFactory");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        EntityManager em = EntityManagerHelper.getCurrent(emf);
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            em.getTransaction().begin();
            chain.doFilter(req, resp);
            em.getTransaction().commit();
        } catch (RuntimeException ex) {
            try {
                ex.printStackTrace();
                tx.rollback();
            } catch (RuntimeException rbEx) {
                System.out.println("Could not rollback transaction " + rbEx);
                rbEx.printStackTrace();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
}