package com.jsp.medishop.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class OrderEntity {
	

	@Id
	private long orderId;
	private LocalDate estimateDeliveryDate;
	private LocalDate customerDeliveryDate;
	private LocalDate orderDate;
	private String orderStatus="panding";
	private double totalAmount;
	private String deliveryAddress;
	private String paymentMode;
	private int quantity;
	
	
	@OneToOne
	private Vendor vender;
	@OneToOne
	private Medicine medicine;
	@OneToOne
	private Customer customer;

}
