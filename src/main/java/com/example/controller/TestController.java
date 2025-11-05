package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.stereotype.Service; 
import com.example.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.service.ProductService;

@Controller
public class TestController {
@Autowired
	private ProductService service;
	

@GetMapping("/")
public ModelAndView loadForm() {
	ModelAndVierw view = new ModelAndView();
	
	view.addObject("pobj", new Product());
	view.setViewName("index");
	return view;
}
@PostMapping("/product") 
public ModelAndView saveProduct(Product pobj) { 
 ModelAndView mav = new ModelAndView(); 

 boolean status = productService.saveProduct(pobj); 
 if (status) { 
  mav.addObject("smsg", "Product Saved"); 
 } else { 
  mav.addObject("emsg", "Failed to save"); 
 } 

 mav.addObject("pobj", new Product());// for form binding 
 mav.setViewName("index"); 
 return mav; 
}
@GetMapping("/products") 
public ModelAndView viewProducts() {
	List<Product> productsList = productService.getAllProducts(); 
	ModelAndView mav = new ModelAndView(); 
	mav.addObject("plist", productsList); 
	mav.setViewName("data"); 
	return mav; 
	}
}

