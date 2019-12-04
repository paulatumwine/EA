package application01.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import application01.util.EntityManagerHelper;
import application01.domain.Address;

public class AddressDao {
	private EntityManagerFactory entityManagerFactory;

	public AddressDao(EntityManagerFactory entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}
	public Address load(Long id) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		return em.find(Address.class, id);
	}
	
	public void save(Address a) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		em.persist(a);
	}
	
	public void update(Address a) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		em.merge(a);
	}
}
