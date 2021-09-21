package com.unfoldhappiness_volunteer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.unfoldhappiness_volunteer.model.Donation;
import com.unfoldhappiness_volunteer.model.User;
import com.unfoldhappiness_volunteer.model.Volunteer;
import com.unfoldhappiness_volunteer.service.VolunteerService;
import com.unfoldhappiness_volunteer.util.Mailer;



@Controller
@RequestMapping("/volunteer")
@SessionAttributes("volunteer")
public class VolunteerController {
	
	@Autowired 
	VolunteerService volservice;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/home")
	public String homepage() {
		return "volHome"; 
		}
	@RequestMapping("/myProfile")
	public String myProfile() {
		return "myProfile"; 
		}
	
	@RequestMapping("/vollogin")
	public String volloginPage()
	{
		return "volunteerlogin";
	}
	@RequestMapping("/volloggingIn")
	public String login(@ModelAttribute("vollog") Volunteer vol, Model model,HttpServletResponse response) throws IOException {
		Volunteer newVol = volservice.login(vol);
		if (newVol == null) {
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/volunteer/vollogin";
		}
		model.addAttribute("vol", newVol);
		model.addAttribute("login", true);
		session.setAttribute("volunteer", newVol);
		
		return "redirect:/volunteer/home";
	}
	@RequestMapping("/requestList") 
	public ModelAndView getAllRequests(Model model1) {
		Volunteer vol=(Volunteer) session.getAttribute("volunteer");
		int area_id=vol.getArea_name();
		List<Donation> list=volservice.getAllDonations(area_id); 
		ModelAndView model=new ModelAndView(); 
		model.setViewName("manageRequest");
		model.addObject("donationList",list);
		for(Donation d : list)
		{	
			if(d.getStatus()==0)
			{
				model1.addAttribute("done", false);
			}
			else
			{
				model1.addAttribute("done",true);
			}
			
		}
		return model; 
		}
	
	@RequestMapping("/acceptRequest/{id}")
	public String donationAccept(@PathVariable long id,Model model)
	{
		Volunteer vol=(Volunteer) session.getAttribute("volunteer");
		Donation donation=volservice.getById(id);
		donation.setVol_id(vol.getVol_id());
		//if(donation.getVol_id()>0)
		//{
			//return "redirect:/volunteer/home";
		//}
		donation.setStatus(1);
		volservice.updateDonation(donation);
		long user_id=donation.getUser_id();
		Donation u=volservice.getUser(user_id);
		model.addAttribute("user", u);
		String msg="Your request has been accepted by volunteer\n"
				+ "Please click below link to find volunteer details\n\n";
		String link="http://localhost:8081/unfoldhappiness_user/user/userlogin";
		String final1=msg+link;
		 Mailer.send("unfoldhappiness2020@gmail.com", "nspg1234",u.getEmail(), "Hello,How r u?", 
				  final1);
		
		return "donate3";
	}
	
}	
