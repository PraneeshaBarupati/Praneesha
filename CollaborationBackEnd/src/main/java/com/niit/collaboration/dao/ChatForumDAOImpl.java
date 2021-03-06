package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaboration.model.ChatForum;
import com.niit.collaboration.model.ChatForumComment;
import com.niit.collaboration.model.Forum;

public class ChatForumDAOImpl implements ChatForumDAO {


	@Autowired
	ChatForum chatForum;

	@Autowired
	ChatForumDAO chatForumDAO;

	@Autowired
	private SessionFactory sessionFactory;

	public ChatForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ChatForum> list() {
		@SuppressWarnings("unchecked")
		List<ChatForum> list = (List<ChatForum>) sessionFactory.getCurrentSession().createCriteria(ChatForum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public boolean save(ChatForum chatForum) {
		try {
			sessionFactory.getCurrentSession().save(chatForum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(ChatForum chatForum) {
		try {
			sessionFactory.getCurrentSession().update(chatForum);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public void deleteChatForum(String id) {
		ChatForum chatForum = new ChatForum();
		chatForum.setId(id);
		sessionFactory.getCurrentSession().delete(chatForum);

	}

	@Transactional
	public ChatForum getChatForum(String id) {
		System.out.println("ChatForumDAO get Operation  invoked");

		String hql = "from User where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query:\t" + query);

		@SuppressWarnings("unchecked")
		List<ChatForum> list = (List<ChatForum>) query.list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Transactional
	public ChatForum get(String userID, String friendID) {
		System.out.println("ChatForumDAO get Operation  invoked");

		String hql = "from User where userID = " + "'" + userID + "' and friendID=" + "'" + friendID + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query:\t" + query);

		@SuppressWarnings("unchecked")
		List<ChatForum> list = (List<ChatForum>) query.list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	// For ChatForumComment CRUD Operations

	public ChatForumComment getChatForumComment(String id) {
		String hql = "from ChatForumComment where id = " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query:\t" + query);
		@SuppressWarnings("unchecked")
		List<ChatForumComment> list = (List<ChatForumComment>) query.list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return (ChatForumComment) list();
		}

		return null;

	}

	public boolean save(ChatForumComment chatForumComment) {
		try {
			sessionFactory.getCurrentSession().save(chatForumComment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(ChatForumComment chatForumComment) {
		try {
			sessionFactory.getCurrentSession().update(chatForumComment);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public void deleteChatForumComment(String id) {
		ChatForumComment chatForumComment = new ChatForumComment();
		chatForumComment.setId(id);
		sessionFactory.getCurrentSession().delete(chatForumComment);

	}
}
