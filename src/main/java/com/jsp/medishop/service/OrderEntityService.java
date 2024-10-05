package com.jsp.medishop.service;

import org.springframework.stereotype.Service;

import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;

@Service
public interface OrderEntityService {
	
	public ResponseStructure<OrderEntity> saveOrderEntityService(OrderEntity entity, int medicineId);
	
	public ResponseStructure<OrderEntity> getOrderEntityByidService(int orderId);

}
