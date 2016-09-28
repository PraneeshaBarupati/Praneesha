package com.niit.shoppingcartback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Admin")
@Component
public class Admin {

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}

	@Id
	private String id;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
