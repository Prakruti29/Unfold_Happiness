package com.unfoldhappiness_admin.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Area;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.model.User;
import com.unfoldhappiness_admin.service.AreaService;
import com.unfoldhappiness_admin.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("admin")
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
	AreaService areaService;
	
	@Autowired
	HttpSession session;


	@RequestMapping("/registration")
	public String addAdmin(Model model) {
		User user1 = new User();
		model.addAttribute("userregister", user1);
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("edit", false);
		return "Adduser";
	}

	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable long id, @ModelAttribute("userregister") User user) {
		Boolean result = userservice.deleteUser(id);
		return "redirect:/user/userList";
	}

	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public String registrationPage(@ModelAttribute("userregister") User user,BindingResult result, Model model) {
		long result1 = userservice.addUser(user);
		if (result1 == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/user/registration";
		}
		return "redirect:/user/userList";
		
	}
	@RequestMapping("/userList")
	public ModelAndView getAllUsers() {
		List<User> list = userservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("userlist");
		model.addObject("userList", list);
		return model;
	}
	@RequestMapping("/editUser/{id}")
	public String editUser(@PathVariable long id, ModelMap model) {
		User user = userservice.getById(id);
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("userregister", user);
		model.addAttribute("edit", true);
		return "Adduser";
	}
	
	@RequestMapping(value = { "/editSave" }, method = RequestMethod.POST)
	public String editSave(@ModelAttribute("userregister") User user, BindingResult result) {
		userservice.editUser(user);
		return "redirect:/user/userList";

	}

	@RequestMapping({ "/viewUser/{id}" })
	public String viewUser(@PathVariable long id, Model model) {
		User u = userservice.getById(id);
		model.addAttribute("userview", u);
		return "Userview";
	}

	
}
