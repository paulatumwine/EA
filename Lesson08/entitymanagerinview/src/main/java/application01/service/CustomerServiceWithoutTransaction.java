package application01.service;

import application01.domain.Address;
import application01.domain.Customer;
import application01.repository.AddressDao;
import application01.repository.CustomerDao;
import application01.util.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;

public class CustomerServiceWithoutTransaction {
    private CustomerDao customerDao;
    private AddressDao addressDao;
    private EntityManagerFactory entityManagerFactory;

    public CustomerServiceWithoutTransaction(ServletContext servletContext) {
        this.entityManagerFactory = (EntityManagerFactory) servletContext.getAttribute("entityManagerFactory");
        this.customerDao = new CustomerDao(entityManagerFactory);
        this.addressDao = new AddressDao(entityManagerFactory);
    }

    public void addCustomer(Customer c, Address a) {
        c.setAddress(a);
        customerDao.save(c);
    }

    public Customer getCustomer(Long id) {
        return customerDao.load(id);
    }
}
