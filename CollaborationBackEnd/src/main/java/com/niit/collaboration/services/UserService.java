/*package com.niit.collaboration.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import antlr.collections.List;

public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO u) {
		this.userDAO = u;
	}

	@Transactional
	public void addUser(User u) {
		userDAO.addUser(u);
	}

	@Transactional
	public void updateUser(User u) {
		userDAO.updateUser(u);
	}

	@Transactional
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Transactional
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	@Transactional
	public User getUserByUsername(String username) {
		return this.userDAO.getUserByUsername(username);
	}

}
*/