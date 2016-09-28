package com.niit.shoppingcartback.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.UserDetails;

@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO, Serializable {
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDAOImpl.class);

	private static final String UserDetails = null;

	// get sessions first
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}

	}

	@Transactional
	public void saveOrUpdate(UserDetails userdetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
	}

	@Transactional
	public void delete(String id) {
		UserDetails userdetails = new UserDetails();
		userdetails.setId(Integer.parseInt(id));
		sessionFactory.getCurrentSession().delete(userdetails);
	}

	@Transactional
	public boolean isValidUser(String name, String password) {
		// select * from userdetails where id='101' and password='niit'
		String hql = "from UserDetails where name =" + "'" + name + "'" + "and password=" + "'" + password + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = query.list();

		System.out.println(list.toString());
		if (list != null && !list.isEmpty())
			return true;

		return false;

	}

	@Transactional
	public UserDetails get(String name) {
		// select * from userdetails where id='101'

		String hql = "from UserDetails where name =" + "'" + name + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
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

	/*
	 * @Transactional public List<UserDetails> list() {
	 * 
	 * @SuppressWarnings("unchecked") List<UserDetails> list =
	 * (List<UserDetails>) sessionFactory.getCurrentSession()
	 * .createCriteria(UserDetails.class)
	 * .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	 * 
	 * return list; }
	 */

	/*
	 * @Transactional public boolean save(UserDetails userdetails) {
	 * 
	 * try { log.debug("Starting of the method save");
	 * sessionFactory.getCurrentSession().save(userdetails); log.debug(
	 * "Starting of the method save"); return true; } catch (HibernateException
	 * e) { log.error("exception occured in save method" + e.getMessage());
	 * e.printStackTrace(); return false; } }
	 * 
	 * @Transactional public boolean update(UserDetails userdetails) { try {
	 * log.debug("Starting of the method save");
	 * sessionFactory.getCurrentSession().update(userdetails); log.debug(
	 * "Starting of the method save"); return true; } catch (HibernateException
	 * e) { log.error("exception occured in save method" + e.getMessage());
	 * e.printStackTrace(); return false; }
	 */

}
