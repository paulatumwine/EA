package edu.mum.cs;

import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class StudentDao extends Thread {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	public void insert(Student std) throws Exception {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(std);
		em.getTransaction().commit();
		em.close();
	}

	public void updateStd() throws InterruptedException {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Student user = (Student) em.find(Student.class, student.getId(), LockModeType.OPTIMISTIC);
			user.setName(student.getName());
			user.setEmail(student.getEmail());
			user.setDegree(student.getDegree());
			user.setPhone(student.getPhone());
			Thread.sleep(1000);
			em.merge(user);
			em.getTransaction().commit();
			em.close();



		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("updation failed");
		}
	}
	public void run()
	{
		try {
			updateStd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}