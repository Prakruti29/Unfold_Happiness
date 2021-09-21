package com.unfoldhappiness_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {

	@RequestMapping("/products")
	public String products()
	{
		return "products";
	}
	@RequestMapping("/productDetails")
	public String productsDetails()
	{
		return "productdetails";
	}
}
