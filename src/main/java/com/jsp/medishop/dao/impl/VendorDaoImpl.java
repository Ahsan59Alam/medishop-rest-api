package com.jsp.medishop.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Admin;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.repository.AdminRepository;
import com.jsp.medishop.repository.VendorRepository;

import jakarta.servlet.http.HttpSession;

@Repository
class VendorDaoImpl implements VendorDao {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private VendorRepository VendorRepo;
	
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Vendor saveVendorDao(Vendor vendor) {
		
		return VendorRepo.save(vendor);
	}

	@Override
	public Vendor getVendorByIdDao(int id) {
		
		Optional<Vendor> optional=VendorRepo.findById(id);
		
		if( optional.isPresent()) {
			return optional.get();
			
		}else {
			return null;
			
		}
		
		
	}

	@Override
	public Vendor getVendorByEmailDao(String email) {
		
		return VendorRepo.findByEmail(email);
	}

	@Override
	public List<Vendor> getVendorDao() {
		
		return VendorRepo.findAll();
	}

	@Override
	public Vendor updateVendorByEmailDao(Vendor vendor) {
		Vendor vendor2=getVendorByEmailDao(vendor.getEmail());
		if(vendor2 != null) {
			return VendorRepo.save(vendor);
			
		}
		return null;
	}

	@Override
	public Vendor deleteVendorByEmailDao(String email) {
		Vendor vendor=getVendorByEmailDao(email);
		if (vendor != null) {
			VendorRepo.delete(vendor);
			return null;
		}
		return vendor;
	}

	@Override
	public Vendor vendorVerifyByIdDao(int id) {
		
		String adminEmail=(String) httpSession.getAttribute("adminEmail");
		
		Vendor vendor=getVendorByIdDao(id);
		
		Admin admin=adminRepo.findByEmail(adminEmail);
		
		if(vendor!=null) {
			vendor.setVendorStatus("active");
			vendor.setAdmin(admin);
			return VendorRepo.save(vendor);
			
			
		}
		return null;
	}

}
