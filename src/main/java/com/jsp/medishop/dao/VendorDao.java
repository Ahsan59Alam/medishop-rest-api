package com.jsp.medishop.dao;

import java.util.List;

import com.jsp.medishop.dto.Vendor;

public interface VendorDao {

	
	public Vendor saveVendorDao(Vendor vendor);
	
	public Vendor getVendorByIdDao(int id);
	
	public Vendor getVendorByEmailDao(String email);
	
	public List<Vendor> getVendorDao();
	
	public Vendor updateVendorByEmailDao(Vendor vendor);
	
	public Vendor deleteVendorByEmailDao(String email);

	public Vendor vendorVerifyByIdDao(int id);
}
