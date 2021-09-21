package com.unfoldhappiness_ngo.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_ngo.dao.EventDao;
import com.unfoldhappiness_ngo.model.Event;
import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.service.EventService;

@Service("eventservice")
@SessionAttributes("ngo")
public class EventServiceImpl implements EventService{

	@Autowired
	EventDao eventdao;
	
	@Autowired
	HttpSession session;
	

	public int addEvent(Event event) {
		Ngo ngo = (Ngo) session.getAttribute("ngo");
		event.setCreatedBy(ngo.getId());
		event.setModifyBy(ngo.getId());
		event.setCreatedDate(new Date(System.currentTimeMillis()));
		event.setModifyDate(new Date(System.currentTimeMillis()));
		event.setNgo_id(ngo.getId());
		 return eventdao.saveEvent(event);
	}

	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return eventdao.getAll();
	}

	public Event getById(int id) {
		// TODO Auto-generated method stub
		return eventdao.getById(id);
	}

	public int editevent(Event event) {
		Ngo ngo = (Ngo) session.getAttribute("ngo");
		event.setModifyBy(ngo.getId());
		event.setModifyDate(new Date(System.currentTimeMillis()));
		return eventdao.editEvent(event); 
	}

	public Boolean deleteEvent(long id) {
		// TODO Auto-generated method stub
		return eventdao.deleteEvent(id); 
	}

	
}

