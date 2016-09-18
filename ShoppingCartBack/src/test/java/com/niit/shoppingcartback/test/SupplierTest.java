package com.niit.shoppingcartback.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartback.dao.SupplierDAO;
import com.niit.shoppingcartback.model.Supplier;



public class SupplierTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		Supplier supplier = (Supplier) context.getBean("supplier");

		supplier.setId("4");
		supplier.setName("praneesha");
		supplier.setAddress("hyderabad");
		supplier.setDescription("iam suppling mobile product");
		
		supplierDAO.save(supplier);
		if(supplierDAO.save(supplier) == true) {
			System.out.println("supplier created successfully");
		} else {
			System.out.println();
		}
	}

}
