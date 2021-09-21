package com.unfoldhappiness_ngo.dao;

import java.util.List;

import com.unfoldhappiness_ngo.model.Event;

public interface EventDao {
	public int saveEvent(Event event);

	public List<Event> getAll();

	public Event getById(int id);

	public int editEvent(Event event);
	public Boolean deleteEvent(long id);

	
}
