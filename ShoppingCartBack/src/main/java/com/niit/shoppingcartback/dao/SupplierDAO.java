package com.niit.shoppingcartback.dao;

import java.util.List;

import com.niit.shoppingcartback.model.Category;
import com.niit.shoppingcartback.model.Supplier;

public interface SupplierDAO {

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(Supplier supplier);

	public Supplier get(String id);

	public Supplier getByName(String name);

	public List<Supplier> list();

}
