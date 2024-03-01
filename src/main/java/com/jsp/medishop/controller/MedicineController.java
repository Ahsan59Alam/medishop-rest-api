package com.jsp.medishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.MedicineService;

@RestController
@RequestMapping(value ="/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService mediService;
	
	@PostMapping(value ="/saveMedicine")
	public ResponseStructure<Medicine> saveMedicineController(@RequestBody Medicine medicine){
		return mediService.saveMedicineService(medicine);
	}
	
	
	@GetMapping(value="/getAllMedicineByName/{name}")
	public ResponseStructure<List<Medicine>> getAllMedicineByNameDao(@PathVariable String name){
		
		return mediService.getAllMedicineByNameService(name);
	}

}
