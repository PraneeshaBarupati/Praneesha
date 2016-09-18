package com.niit.shoppingcartback.dao;

import com.niit.shoppingcartback.model.User;

public interface UserDAO {

	// public User get(String id);

	public boolean save(User user);
	
	public boolean update(User user);

	public boolean isValidUser(String id, String password);

	public void saveOrUpdate(User user);

	

}
