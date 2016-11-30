/*package com.niit.collaboration.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

import antlr.collections.List;

public class ForumSerice {

	
	@Autowired
	private ForumDAO forumDAO;

	public void setForumDAO(ForumDAO u) {
		this.forumDAO = u;
	}

	@Transactional
	public void addForum(Forum f) {
		forumDAO.addForum(f);
	}

	
	@Transactional
	public List<Forum> listForums() {
		return forumDAO.listForums();
	}
	
	
}
*/