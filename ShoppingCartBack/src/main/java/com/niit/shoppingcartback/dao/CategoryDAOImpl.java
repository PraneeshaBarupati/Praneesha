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

import com.niit.shoppingcartback.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger log=LoggerFactory.getLogger(CategoryDAOImpl.class);

	// get sessions first
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(Category category) {

		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().save(category);
			log.debug("Starting of the method save");
			return true;
		} catch (Exception e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		} 
	}

	@Transactional
	public boolean update(Category category) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().update(category);
			log.debug("Starting of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Category category) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().delete(category);
			log.debug("ending of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Category get(String id) {
		// select * from category where id='101'
		log.debug("Starting of the method save");
		log.info("trying to get product based on id:"+id);
		String hql = "from Category where myid =" + "'" + id + "'";
		log.info("the hql query is:"+hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();

		if (list == null || list.isEmpty()) {
			log.info("no products are available with this id:"+id);
			return null;
		} 
		
		else {
			 return list.get(0);

		}
	

	}
	
	@Transactional
	public Category getByName(String name) {
		// select * from category where name="name"
		log.debug("Starting of the method save");
		log.info("trying to get product based on name:"+name);
		String hql = "from Category where name =" + "'" + name + "'";
		log.info("the hql query is:"+hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();

		if (list == null || list.isEmpty()) {
			log.info("no products are available with this name:"+name);
			return null;
		} 
		
		else {
			 return list.get(0);

		}

	}

	

	@Transactional
	public List<Category> list() {
		log.debug("Starting of the method save");
		String hql = "from Category";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Starting of the method save");
		return query.list();

	}

}
