package com.jsp.medishop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.repository.CustomerRepository;

public class CustomerDaoImpl implements CustomerDao{

	
	@Autowired
	private CustomerRepository CustomerRepo;
	
	@Override
	public Customer saveCustomerDao(Customer customer) {
		
		return CustomerRepo.save(customer);
	}

	@Override
	public Customer getCustomerByIdDao(int id) {
		
		return CustomerRepo.findById(id).get();
	}

	@Override
	public Customer getCustomerByEmailDao(String email) {
		
		return CustomerRepo.findByEmail(email);
	}

	@Override
	public List<Customer> getCustomerDao() {
		
		return CustomerRepo.findAll();
	}

	@Override
	public Customer UpdateCustomerByEmailDao(Customer customer) {
		Customer customer2 =getCustomerByEmailDao(customer.getEmail());
		if (customer2 != null) {
			return CustomerRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer deleteCustomerByEmailDao(String email) {
		Customer customer=getCustomerByEmailDao(email);
		if (customer != null) {
			CustomerRepo.delete(customer);
			return null;
		}
		return customer;
	}

}
