package com.niit.collaboration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Blog;

import antlr.debug.Event;



@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	Blog blog;
	
	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list();
	}

	@Transactional
	public boolean save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public void delete(String id) {
		Blog blog = new Blog();
		blog.setId(id);
		sessionFactory.getCurrentSession().delete(blog);

	}

	@Transactional
	public List<Blog> get(String id) {
		System.out.println("BlogDAO get Operation  invoked");

		String hql = "from User where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Query:\t" + query);

		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		System.out.println(list.toString());

		if (list != null && !list.isEmpty()) {
			return list();
		}

		return list;
	}

	public boolean get(String id, String password) {
		
		return false;
	}

	public void getid(String id) {
		
	}

}
