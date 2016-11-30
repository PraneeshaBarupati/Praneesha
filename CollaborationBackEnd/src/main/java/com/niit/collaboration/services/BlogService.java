/*package com.niit.collaboration.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

import antlr.collections.List;

public class BlogService {

	@Autowired
	private BlogDAO blogDAO;

	public void setBlogDAO(BlogDAO u) {
		this.blogDAO = u;
	}

	@Transactional
	public void addBlog(Blog b) {
		blogDAO.addBlog(b);
	}

	
	@Transactional
	public List<Blog> listBlogs() {
		return blogDAO.listBlogs();
	}
	
	
}
*/