package com.niit.shoppingcartback.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcartback.model.Category;
import com.niit.shoppingcartback.model.Supplier;

// interact with db
public interface CategoryDAO {

	// declare all crud operations

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);

	public Category get(String id);

	public Category getByName(String name);

	public List<Category> list();

}
