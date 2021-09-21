package com.unfoldhappiness_user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_user.model.Ngo;
import com.unfoldhappiness_user.model.User;
import com.unfoldhappiness_user.model.Volunteer;
import com.unfoldhappiness_user.service.LoginService;

@Controller
@RequestMapping("user")
@SessionAttributes("user")
public class LoginController extends HttpServlet{

	
	@Autowired
	LoginService loginService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

		@RequestMapping ("/ngologin")
		public String loginPage()
		{
			return "ngologin";
		}
		@RequestMapping("/userlogin")
		public String userloginPage()
		{
			return "userlogin";
		}
		
		@RequestMapping("/vollogin")
		public String volloginPage()
		{
			return "volunteerlogin";
		}
		
		@RequestMapping("/volloggingIn")
		public String login(@ModelAttribute("vollog") Volunteer vol, Model model,HttpServletResponse response) throws IOException {
			Volunteer newVol = loginService.login(vol);
			if (newVol == null) {
				model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
				return "redirect:/user/vollogin";
			}
			model.addAttribute("vol", newVol);
			model.addAttribute("login", true);
			session.setAttribute("user", newVol);
			response.sendRedirect("http://localhost:8080/unfoldhappiness_volunteer/volunteer/home");
			return null;
		}
		
		@RequestMapping("/userloggingIn")
		public String login(@ModelAttribute("userlog") User user, Model model,HttpServletResponse response) throws IOException {
			User newUser = loginService.login(user);
			if (newUser == null) {
				model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
				return "redirect:/user/userlogin";
			}
			model.addAttribute("user", newUser);
			model.addAttribute("login", true);
			session.setAttribute("user", newUser);
			return "redirect:/user/home";
		}
		
	@RequestMapping("/ngologgingIn")
	public String login(@ModelAttribute("log") Ngo ngo, Model model,HttpServletResponse response) throws IOException {
		Ngo newNgo = loginService.login(ngo);
		if (newNgo == null) {
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/user/ngologin";
		}
		model.addAttribute("ngo", newNgo);
		model.addAttribute("login", true);
		session.setAttribute("user", newNgo);
		response.sendRedirect("http://localhost:8080/unfoldhappiness_ngo/ngo/home");
		return null;
	}
	
	
	@RequestMapping("/ngoforgotPassword")
	public String forgot() {
		return "forgetpassword";
	}
	
	@RequestMapping("/getPassword")
	public String password(@ModelAttribute("password") Ngo ngo, Model model) {
		Ngo newNgo = loginService.forgotPassword(ngo);
		if (newNgo == null) {
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/ngo/ngologin";
		}
		model.addAttribute("ngo", newNgo);
		// model.addObject("admin", newAdmin);
		return "redirect:/admin/home";
	}
	
	@RequestMapping("/changePassword")
	public String change(Model model) {
		model.addAttribute("cpass", new Ngo());
		return "changePassword";
	}
	
	@RequestMapping("/change")
	public String changePass(@ModelAttribute("cpass") Ngo ngo, Model model) {
		Ngo newNgo = loginService.changePass(ngo);
		if (newNgo == null) {
			model.addAttribute("errorMsg", "Old and new passwords are same...!!!");
			return "redirect:/ngo/changePassword";
		}
		model.addAttribute("ngo", newNgo);
		return "redirect:/ngo/home";
	}


}
