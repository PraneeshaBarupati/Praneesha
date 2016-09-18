package com.niit.shoppingcartback.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.User;

@Repository("userDAO")   
public class UserDAOImpl implements UserDAO {

	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	// get sessions first
	@Autowired
	private SessionFactory sessionFactory;
	private UserDAOImpl list;

	public UserDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(User user) {            

		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().save(user);
			log.debug("Starting of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(User user) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().update(user);
			log.debug("Starting of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean isValidUser(String id, String password) {

		String hql = "from User where id =" + "'" +id + "'" + "and" + " password=" + "'" + password + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		System.out.println(list.size());
		System.out.println(list);

		try {

			User user = list.get(0);

			if (user.getId().equals(id) && user.getPassword().equals(password)) {

				return true;
			} else {
				return false;
			}

		}

		catch (Exception ex) {
			System.out.println("No user found ");
			return false;
		} 

	}

	public void saveOrUpdate(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		} catch (HibernateException e) {
		
			e.printStackTrace();
		}
		
	}

	

}
