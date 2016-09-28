package com.niit.shoppingcartback.dao;

import java.util.List;

import com.niit.shoppingcartback.model.Cart;

public interface CartDAO {

	public List<Cart> list();

	public Cart get(String id);

	public void saveOrUpdate(Cart Cart);

	public String delete(int id);

	public int getTotalAmount(String id);

}
