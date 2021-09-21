package com.unfoldhappiness_admin.serviceimpl;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_admin.dao.EventDao;
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Event;
import com.unfoldhappiness_admin.service.EventService;

@Service("eventservice")
@SessionAttributes("admin")
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventdao;

	@Autowired
	HttpSession session;
	
	@Override
	public int addEvent(Event event) {
		Admin ad = (Admin) session.getAttribute("admin");
		event.setCreatedBy(ad.getId());
		event.setModifyBy(ad.getId());
		event.setCreatedDate(new Date(System.currentTimeMillis()));
		event.setModifyDate(new Date(System.currentTimeMillis()));
		return eventdao.saveEvent(event);
	}

	@Override
	public List<Event> getAll() { 
		return eventdao.getAll();
	}

	@Override
	public Event getById(int id) { 
		return eventdao.getById(id);
	}

	@Override public int editevent(Event event) {
		Admin ad = (Admin) session.getAttribute("admin");
		event.setModifyBy(ad.getId());
		event.setModifyDate(new Date(System.currentTimeMillis()));
		return eventdao.editEvent(event); 
		}

	@Override public Boolean deleteEvent(long id) { 
		// TODO Auto-generated method stub
		return eventdao.deleteEvent(id); 
	}

}
