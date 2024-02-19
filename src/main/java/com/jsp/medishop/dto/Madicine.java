package com.jsp.medishop.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Madicine {
	
	@Id
	private int id;
	private String name;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDate expiryDate;
	private String companyName;
	private int quantity;
	private double price;
	private String description;
	
	@ManyToMany(mappedBy = "medicines")
	private List<Vendor> vendors;
	
	

}
