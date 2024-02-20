package com.jsp.medishop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.repository.VendorRepository;

@Repository
class VenderDaoImpl implements VendorDao {
	
	@Autowired
	private VendorRepository VendorRepo;

	@Override
	public Vendor saveVendorDao(Vendor vendor) {
		
		return VendorRepo.save(vendor);
	}

	@Override
	public Vendor getVendorByIdDao(int id) {
		
		return VendorRepo.findById(id).get();
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

}
