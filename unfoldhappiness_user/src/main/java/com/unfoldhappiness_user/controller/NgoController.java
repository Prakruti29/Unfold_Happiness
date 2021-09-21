package com.unfoldhappiness_user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



import com.unfoldhappiness_user.model.Area;
import com.unfoldhappiness_user.model.Ngo;
import com.unfoldhappiness_user.service.AreaService;
import com.unfoldhappiness_user.service.NgoService;


@Controller
@RequestMapping("/ngo")
@SessionAttributes("ngo")
public class NgoController extends HttpServlet {

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
		return "ngoregister";
	}

	@RequestMapping(value = { "/saveNgo" }, method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("ngoregister") Ngo ngo, BindingResult result,Model model,HttpServletResponse response) {
		ngo.setArea(1);
		int newResult = ngoservice.addNgo(ngo);
		if (newResult == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/ngo/addNgo";
		}
		
		  //return "redirect/ngo/login";
		 try {
			response.sendRedirect("http://localhost:8080/unfoldhappiness_ngo/ngo/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	}
