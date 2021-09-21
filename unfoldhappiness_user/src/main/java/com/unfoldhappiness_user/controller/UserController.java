package com.unfoldhappiness_user.controller;

import java.io.IOException;
import java.util.List;

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
import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.service.AreaService;
import com.unfoldhappiness_user.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		User user=new User();
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("userregister", user);
		return "userregister";
	}
	
	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("userregister") User user, BindingResult result,Model model,HttpServletResponse response) {
		//user.setArea(1);
		int newResult = userservice.addUser(user);
		if (newResult == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/user/login";
		}
		 session.setAttribute("user", newResult);
		 return "redirect:/user/home";

	}
	@RequestMapping("/feedback")
	public String feedback()
	{
		return "feedback";
	}
	@RequestMapping("/aboutus")
	public String aboutUs()
	{
		return "aboutus";
	}
}
