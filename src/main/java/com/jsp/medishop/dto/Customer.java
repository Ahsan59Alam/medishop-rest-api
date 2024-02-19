package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	private int id;
	private String name;
	private LocalDate dob;
	private String email;
	private String password;
	private String address;
	private long phone;
	
	@ManyToMany(mappedBy = "Customer")
	private List<Vendor> vendors;
	
	
	
	
	

}
