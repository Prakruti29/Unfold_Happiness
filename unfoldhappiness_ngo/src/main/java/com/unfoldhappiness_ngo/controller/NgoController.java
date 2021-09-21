package com.unfoldhappiness_ngo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.unfoldhappiness_ngo.model.Area;
import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.service.AreaService;
import com.unfoldhappiness_ngo.service.NgoService;


@Controller
@RequestMapping("/ngo")
@SessionAttributes("ngo")
public class NgoController {

	@Autowired
	NgoService ngoservice;

	@Autowired
	AreaService areaService;
	
	@Autowired
	HttpSession session;
	
	
	

	@RequestMapping("/addNgo")
	public String addNgo(Model model) {
		Ngo ngo=new Ngo();
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("ngoregister", ngo);
		model.addAttribute("edit", false);
		return "addngo";
	}

	@RequestMapping(value = { "/saveNgo" }, method = RequestMethod.POST)
	public String saveNgo(@ModelAttribute("ngoregister") Ngo ngo, BindingResult result,Model model) {
		int newResult = ngoservice.addNgo(ngo);
		if (newResult == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/ngo/addNgo";
		}
		
		return "redirect:/ngo/ngoList";

	}

	@RequestMapping("/ngoList")
	public ModelAndView getAllNgo() {
		List<Ngo> list = ngoservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("NGO_info");
		model.addObject("ngoList", list);
		return model;
	}
	
	@RequestMapping("/editNgo/{id}")
	public String editNgo(@PathVariable long id, ModelMap model) {
		Ngo ngo = ngoservice.getById(id);
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("ngoregister", ngo);
		model.addAttribute("edit", true);
		return "addngo";
	}
	
	@RequestMapping(value = { "/ngoSave" }, method = RequestMethod.POST)
	public String editSave(@ModelAttribute("ngoregister") Ngo ngo, BindingResult result) {
		ngoservice.editngo(ngo);
		return "redirect:/ngo/ngoList";

	}
	
	@RequestMapping("/deleteNgo/{id}")
	public String deleteAdmin(@PathVariable long id, @ModelAttribute("ngoregister") Ngo ngo ){
		Boolean result = ngoservice.deleteNgo(id);
		return "redirect:/ngo/ngoList";
	}
	
	@RequestMapping({ "/viewNgo/{id}" })
	public String viewUser(@PathVariable long id, Model model) {
		Ngo n = ngoservice.getById(id);
		model.addAttribute("ngoview", n);
		return "ngo_reg";
	}
	@RequestMapping("/viewNgo")
	public String viewAdmin(Model model) 
	{
		Ngo ngo = (Ngo) session.getAttribute("ngo");
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("ngoview", ngo);
		return "ngo_reg";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("login", new LoginController()); 
	    return "login"; 
	}
}
