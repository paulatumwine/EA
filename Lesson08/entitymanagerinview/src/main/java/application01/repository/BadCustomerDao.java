package application01.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application01.domain.Customer;
import application01.util.EMF;

public class BadCustomerDao {
	private EntityManagerFactory emf;

	public BadCustomerDao(){
		emf = EMF.get();
	}

	public Customer load(Long id) {
		EntityManager em = emf.createEntityManager();
		Customer c = em.find(Customer.class, id);
		em.close();
		return c;
	}
	public void save(Customer c) {
		EntityManager em = emf.createEntityManager();
		em.persist(c);
		em.close();
	}
	public void update(Customer c) {
		EntityManager em = emf.createEntityManager();
		em.merge(c);
		em.close();
	}
}
