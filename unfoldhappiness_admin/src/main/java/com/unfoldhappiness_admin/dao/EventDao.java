
package com.unfoldhappiness_admin.dao;

import java.util.List;

import com.unfoldhappiness_admin.model.Event;

public interface EventDao extends GenericDAO<Event> {

	public int saveEvent(Event event);

	public List<Event> getAll();

	public Event getById(int id);

	public int editEvent(Event event);

	public Boolean deleteEvent(long id);

}
