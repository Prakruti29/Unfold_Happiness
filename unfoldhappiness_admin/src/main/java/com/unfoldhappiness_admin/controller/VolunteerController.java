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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.unfoldhappiness_admin.model.Area;
import com.unfoldhappiness_admin.model.Ngo;
import com.unfoldhappiness_admin.model.Volunteer;
import com.unfoldhappiness_admin.service.AreaService;
import com.unfoldhappiness_admin.service.VolunteerService;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {

	@Autowired
	VolunteerService volservice;
	
	@Autowired
	AreaService areaService;
	

	@RequestMapping("/home")
	public String home() {
		return "adminhome";
	}

	@RequestMapping("/registerVol")
	public String registerVolunteer(ModelMap model) {
		Volunteer volunteer = new Volunteer();
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("volregister", volunteer);
		model.addAttribute("edit", false);
		return "volreg";
	}

	@RequestMapping("/saveVol")
	public String savevolunteer(@ModelAttribute("volregister") Volunteer volunteer, BindingResult result, Model model,
			@RequestParam("profileImage") MultipartFile file1, @RequestParam("idProof") MultipartFile file2) {
		long result1 = volservice.addVol(volunteer, file1, file2);
		if (result1 == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/volunteer/registerVol";
		}
		return "redirect:/volunteer/volList";
	}

	@RequestMapping("/volList")
	public ModelAndView getAllVolunteer(Volunteer volunteer) {
		List<Volunteer> list = volservice.getAll();
		ModelAndView model = new ModelAndView();
		model.setViewName("Volunteer_info");
		model.addObject("volList", list);
		return model;
	}

	@RequestMapping("/editVol/{id}")
	public String editVolunteer(@PathVariable int id,ModelMap model) {
		Volunteer volunteer = volservice.getById(id);
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("volregister", volunteer);
		model.addAttribute("edit", true);
		return "volreg";
	}

	
	@RequestMapping("/updateVol")
	public String updateVolunteer(@ModelAttribute("volregister") Volunteer volunteer, BindingResult result, Model model,
			@RequestParam("profileImage") MultipartFile file1, @RequestParam("idProof") MultipartFile file2) {
		long res = volservice.updateVolunteer(volunteer, file1, file2);
		return "redirect:/volunteer/volList";
	}

	 @RequestMapping("/deleteVol/{id}")
	 public String deleteVolunteer(@PathVariable long id) {
		 int result=volservice.deleteVolunteer(id);
	  return "redirect:/volunteer/volList"; 
	  }
	 @RequestMapping({ "/viewVol/{id}" })
		public String viewUser(@PathVariable long id, Model model) {
			Volunteer v = volservice.getById(id);
			model.addAttribute("volview1", v);
			return "volview";
		}
}
