package com.unfoldhappiness_user.dao;

import java.util.List;

import com.unfoldhappiness_user.model.Event;

public interface EventDao  extends GenericDAO<Event>  {

	public List<Event> getAll();
}
