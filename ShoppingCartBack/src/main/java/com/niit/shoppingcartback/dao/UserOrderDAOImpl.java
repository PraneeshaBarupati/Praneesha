package com.niit.shoppingcartback.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartback.model.UserOrder;

@Repository("userOrderDAO")
public class UserOrderDAOImpl {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void saveOrUpdate(UserOrder userOrder) {

		sessionFactory.getCurrentSession().saveOrUpdate(userOrder);

	}
}
