package com.niit.shoppingcartback.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartback.model.UserDetails;

@Repository // interact with db
public interface UserDetailsDAO {

	// declare all crud operations

	public void saveOrUpdate(UserDetails userDetails);


	public void delete(String id);

	public UserDetails get(String name);

	public List<UserDetails> list();
	
	public boolean isValidUser(String id,String password);

}
