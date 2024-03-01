package com.jsp.medishop.dto;

import java.util.List;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	private int id;
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private String dob;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(length = 8)
	private String password;
	private String address;
	private long phone;
	@Column(unique = true, nullable = true, length = 12)
	private long adhar;
	
	
	@Transient
	@Lob
	private long[] image;
	
	@ManyToMany
	private List<Medicine> medicines;
	
	
	
	 
	

}
