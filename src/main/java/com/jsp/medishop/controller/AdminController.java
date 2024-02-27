package com.jsp.medishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dao.AdminDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.AdminService;
import com.jsp.medishop.service.VendorService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AdminController {
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/loginAdmin")
	public ResponseStructure<Admin> loginAdminByEmailAndPasswordCotroller(@RequestBody Admin admin){
		return adminService.loginAdminByEmailAndPasswordService(admin);
	}
	

	@GetMapping("/logout")
	public ResponseEntity<String> logoutAdminController() {
		return adminService.logoutAdminSrevice();
	}
	
	
	@GetMapping(value ="/verifyVendor/{id}")
	public ResponseEntity<String> vendorVerifyByIdService(@PathVariable int id) {
		return vendorService.vendorVerifyByIdService(id);
	}
}
