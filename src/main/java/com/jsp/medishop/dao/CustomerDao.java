package com.jsp.medishop.dao;

import java.util.List;

import com.jsp.medishop.dto.Customer;

/**
 * @author Ahsan Alam
 */
public interface CustomerDao {

	public Customer saveCustomerDao(Customer customer);

	public Customer getCustomerByIdDao(int id);

	public Customer getCustomerByEmailDao(String email);

	public List<Customer> getAllCustomersDao();

	public Customer updateCustomerByEmailDao(Customer customer);

	public boolean deleteCustomerByEmailDao(String email);

}
