package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

import antlr.debug.Event;

public interface BlogDAO {


	public List<Blog> list();

	public boolean get(String id, String password);

	public List<Blog> get(String id);

	public boolean save(Blog blog);

	public boolean update(Blog blog);

	public void delete(String id);
	
	//public void getid(String id);

	//public boolean isValidEvent(String id, String name);
}
