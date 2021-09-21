package com.unfoldhappiness_user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.unfoldhappiness_user.model.Area;
import com.unfoldhappiness_user.model.Volunteer;
import com.unfoldhappiness_user.service.AreaService;
import com.unfoldhappiness_user.service.VolunteerService;

@Controller
@RequestMapping("/volunteer")
@SessionAttributes("volunteer")
public class VolunteerController {

	@Autowired
	VolunteerService volservice;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/registerVol")
	public String registerVolunteer(ModelMap model) {
		Volunteer volunteer = new Volunteer();
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("volregister", volunteer);
		model.addAttribute("edit", false);
		return "volunteerregister";
	}
	
	@RequestMapping("/saveVol")
	public String savevolunteer(@ModelAttribute("volregister") Volunteer volunteer, BindingResult result, Model model,
			@RequestParam("profileImage") MultipartFile file1, @RequestParam("idProof") MultipartFile file2) {
		long result1 = volservice.addVol(volunteer, file1, file2);
		if (result1 == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/volunteer/registerVol";
		}
		return "redirect:/volunteer/home";
	}

}
