package com.niit.shoppingcartback.dao;

import java.util.List;
import java.util.jar.Attributes.Name;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	// get sessions first
	@Autowired
	private SessionFactory sessionFactory;
	// private SupplierDAOImpl list;

	public SupplierDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(Supplier supplier) {

		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().save(supplier);
			log.debug("Starting of the method save");
			return true;
		} catch (Exception e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Supplier supplier) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().update(supplier);
			log.debug("Starting of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Supplier supplier) {
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("ending of the method save");
			return true;
		} catch (HibernateException e) {
			log.error("exception occured in save method" + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Supplier get(String id) {
		// select * from supplier where id='101'
		log.debug("Starting of the method save");
		log.info("trying to get product based on id:" + id);
		String hql = "from Supplier where myid =" + "'" + id + "'";
		log.info("the hql query is:" + hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();

		if (list == null || list.isEmpty()) {
			log.info("no products are available with this id:" + id);
			return null;
		} else {
			return list.get(0);

		}

	}

	@Transactional
	public Supplier geByName(String name) {
		// select * from supplier where name="name"
		log.debug("Starting of the method save");
		log.info("trying to get product based on name:" + name);
		String hql = "from Supplier where name =" + "'" + name + "'";
		log.info("the hql query is:" + hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();

		if (list == null || list.isEmpty()) {
			log.info("no products are available with this name:" + name);
			return null;
		} else {
			return list.get(0);

		}

	}

	@Transactional
	public List<Supplier> list() {
		log.debug("Starting of the method save");
		String hql = "from supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Starting of the method save");
		return query.list();

	}

	public Supplier getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
