package com.niit.shoppingcartback.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartback.dao.ProductDAO;
import com.niit.shoppingcartback.model.Product;

public class ProductTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		System.out.println(productDAO);
		Product product = (Product) context.getBean("product");
		System.out.println(product);
		product.setId("Toys_06");
		product.setName("Toy_car");
		product.setDescription("This is car");
		product.setPrice("500");
		productDAO.save(product);
		/*
		 * if (productDAO.save(product) == true) { System.out.println(
		 * "product created successfully"); } else { System.out.println(
		 * "not able to create product"); }
		 * 
		 */

	}

}
