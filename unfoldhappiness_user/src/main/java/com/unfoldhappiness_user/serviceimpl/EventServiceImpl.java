package com.unfoldhappiness_user.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unfoldhappiness_user.dao.EventDao;
import com.unfoldhappiness_user.model.Event;
import com.unfoldhappiness_user.service.EventService;

@Service("eventservice")

@Transactional
public class EventServiceImpl implements EventService{

	@Autowired
	EventDao eventdao;
	
	
	public List<Event> getAll() {
		return eventdao.getAll();
	}

}
