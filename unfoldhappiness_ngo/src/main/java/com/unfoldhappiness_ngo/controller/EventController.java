package com.unfoldhappiness_ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.unfoldhappiness_ngo.model.Event;
import com.unfoldhappiness_ngo.service.EventService;



@Controller
@RequestMapping("/event")
public class EventController {

	
	@Autowired
	EventService eventservice;
	
	@RequestMapping("/addEvent")
	public String addEvent(Model model) {
		Event event=new Event();
		model.addAttribute("eventregister", event);
		return "eventreg";
	}
	
	@RequestMapping(value = { "/saveEvent" }, method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("eventregister") Event event, BindingResult result) {
		/*
		 * @RequestMapping("/viewAdmin") public String viewAdmin(Model model) { Admin
		 * admin = (Admin) session.getAttribute("admin"); model.addAttribute("admin",
		 * admin); return "viewAdmin"; }
		 */
		int result1 = eventservice.addEvent(event);
		return "redirect:/event/eventList";
	}
	
	@RequestMapping("/eventList")
	public ModelAndView getAllEvents() {
		List<Event> list = eventservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("manageevent");
		model.addObject("eventList", list);
		return model;
	}
	
	@RequestMapping("/editEvent/{id}")
	public String editEvent(@PathVariable int id, ModelMap model) {
		Event event = eventservice.getById(id);
		model.addAttribute("eventregister", event);
		model.addAttribute("edit", true);
		return "eventreg";
	}
	
	@RequestMapping(value = { "/eventSave" }, method = RequestMethod.POST)
	public String editSave(@ModelAttribute("eventregister") Event event, BindingResult result) {
		event.setNgo_id(1);
		eventservice.editevent(event);
		return "redirect:/event/eventList";

	}
	@RequestMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable long id, @ModelAttribute("eventregister") Event event) {
		Boolean result = eventservice.deleteEvent(id);
		return "redirect:/event/eventList";
	}


}
