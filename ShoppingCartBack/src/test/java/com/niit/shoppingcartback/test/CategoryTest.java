package com.niit.shoppingcartback.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartback.dao.CategoryDAO;
import com.niit.shoppingcartback.model.Category;

public class CategoryTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		System.out.println(categoryDAO);
		Category category = (Category) context.getBean("category");
		System.out.println(category);

		category.setId("Cat_teddies");
		category.setName("Kids_Teddy");
		category.setDescription("kids Teddies available here");
		category.setCreatedby("");

		categoryDAO.save(category); //insert query should triggerd

		if (categoryDAO.save(category) == true) {
			System.out.println("category created successfully");
		} else {
			System.out.println("not able to create category");
		}

	}

}
