package com.niit.shoppingcartback.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartback.model.UserDetails;

@Repository // interact with db
public interface UserDetailsDAO {

	// declare all crud operations

	public boolean save(UserDetails userdetails);

	public boolean update(UserDetails userdetails);

	public boolean delete(UserDetails userdetails);

	public UserDetails get(String id);

	public List<UserDetails> list();
	
	public UserDetails isValidUser(String id,String password);

}