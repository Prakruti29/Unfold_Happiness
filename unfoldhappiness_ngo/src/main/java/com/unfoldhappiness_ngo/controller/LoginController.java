package com.unfoldhappiness_ngo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.service.LoginService;

@Controller
@RequestMapping("/ngo")
@SessionAttributes("ngo")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/home")
	public String homePage() {
		return "adminhome";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "adminLogin";
	}
	
	@RequestMapping("/loggingIn")
	public String login(@ModelAttribute("log") Ngo ngo, Model model) {
		Ngo newNgo = loginService.login(ngo);
		if (newNgo == null) {
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/ngo/login";
		}
		model.addAttribute("ngo", newNgo);
		session.setAttribute("ngo", newNgo);
		return "redirect:/ngo/home";
	}
	@RequestMapping("/forgotPassword")
	public String forgot() {
		return "forgotpassword";
	}

	@RequestMapping("/getPassword")
	public String password(@ModelAttribute("password") Ngo ngo, Model model) {
		Ngo newNgo = loginService.forgotPassword(ngo);
		if (newNgo == null) {
			model.addAttribute("errorMsg", "Wrong Username!!!");
			return "redirect:/ngo/forgotPassword";
		}
		
		model.addAttribute("ngo", newNgo);
		// model.addObject("admin", newAdmin);
		return "redirect:/ngo/home";
	}

	@RequestMapping("/changePassword")
	public String change(Model model) {
		model.addAttribute("cpass", new Ngo());
		return "changepassword";
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
	 @RequestMapping("/logout")	
	 public String logout()
	 {
	     session.removeAttribute("ngo");
	     return "redirect:/ngo/login";  
	            
	 }

}
