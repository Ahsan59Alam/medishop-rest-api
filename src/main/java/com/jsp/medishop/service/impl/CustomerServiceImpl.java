package com.jsp.medishop.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.CustomerService;
import com.jsp.medishop.verification.EmailPasswordVerification;

import jakarta.servlet.http.HttpSession;


@Service
@SuppressWarnings("unused")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private HttpSession httpSession;
	
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
				int currentYear= LocalDate.now().getYear();
				int cutomerDobYear=customer.getDob().getYear();
				int age =currentYear- cutomerDobYear;
				if(age >= 18) {
					dao.saveCustomerDao(customer);
					structure.setData(customer);
					structure.setMsg("Data Insered!!");
					structure.setStatus(HttpStatus.CREATED.value());
					
				} else {
					structure.setData(customer);
					structure.setMsg("you are not eligible your are is less then 18!!");
					structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				}
				
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
		return structure;
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

	@Override
	public ResponseStructure<Customer> loginCustomerByEmailAndPasswordService(Customer customer) {
		Customer customer2=dao.loginCustomerByEmailAndPasswordDao(customer);
		
		if(customer2!=null) {
			if(customer2.getPassword().equals(customer.getPassword())) {
				httpSession.setAttribute("customerEmail", customer2.getEmail());
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("customer---login---successfully");
				customer.setPassword("********");
				structure.setData(customer2);
			}else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMsg("invalid---password---please----try----again");
				structure.setData(customer);
			}
		}else {
			
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg("invalid---email---please----try----again");
			customer.setPassword("********");
			structure.setData(customer2);
		}
		return structure;
	}

	@Override
	public ResponseEntity<String> logoutCustomerService() {
		if(httpSession.getAttribute("customerEmail")!=null) {
			return new ResponseEntity<String> ("Logout---Successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("first---login---then---logout", HttpStatus.OK);
		}
		
	}
	

	
}
