package com.niit.collaboration.dao;

import java.util.List;

import antlr.debug.Event;

public interface EventDAO {

	public List<Event> list();

	// public boolean get(String id, String password);

	public List<Event> get(String id);

	public boolean save(Event event);

	public boolean update(Event event);

	public void delete(String id);

	// public boolean isValidEvent(String id, String name);

	
	
}
