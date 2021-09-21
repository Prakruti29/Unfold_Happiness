package com.unfoldhappiness_admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.service.LoginService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")

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
	public String login(@ModelAttribute("log") Admin admin, Model model) {
		Admin newAdmin = loginService.login(admin);
		if (newAdmin == null) {
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/admin/login";
		}
		model.addAttribute("admin", newAdmin);
		session.setAttribute("admin", newAdmin);
		return "redirect:/admin/home";
	}

	@RequestMapping("/forgotPassword")
	public String forgot() {
		return "forgotpassword";
	}

	@RequestMapping("/getPassword")
	public String password(@ModelAttribute("password") Admin admin, Model model) {
		Admin newAdmin = loginService.forgotPassword(admin);
		if (newAdmin == null) {
			model.addAttribute("errorMsg", "Wrong Username!!!");
			return "redirect:/admin/login";
		}
		
		model.addAttribute("admin", newAdmin);
		// model.addObject("admin", newAdmin);
		return "redirect:/admin/home";
	}

	@RequestMapping("/changePassword")
	public String change(Model model) {
		model.addAttribute("cpass", new Admin());
		return "changepassword";
	}

	@RequestMapping("/change")
	public String changePass(@ModelAttribute("cpass") Admin admin, Model model) {
		Admin newAdmin = loginService.changePass(admin);
		if (newAdmin == null) {
			model.addAttribute("errorMsg", "Old and new passwords are same...!!!");
			return "redirect:/admin/changePassword";
		}
		model.addAttribute("admin", newAdmin);
		return "redirect:/admin/home";
	}
	 @RequestMapping("/logout")	
	 public String logout()
	 {
	     session.removeAttribute("admin");
	     return "redirect:/admin/login";  
	            
	 }
}
	 /*
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

