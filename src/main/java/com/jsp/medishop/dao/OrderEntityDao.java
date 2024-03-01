package com.jsp.medishop.dao;

import com.jsp.medishop.dto.OrderEntity;

public interface OrderEntityDao {
	
	public OrderEntity saveEntityOrderDao(OrderEntity entity);
	
	public OrderEntity getOrderEntityByIdDao(long orderId);
	

}
