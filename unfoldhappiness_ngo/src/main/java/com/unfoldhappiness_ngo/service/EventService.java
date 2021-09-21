package com.unfoldhappiness_ngo.service;

import java.util.List;

import com.unfoldhappiness_ngo.model.Event;

public interface EventService {

	public int addEvent(Event event);

	public List<Event> getAll();

	public Event getById(int id);

	public int editevent(Event event);
	
	public Boolean deleteEvent(long id);
}
