package com.jsp.medishop.dao;

import java.util.List;

import com.jsp.medishop.dto.Medicine;

public interface MedicineDao {

	public Medicine saveMedicineDao(Medicine medicine);
	
	public List<Medicine> getAllMedicineDao();
	

}
