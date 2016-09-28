package com.niit.shoppingcartback.dao;

import java.util.List;

import com.niit.shoppingcartback.model.UserDetails;



public interface AdminDAO {

	public List<UserDetails> list();

	public UserDetails get(String id);

	public void saveOrUpdate(UserDetails user);

	public void delete(String id);
	
	public boolean isValidAdmin(String id, String password);


}
