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
import com.unfoldhappiness_admin.model.Admin;
import com.unfoldhappiness_admin.model.Area;
import com.unfoldhappiness_admin.model.Donation;
import com.unfoldhappiness_admin.service.AdminService;
import com.unfoldhappiness_admin.service.AreaService;
import com.unfoldhappiness_admin.service.DonationService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class AdminController {

	@Autowired
	AdminService service;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	DonationService donationservice;

	/*
	 * @RequestMapping("/home") public String loginpage() { return "adminhome"; }
	 * 
	 * @RequestMapping("/addAdmin") public String registrationpage(ModelMap model) {
	 * Admin admin = new Admin(); model.addAttribute("admin", admin);
	 * model.addAttribute("edit", false); return "redirect:/Addadmin"; }
	 */
	@RequestMapping(value = { "/saveAdmin" }, method = RequestMethod.POST)
	public String registrationPage(@ModelAttribute("adminregister") Admin admin, BindingResult result, Model model,
			@RequestParam("profileImage") MultipartFile file) {
		long result1 = service.addAdmin(admin, file);
		if (result1 == 1) {
			model.addAttribute("errorMsg", "Email-ID is already exists...!!!");
			return "redirect:/admin/adminForm";
		}
		return "redirect:/admin/adminList";
		
	}

	@RequestMapping("/adminForm")
	public String addAdmin(Model model) {
		Admin admin1 = new Admin();
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("edit", false);
		model.addAttribute("adminregister", admin1);
		return "addAdmin";
	}
	@RequestMapping("/adminList") 
	public ModelAndView getAllAdmins(Admin admin) { 
		List<Admin> list=service.getAll(); 
		ModelAndView model=new ModelAndView(); 
		model.setViewName("adminList");
		model.addObject("adminList",list); 
		return model; 
		}
	@RequestMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable long id, @ModelAttribute("adminregister") Admin admin) {
		Boolean result = service.deleteAdmin(id);
		return "redirect:/admin/adminList";
	}
	@RequestMapping("/editAdmin/{id}") 
	public String editAdmin(@PathVariable int id,ModelMap model) {
		Admin admin=service.getById(id);
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("adminregister", admin); 
		model.addAttribute("edit", true); 
		return "addAdmin";
	}
	@RequestMapping("/editAdmin")
	public String editAdmin(Model model) {
		Admin admin = (Admin) session.getAttribute("admin");
		List<Area> areaList=areaService.getAll();
		model.addAttribute("areaList",areaList);
		model.addAttribute("adminregister", admin);
		model.addAttribute("edit", true);
		return "addAdmin";
	}

	@RequestMapping("/updateAdmin")
	public String updateAdmin(@ModelAttribute("adminregister") Admin admin, BindingResult result, Model model,
			@RequestParam("profileImage") MultipartFile file1)
	{
		long res=service.updateAdmin(admin,file1);
		return "redirect:/admin/adminList";
	}

	@RequestMapping("/viewAdmin/{id}")
	public String viewAdmin(@PathVariable("id") int id, Model model) {
		Admin admin = service.getById(id);
		model.addAttribute("admin", admin);
		return "viewAdmin";
	}
	
	@RequestMapping("/viewProfile")
	public String viewAdmin(Model model) 
	{
		Admin admin = (Admin) session.getAttribute("admin");
		long id=admin.getId();
		Admin newAdmin = service.getById(id);
		model.addAttribute("admin", newAdmin);
		return "viewAdmin";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String displayLogin(Model model) { 
	    model.addAttribute("login", new LoginController()); 
	    return "login"; 
	}
	@RequestMapping("/managerequest")
	public ModelAndView getDonations()
	{
		List<Donation> list=donationservice.getAll();
		ModelAndView model=new ModelAndView();
		model.setViewName("managerequest");
		model.addObject("donationList", list);
		return model;
		
	}
	@RequestMapping("/viewdonation")
	public ModelAndView getAllDonations()
	{
		List<Donation> list=donationservice.getAll();
		ModelAndView model=new ModelAndView();
		model.setViewName("managedonation");
		model.addObject("donationList", list);
		return model;
	}
	
	@RequestMapping("/viewdetails//{id}")
	public String viewAlldetails(@PathVariable long id,Model model)
	{
		Donation donation=donationservice.getDetails(id);
		model.addAttribute("details", donation);
		return "donation_details";
	}



			  


	/*
	 * @RequestMapping("/login") public String login(Admin admin) { return
	 * "adminLogin"; }
	 * 
	 * *
	 * 
	 * @RequestMapping("/studentList") public ModelAndView getAllStudents(Student
	 * st) { List<Student> list=service.getAll(); ModelAndView model=new
	 * ModelAndView(); model.setViewName("emplist");
	 * model.addObject("empList",list); return model; }
	 * 
	 * @RequestMapping("/addAdmin") public String saveStudent(Admin admin) {
	 * service.addAdmin(admin); return "redirect:/admin/adminhome"; }
	 * 
	 * @RequestMapping("/deleteStudent/{id}") public String
	 * deleteStudent(@PathVariable int id) { int result=service.deleteAdmin(id);
	 * return "redirect:/admin/studentList"; }
	 * 
	 * @RequestMapping("/editStudent/{id}") public String editStudent(@PathVariable
	 * int id,ModelMap model) { Admin admin=service.editStudent(id);
	 * model.addAttribute("st", admin); model.addAttribute("edit", true); return
	 * "registrationpage1"; }
	 * 
	 * 
	 */
}
