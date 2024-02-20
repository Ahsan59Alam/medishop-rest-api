package com.jsp.medishop.dao;

import java.util.List;

import com.jsp.medishop.dto.Customer;

public interface CustomerDao {
	
	public Customer saveCustomerDao(Customer customer);
	
	public Customer getCustomerByIdDao(int id);
	
	public Customer getCustomerByEmailDao(String email);
	
	public List<Customer> getCustomerDao();
	
	public Customer UpdateCustomerByEmailDao(Customer customer);
	
	public Customer deleteCustomerByEmailDao(String email);


}
