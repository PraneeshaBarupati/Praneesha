/*package com.niit.collaboration.junit_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserDetailsTest {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;

	public static void init() { 

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		user = (User) context.getBean(user);
		userDAO = (UserDAO) context.getBean(userDAO);
	}

	public void userTestcase() {
		user.setId();
	}
}
*/