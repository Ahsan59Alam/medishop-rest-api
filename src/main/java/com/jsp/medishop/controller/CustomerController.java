package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) {
		
		return service.saveCustomerService(customer);
	}

}
