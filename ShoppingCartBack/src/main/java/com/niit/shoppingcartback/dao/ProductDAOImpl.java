package com.niit.shoppingcartback.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);
	

	// get sessions first
	@Autowired
	private SessionFactory sessionFactory;
	//private ProductDAOImpl list;

	public ProductDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(Product product) {

		try {
		log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().save(product);
			log.debug("ending of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Product product) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().update(product);
			log.debug("ending of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Product product) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("ending of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Product get(String id) {
		// select * from product where id='101'
		log.debug("Starting of the method save");
		log.info("trying to get product based on id:"+id);
		
		String hql = "from product where id =" + " ' " + id + " ' ";
		log.info("the hql query is:"+hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();

		if (list == null || list.isEmpty()) {
			log.info("no products are available with this id:"+id);
			return null;
		} else {
			return list.get(0);

		}
		
	}

	@Transactional
	public List<Product> list() {
		log.debug("Starting of the method save");
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Starting of the method save");
		return query.list();

	}

}
