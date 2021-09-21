package com.unfoldhappiness_ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.unfoldhappiness_ngo.model.Ngo;
import com.unfoldhappiness_ngo.model.Product;
import com.unfoldhappiness_ngo.model.ProductType;
import com.unfoldhappiness_ngo.service.NgoService;
import com.unfoldhappiness_ngo.service.ProductService;
import com.unfoldhappiness_ngo.service.ProductTypeService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductTypeService productTypeService;

	
	@RequestMapping("/productList") 
	public ModelAndView getAllProducts(Product product) { 
		List<Product> list=productService.getAll(); 
		ModelAndView model=new ModelAndView(); 
		model.setViewName("manageproducts");
		model.addObject("productList",list); 
		return model; 
		}
	
	@RequestMapping("/registerProduct")
	public String productRegistrationPage(Model model) {
		Product product = new Product();
		List<ProductType> productTypeList=productTypeService.getAll();
		model.addAttribute("productTypeList",productTypeList );
		model.addAttribute("register", product);
		model.addAttribute("edit", false);
		return "Addproduct";
	}
	@RequestMapping("/saveProduct")
	public String registrationPage(@ModelAttribute("register") Product product, BindingResult result, 
			Model model, @RequestParam("image1") MultipartFile file1, 
			@RequestParam("image2") MultipartFile file2) {
		long result1 = productService.addProduct(product, file1, file2);
		return "redirect:/product/productList";
	}
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model)
	{
		Product product = productService.getById(id);
		List<ProductType> productTypeList=productTypeService.getAll();
		model.addAttribute("productTypeList",productTypeList );
		model.addAttribute("register", product);
		model.addAttribute("edit", true);
		return "Addproduct";
	}
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("register") Product product, BindingResult result, Model model,
			@RequestParam("image1") MultipartFile file1, @RequestParam("image2") MultipartFile file2)
	{
		long res=productService.updateProduct(product,file1,file2);
		return "redirect:/product/productList";
	}
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		productService.deleteProduct(id);
		return "redirect:/product/productList";
	}
	@RequestMapping("/viewProduct/{id}")
	public String viewAdmin(@PathVariable("id") int id, Model model)
	{
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		//model.addAttribute("edit", true)
		return "viewproduct";
	}	
	
}
	

