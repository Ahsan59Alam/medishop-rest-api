package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;
import com.jsp.medishop.verification.EmailPasswordVerification;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private EmailPasswordVerification verification;
	
	@Autowired
	private ResponseStructure<Customer> structure;
	
	@Autowired
	private ResponseStructure<List<Customer>> structure2;
	
	
	@Override
	public ResponseStructure<Customer> saveCustomerService(Customer customer) {
		String email=verification.verifyEmail(customer.getEmail());
		String password=verification.VerifyPassword(customer.getPassword());
		
		if (email!=null) {
			if (password!=null) {
				structure.setData(customer);
				structure.setMsg("Data Insered!!");
				structure.setStatus(HttpStatus.CREATED.value());
				
			}else {
				structure.setData(customer);
				structure.setMsg("Please check your password!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				
			}
		
		}else {
			structure.setData(customer);
			structure.setMsg("Please check your email!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			
		}
		return null;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByIdService(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> getCustomerByEmailService(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<List<Customer>> updateCustomerByEmailService(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Customer> deleteCustomerByEmailService(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
