package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Medicine {
	
	@Id
	private int id;
	private String name;
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name = "expirydate")
	private LocalDate expiryDate;
	@Column(name = "companyname")
	private String companyName;
	private int quantity;
	private double price;
	@Column(length = 245)
	private String description;
	@Column(length = 8)
	private String medicine_status="inactive";
	
	
	@ManyToMany(mappedBy = "medicines")
	private List<Vendor> vendors;
	
	

}
