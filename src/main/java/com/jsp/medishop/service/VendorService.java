package com.jsp.medishop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;

public interface VendorService {
	
	public ResponseStructure<Vendor> saveVendorService(Vendor vender);
	
	public ResponseStructure<Vendor> getVendorByIdService(int id);
	
	public ResponseStructure<Vendor> getVendorByEmailService(String email);
	
	public List<Vendor> getVendorService();
	
	public ResponseStructure<List<Vendor>> updateVendorByEmailService(Vendor vendor);
	
	public ResponseStructure<Vendor> deleteVendorByEmailService(String email);

	public ResponseStructure<Vendor> loginVendorByEmailAndPasswordService(String email, String password);
	
	public ResponseEntity<String> logoutVendorService();
	
	public ResponseEntity<String> vendorVerifyByIdService(int id);
	
}
