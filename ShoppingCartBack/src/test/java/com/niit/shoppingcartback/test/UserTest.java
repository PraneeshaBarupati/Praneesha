package com.niit.shoppingcartback.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartback.dao.UserDetailsDAO;
import com.niit.shoppingcartback.model.UserDetails;
import com.niit.shoppingcartback.dao.*;

public class UserTest {

	private static final String UserDAO = null;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		// 1 for user Reg
		
		 UserDetails userdetails = (UserDetails)
		 context.getBean("userDetails"); userdetails.setId("30431");
		 userdetails.setName("Deependra"); userdetails.setPassword("007");
		 userdetails.setAddress("Btm"); userdetails.setContact("9742758996");
		 userdetails.setMail("dipendra.eng@gmail.com");
		 
		 UserDetailsDAO udao = (UserDetailsDAO)
		 context.getBean("userDetailsDAO");
		 
		 if (udao.save(userdetails)) { System.out.println(
		 "user registerd successfully"); } else { System.out.println(
		 "not able to create user"); }
		 
		 
		/*// 2.For User Login
		UserDAO udao = (UserDAO) context.getBean("userDAO");

		boolean flag = udao.isValidUser("30431", "007");
		if (flag) {
			System.out.println("valid user**");
		} else {
			System.out.println("invalid user **");
		}*/
		
	}

}
