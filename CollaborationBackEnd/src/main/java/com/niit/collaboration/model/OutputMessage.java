package com.niit.collaboration.model;

import java.util.Date;

public class OutputMessage {

	private Date time;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public OutputMessage(Message original, Date time, String username) {
		//super(original.getId(), original.getMessage());
		this.time = time;
		this.username = username;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
