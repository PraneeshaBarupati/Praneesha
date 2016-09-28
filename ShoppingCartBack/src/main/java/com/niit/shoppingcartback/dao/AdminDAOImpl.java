package com.niit.shoppingcartback.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.UserDetails;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public AdminDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<UserDetails> list() {
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(UserDetails user) {
		System.out.println("*******AdminDAO   saveOrUpdate Db Operation invoked****** ");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void delete(String id) {
		System.out.println("*******AdminDAO   delete Db Operation invoked****** ");
		UserDetails user = new UserDetails();
		user.setId(Integer.parseInt(id));
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public UserDetails get(String id) {
		System.out.println("*******AdminDAO   get Db Operation invoked******");
		String hql = "from Admin where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;

	}

	@Transactional
	public boolean isValidAdmin(String id, String password) {
		System.out.println("********AdminDAO   isValidAdmin Db Operation  invoked*******");

		String hql = "from Admin where id=" + "'" + id + "'" + " and " + " password =" + "'" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query\t" + query);

		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}

}
