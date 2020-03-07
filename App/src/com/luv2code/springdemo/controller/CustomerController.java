package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the Customer DAO
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/list")
	public String listCustomer(Model themodel) {
		// get customers from the dao
		
		List<Customer> thecustomers= customerService.getCustomers();
		
		// add the customers to the model
		
		System.out.println("list :"+ thecustomers);
		themodel.addAttribute("Customers", thecustomers);
		
		
		
		return "list-customer";
		
		
	}
	@GetMapping("/showFormforAdd")
	public String showFormforAdd (Model themodel) {
		
		//create model attribute to bind form data
		
		Customer thecustomer= new Customer();
		
		themodel.addAttribute("customer", thecustomer);
		
		
		return "Customer-form";
	}

	@PostMapping("/saveCustomer")
	public String savecustomer (@ModelAttribute("customer")Customer thecustomer) {
		
		// save the customer using service

		customerService.savecustomer(thecustomer);
		
		return "redirect:/customer/list";
		
	}
}
