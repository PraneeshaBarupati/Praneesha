package com.niit.shoppingcartback.dao;

import com.niit.shoppingcartback.model.Account;

public interface AccountDAO {
	
	public Account get(String id);
	
	public boolean trasfer(String id, int amount);
}
