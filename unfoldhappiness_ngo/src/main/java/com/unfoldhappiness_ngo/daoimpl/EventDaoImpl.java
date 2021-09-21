package com.unfoldhappiness_ngo.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unfoldhappiness_ngo.dao.EventDao;
import com.unfoldhappiness_ngo.model.Event;


@Repository("eventdao")
public class EventDaoImpl extends GenericDaoImpl<Event> implements EventDao{

	public int saveEvent(Event event) {
		super.saveObject(event); 
		  return 0; 
	}

	public List<Event> getAll() {
		// TODO Auto-generated method stub
		 List<Event> list=(List<Event>)super.getByQuery("FROM Event e WHERE e.isdelete=0"); 
		  return list; 
	}

	public Event getById(int id) {
		// TODO Auto-generated method stub
		return super.getById(Event.class, id);
	}

	public int editEvent(Event event) {
		// TODO Auto-generated method stub
		super.updateObject(event);
		return 0;
	}

	public Boolean deleteEvent(long id) {
		// TODO Auto-generated method stub
		Event event =super.getById(Event.class, id); 
		  event.setIsdelete(1); 
		  event.setIsactive(0);
		  return super.updateObject(event).getId()>0; 
	}

}
