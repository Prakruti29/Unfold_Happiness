
package com.unfoldhappiness_admin.controller;

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

import com.unfoldhappiness_admin.model.Event;
import com.unfoldhappiness_admin.model.Ngo;

import com.unfoldhappiness_admin.service.EventService;
import com.unfoldhappiness_admin.service.NgoService;

@Controller

@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventservice;

	@Autowired
	NgoService ngoservice;

	@RequestMapping("/addEvent")
	public String addEvent(Model model) {
		Event event = new Event();
		List<Ngo> ngolist = ngoservice.getAll();
		model.addAttribute("ngolist", ngolist);
		model.addAttribute("eventregister", event);
		return "eventreg";
	}

	@RequestMapping(value = { "/saveEvent" }, method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("eventregister") Event event, BindingResult result) {
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
	public String editAdmin(@PathVariable int id, ModelMap model) {
		Event event = eventservice.getById(id);
		List<Ngo> ngolist = ngoservice.getAll();
		model.addAttribute("ngolist", ngolist);
		model.addAttribute("eventregister", event);
		model.addAttribute("edit", true);
		return "eventreg";
	}

	@RequestMapping(value = { "/eventSave" }, method = RequestMethod.POST)
	public String editSave(@ModelAttribute("eventregister") Event event, BindingResult result) {
		eventservice.editevent(event);
		return "redirect:/event/eventList";

	}

	@RequestMapping("/deleteEvent/{id}")
	public String deleteAdmin(@PathVariable long id, @ModelAttribute("eventregister") Event event) {
		Boolean result = eventservice.deleteEvent(id);
		return "redirect:/event/eventList";
	}
}
