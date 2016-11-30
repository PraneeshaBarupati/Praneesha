package com.niit.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="S_USER")
@Component
public class User extends BaseDomain{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id;

	@NotEmpty(message = "Please Enter Username")
	private String username;

	@NotEmpty(message = "Please Enter Password")
	private String password;

	@NotEmpty(message = "Please Enter Email")
	private String email;

	@NotEmpty(message = "Please Enter Adress")
	private String adress;

	private String role;
	
	private String isOnline;

	//getters and setters
	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * @Transient private MultipartFile profilePicture;
	 */

}
