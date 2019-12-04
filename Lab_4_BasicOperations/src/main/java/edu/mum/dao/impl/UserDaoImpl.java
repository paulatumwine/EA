package edu.mum.dao.impl;

 

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

import java.util.List;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Autowired
	public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
		super.entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public User findByEmail(String email) {

		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		List<User> userList = query.setParameter("email", email).getResultList();
		return userList.get(0) ;


	}


 }