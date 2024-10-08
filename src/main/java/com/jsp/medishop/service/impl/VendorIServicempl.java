package com.jsp.medishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.VendorService;
import com.jsp.medishop.verification.EmailPasswordVerification;

import jakarta.servlet.http.HttpSession;

@Service
public class VendorIServicempl implements VendorService{
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private VendorDao dao;
	
	@Autowired
	private EmailPasswordVerification verification;
	
	@Autowired
	private ResponseStructure<Vendor> structure;
	
	@Autowired
	private ResponseStructure<List<Vendor>> structure2;
	

	@Override
	public ResponseStructure<Vendor> saveVendorService(Vendor vendor) {
		String email=verification.verifyEmail(vendor.getEmail());
		String password=verification.VerifyPassword(vendor.getPassword());
		
		if (email !=null) {
			if (password != null) {
				dao.saveVendorDao(vendor);
				structure.setData(vendor);
				structure.setMsg("Data Inserted!!");
				structure.setStatus(HttpStatus.CREATED.value());
			}else {
				structure.setData(vendor);
				structure.setMsg("Please create a valid password!!");
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			}
		}else {
			structure.setData(vendor);
			structure.setMsg("Please enter a valid email!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<Vendor> getVendorByIdService(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> getVendorByEmailService(String email) {
		Vendor vendor=dao.getVendorByEmailDao(email);
		if(vendor!=null) {
			structure.setData(vendor);
			structure.setMsg("vendor founded");
			structure.setStatus(HttpStatus.FOUND.value());
		}else {
			structure.setData(vendor);
			structure.setMsg("vendor not founded");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public List<Vendor> getVendorService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> updateVendorByEmailService(Vendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> deleteVendorByEmailService(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> loginVendorByEmailAndPasswordService(String email, String password) {
		Vendor vendor=dao.getVendorByEmailDao(email);
		if (vendor!=null) {
			
			if((vendor.getPassword().equals(password)) && (vendor.getVendorStatus().equalsIgnoreCase(password))) {
				httpSession.setAttribute("vendorEmail", email);
				structure.setStatus(HttpStatus.OK.value());
				structure.setMsg("vendor--login--successfully");
				vendor.setPassword("************");
				structure.setData(vendor);
				
			}else {
				structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				structure.setMsg("Wrong password ...you are not verified pleade contact admin");
				vendor.setPassword(password);
				structure.setData(vendor);
			}
			
		}else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMsg(" email increact");
			vendor.setPassword("************");
			vendor.setEmail(email);
			structure.setData(vendor);
			
		}
		return structure;
	}

	
	/**
	 * logout vendor from session
	 */
	
	@Override
	public ResponseEntity<String> logoutVendorService() {
		if(httpSession.getAttribute("vendorEmail")!=null) {
			httpSession.invalidate();
			return new ResponseEntity<String>("vendor logout seccess", HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("Please login then logout", HttpStatus.NOT_ACCEPTABLE);
			
			
		}
		
	}

	@Override
	public ResponseEntity<String> vendorVerifyByIdService(int id) {
	
		String adminEmail=(String) httpSession.getAttribute("adminEmail");
		if(adminEmail!=null) {
			dao.vendorVerifyByIdDao(id);
			return new ResponseEntity<String>("vendor verified successfully",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("please login with admin and then verify",HttpStatus.NOT_ACCEPTABLE);
			
		}
	}

	@Override
	public ResponseStructure<List<Vendor>> getAllVendorsService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> loginVendorWithEmailService(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> logoutVendorWithEmailService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<Vendor> addMedicineWithVendorService(Medicine medicine) {
		// TODO Auto-generated method stub
		return null;
	}

}
