package com.unfoldhappiness_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unfoldhappiness_user.model.Event;
import com.unfoldhappiness_user.service.EventService;

@Controller

@RequestMapping("/event")
public class EventController {
	
		
		@Autowired
		EventService eventservice;

		@RequestMapping("/eventList")
		public ModelAndView getAllEvents() {
			List<Event> list = eventservice.getAll();
			ModelAndView model = new ModelAndView();
			model.setViewName("events");
			model.addObject("eventList", list);
			return model;
		}
	

}
