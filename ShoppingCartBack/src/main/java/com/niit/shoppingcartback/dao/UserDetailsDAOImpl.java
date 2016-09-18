package com.niit.shoppingcartback.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.UserDetails;

@EnableTransactionManagement
@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	// get sessions first
	@Autowired 
	private SessionFactory sessionFactory;
	private UserDetailsDAOImpl list;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(UserDetails userdetails) {

		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().save(userdetails);
			log.debug("Starting of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(UserDetails userdetails) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().update(userdetails);
			log.debug("Starting of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(UserDetails userdetails) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().delete(userdetails);
			log.debug("ending of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public UserDetails isValidUser(String id, String password) {
		// select * from userdetails where id='101' and password='niit'
		String hql = "from userdetails where id = '" + id + "'and password=' " + password + " ' ";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();

		if (list == null) {

			return null;
		} else {
			list.get(0);

		}
		return null;
	}

	@Transactional
	public UserDetails get(String id) {
		// select * from userdetails where id='101'
		log.debug("Starting of the method save");
		log.info("trying to get product based on id:" + id);
		String hql = "from userdetails where id =" + "'"+ id +"'";
		log.info("the hql query is:" + hql);
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();

		if (list == null) {
			log.info("no products are available with this id:" + id);
			return null;
		} else {
			list.get(0);

		}
		return null;
	}

	@Transactional
	public List<UserDetails> list() {
		log.debug("Starting of the method save");
		String hql = "from userdetails";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Starting of the method save");
		return query.list();

	}

}
