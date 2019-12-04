package application01.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;

import application01.util.EntityManagerHelper;
import application01.domain.Address;
import application01.domain.Customer;
import application01.repository.AddressDao;
import application01.repository.CustomerDao;

public class CustomerServiceWithTransaction {
	private CustomerDao customerDao;
	private AddressDao addressDao;
	private EntityManagerFactory entityManagerFactory;

	public CustomerServiceWithTransaction(ServletContext servletContext){
		this.entityManagerFactory = (EntityManagerFactory) servletContext.getAttribute("entityManagerFactory");
		this.customerDao = new CustomerDao(entityManagerFactory);
		this.addressDao = new AddressDao(entityManagerFactory);
	}

	public void addCustomer(Customer c, Address a) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		em.getTransaction().begin();
		c.setAddress(a);
		customerDao.save(c);
		addressDao.save(a);
		em.getTransaction().commit();
		em.close();
	}

	public Customer getCustomer(Long id) {
		EntityManager em = EntityManagerHelper.getCurrent(entityManagerFactory);
		em.getTransaction().begin();
		Customer c = customerDao.load(id);
		
		// following references to ensure it's loaded
//		c.getAddress().getCity();

		em.getTransaction().commit();
		em.close();
		return c;
	}
}
