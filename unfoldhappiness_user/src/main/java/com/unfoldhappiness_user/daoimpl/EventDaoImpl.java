package com.unfoldhappiness_user.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_user.dao.EventDao;
import com.unfoldhappiness_user.model.Event;

@Repository("eventdao")
public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao {

	public List<Event> getAll() {
		List<Event> list=(List<Event>)super.getByQuery("FROM Event e WHERE e.isdelete=0"); 
		  return list; 
	}

}
