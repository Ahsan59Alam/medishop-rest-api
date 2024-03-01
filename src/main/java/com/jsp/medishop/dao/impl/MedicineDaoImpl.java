package com.jsp.medishop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.repository.MedicineRepository;



@Repository
public class MedicineDaoImpl implements MedicineDao {
	
	
	@Autowired
	private MedicineRepository MedicineRepo;

	@Override
	public Medicine saveMedicineDao(Medicine medicine) {
		
		return MedicineRepo.save(medicine);
	}

	@Override
	public List<Medicine> getAllMedicineDao() {
		
		return MedicineRepo.findAll();
	}

	@Override
	public boolean verifyMedicineStatusByAdminDao(Medicine medicine) {
		
		return (MedicineRepo.save(medicine)!=null) ? true : false;
	}

	@Override
	public Medicine getMedicineByIdDao(int medicineId) {
		
		return MedicineRepo.findById(medicineId);
	}

	@Override
	public List<Medicine> getAllMedicineByNameDao(String name) {
		List<Medicine> medicines = MedicineRepo.findByName(name);
		List<Medicine> medicine2 = new ArrayList<Medicine>();
		
		for(Medicine medicine: medicines) {
			if(medicine.getMedicine_status().equalsIgnoreCase("active")) {
				
				medicine2.add(medicine);
			}
			
		}
		return medicine2;
	} 

	

	
}
