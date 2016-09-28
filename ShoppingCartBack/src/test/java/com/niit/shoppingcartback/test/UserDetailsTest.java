package com.niit.shoppingcartback.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartback.dao.UserDetailsDAO;
import com.niit.shoppingcartback.model.UserDetails;

public class UserDetailsTest {
	private static final String UserDAO = null;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		// 1 for user Reg

		UserDetails userdetails = (UserDetails) context.getBean("userDetails");
		userdetails.setId(30430);
		userdetails.setName("Deependra");
		userdetails.setPassword("007");
		userdetails.setAddress("Btm");
		userdetails.setContact("9742758996");
		userdetails.setMail("dipendra.eng@gmail.com");
		userdetails.setAddress("hyd");
		

		UserDetailsDAO udao = (UserDetailsDAO) context.getBean("userDetailsDAO");

		udao.saveOrUpdate(userdetails);

	}
}
