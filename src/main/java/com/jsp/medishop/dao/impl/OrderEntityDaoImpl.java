package com.jsp.medishop.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.medishop.dao.OrderEntityDao;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.repository.OrderEntityRepository;


@Repository
public class OrderEntityDaoImpl implements OrderEntityDao{

	@Autowired
	private OrderEntityRepository entityRepo;
	
	@Override
	public OrderEntity saveEntityOrderDao(OrderEntity entity) {
		
		return entityRepo.save(entity);
	}

	@Override
	public OrderEntity getOrderEntityByIdDao(long orderId) {
		Optional<OrderEntity> optional = entityRepo.findById(orderId);
		return (optional.isPresent())?optional.get():null;
	}

}
