package application01.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import application01.util.EntityManagerHelper;
import application01.domain.Customer;

public class CustomerDao {

	private EntityManagerFactory entityManagerFactory;

	public CustomerDao(EntityManagerFactory entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	public Customer load(Long id) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		return em.find(Customer.class, id);
	}
	
	public void save(Customer c) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		em.persist(c);
	}
	
	public void update(Customer c) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		em.merge(c);
	}
}
