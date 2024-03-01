package com.jsp.medishop.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.VendorDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.Vendor;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MedicineService;

import jakarta.servlet.http.HttpSession;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private MedicineDao dao;
	
	@Autowired
	private ResponseStructure<Medicine> resStructure;
	
	@Autowired
	private ResponseStructure<List<Medicine>> resStructure2;

	@Override
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine) {
		String email=(String)httpSession.getAttribute("vendorEmail");
		
		if(email!=null) {
			Vendor vendor=vendorDao.getVendorByEmailDao(email);
			medicine.setVendors(new ArrayList<Vendor>(Arrays.asList(vendor)));
					
			Medicine medicine2=dao.saveMedicineDao(medicine);

			if (medicine2 !=null) {
				resStructure.setStatus(HttpStatus.ACCEPTED.value());
				resStructure.setMsg("medicine addedd");
				resStructure.setData(medicine2);
			}else {
				resStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
				resStructure.setMsg("Data is not stored check your code");
				resStructure.setData(null);
			}
		}else {
			resStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			resStructure.setMsg("please login with vendor and then add medicine....");
			resStructure.setData(null);
		}
		
		return resStructure;
	}

	@Override
	public ResponseStructure<List<Medicine>> getAllMedicineService() {
		List<Medicine> medicine=dao.getAllMedicineDao();
		if (!medicine.isEmpty()) {
			resStructure2.setStatus(HttpStatus.OK.value());
			resStructure2.setMsg("---Data------Found----");
			resStructure2.setData(medicine);
		}else {
			resStructure2.setStatus(HttpStatus.NOT_FOUND.value());
			resStructure2.setMsg("Data is not found might be table is empty or check your code");
			resStructure2.setData(medicine);
		}
		return resStructure2;
	}

	@Override
	public ResponseEntity<String> verifyMedicineStatusByAdminService(int medicineId, int vendodId) {
		String adminEmail=(String) httpSession.getAttribute("adminEmail");
		
		
		if(adminEmail!=null) {
			
			Vendor vendor=vendorDao.getVendorByIdDao(vendodId);
			
			if(vendor!=null) {
				List<Medicine> medicines=vendor.getMedicines();
				
				if(medicines.isEmpty()) {
					for(Medicine medicine: medicines) {
						if(medicine.getId()==medicineId) {
							medicine.setMedicine_status("active");
							boolean b=dao.verifyMedicineStatusByAdminDao(medicine);
							
							return (b)?new ResponseEntity<String> ("medicine--verified",HttpStatusCode.valueOf(200)):new ResponseEntity<String>("not---verified", HttpStatusCode.valueOf(404));
						}
					}
				}
			}
			
		}
		return new ResponseEntity<String>("please login as admin then verified", HttpStatusCode.valueOf(200));
	}

	@Override
	public ResponseStructure<List<Medicine>> getAllMedicineByNameService(String name) {
		String customerEmail=(String) httpSession.getAttribute("customerEmail");
		String vendorEmail= (String) httpSession.getAttribute("vendorEmail");
		String adminEmail= (String) httpSession.getAttribute("adminEmail");
				
		if((customerEmail!=null)||(vendorEmail!=null)|(adminEmail!=null)) {
			
			List<Medicine> medicines=dao.getAllMedicineByNameDao(name);
			
			if(!medicines.isEmpty()) {
				resStructure2.setMsg("medicine are not available");
				resStructure2.setStatus(HttpStatus.FOUND.value());
				resStructure2.setData(medicines);
			}else {
				
				resStructure2.setMsg("find below medicine details");
				resStructure2.setStatus(HttpStatus.NOT_FOUND.value());
				resStructure2.setData(medicines);
			}
		}else {
			
			resStructure2.setMsg("please login and then search");
			resStructure2.setStatus(HttpStatus.FOUND.value());
			resStructure2.setData(null);
		}
				
				
				
		return resStructure2;
	}
	

}
