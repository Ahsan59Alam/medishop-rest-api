package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	private int id;
	private String name;
	private LocalDate dob;
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	@Column(length = 8)
	private String address;
	@Column(unique = true, nullable = true, length = 12)
	private long phone;
	
	@ManyToMany(mappedBy = "Customers")
	private List<Vendor> vendors;
	
	
	
	
	

}
