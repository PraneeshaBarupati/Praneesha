package com.niit.collaboration.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaboration.model.Chat;

public class ChatDAOImpl {

	@Autowired
	Chat chat;

	@Autowired
	private SessionFactory sessionFactory;

	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Chat> list() {
		@SuppressWarnings("unchecked")
		List<Chat> list = (List<Chat>) sessionFactory.getCurrentSession().createCriteria(Chat.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public boolean save(Chat chat) {
		try {
			sessionFactory.getCurrentSession().save(chat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Chat chat) {
		try {
			sessionFactory.getCurrentSession().update(chat);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public void delete(int id) {
		Chat chat = new Chat();
		chat.setId(id);
		sessionFactory.getCurrentSession().delete(chat);

	}

	@Transactional
	public Chat get(String id) {
		System.out.println("ChatDAO get Operation  invoked");

		String hql = "from User where id=" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query:\t" + query);

		@SuppressWarnings("unchecked")
		List<Chat> list = (List<Chat>) ((Criteria) query).list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Transactional
	public Chat get(String userID, String friendID) {
		System.out.println("ChatDAO get Operation  invoked");

		String hql = "from User where userID = " + "'" + userID + "' and friendID=" + "'" + friendID + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query:\t" + query);

		@SuppressWarnings("unchecked")
		List<Chat> list = (List<Chat>) ((Criteria) query).list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

}
