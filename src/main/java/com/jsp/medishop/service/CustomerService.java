package com.jsp.medishop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;

public interface CustomerService {
	
	public ResponseStructure<Customer> saveCustomerService(Customer customer);
	
	public ResponseStructure<Customer> getCustomerByIdService(int id);
	
	public ResponseStructure<Customer> getCustomerByEmailService(String email);
	
	public List<Customer> getCustomerService();
	
	public ResponseStructure<List<Customer>> updateCustomerByEmailService(Customer customer);
	
	public ResponseStructure<Customer> deleteCustomerByEmailService(String email);
	
	public ResponseStructure<Customer> loginCustomerByEmailAndPasswordService(Customer customer);
	
	public ResponseEntity<String> logoutCustomerService();

}
