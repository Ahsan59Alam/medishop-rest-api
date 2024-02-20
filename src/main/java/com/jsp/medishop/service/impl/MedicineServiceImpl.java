package com.jsp.medishop.service.impl;

import java.util.List;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MedicineService;


public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	private MedicineDao dao;
	
	@Autowired
	private ResponseStructure<Medicine> resStructure;
	
	@Autowired
	private ResponseStructure<List<Medicine>> resStructure2;

	@Override
	public ResponseStructure<Medicine> saveMedicineService(Medicine medicine) {
		Medicine medicine2=dao.saveMedicineDao(medicine);
		if (medicine2 !=null) {
			resStructure.setStatus(HttpStatus.ACCEPTED.value());
			resStructure.setMsg("Data Stored");
			resStructure.setData(medicine2);
		}else {
			resStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			resStructure.setMsg("Data is not stored check your code");
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
	

}