package com.unfoldhappiness_user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.unfoldhappiness_user.model.Area;
import com.unfoldhappiness_user.model.Donation;
import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.model.Volunteer;
import com.unfoldhappiness_user.service.AreaService;
import com.unfoldhappiness_user.service.DonationService;



@Controller
@RequestMapping("/donate")
@SessionAttributes("user")
public class DonationController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	DonationService donationservice;
	
	@RequestMapping("/donateItem")
	public String donateItems(ModelMap model) {
		User u=(User) session.getAttribute("user");
		if(u==null)
		{
			return "redirect:/user/userlogin";
		}
		Donation donation=new Donation();
		List<Area> area=areaService.getAll();
		model.addAttribute("donate", donation);
		model.addAttribute("area", area);
		return "donate1";
	}
	@RequestMapping("/saveDetails")
	public String saveDonation(@ModelAttribute("donate") Donation donation,HttpServletRequest request)
	{
		User u=(User) session.getAttribute("user");
		String type=request.getParameter("donation_type");
		donation.setDonation_type(type);
		donation.setUser_id(u.getId());
		donation.setVol_id(1);
		int no=donationservice.addDonation(donation);
		return "donate2";
	}
	@RequestMapping("/donationList")
	public ModelAndView donationList() 
	{
		User u=(User) session.getAttribute("user"); 
		long id=u.getId();
		List<Donation> list=donationservice.getAll(id);
		ModelAndView model=new ModelAndView();
		model.setViewName("myDonations");
		model.addObject("donationList", list);
		return model;
	}
	@RequestMapping("/volDetails/{id}")
	public String donationAccept(@PathVariable long id,Model model)
	{
		Donation donation=donationservice.getVol(id);
		model.addAttribute("volunteer", donation);
			return "donate3";
	}
	@RequestMapping("/donatecause")
	public String page()
	{
		return "donatecause";
	}
	

}
