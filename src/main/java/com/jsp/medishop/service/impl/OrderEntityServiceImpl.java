package com.jsp.medishop.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.medishop.dao.CustomerDao;
import com.jsp.medishop.dao.MedicineDao;
import com.jsp.medishop.dao.OrderEntityDao;
import com.jsp.medishop.dto.Customer;
import com.jsp.medishop.dto.Medicine;
import com.jsp.medishop.dto.OrderEntity;
import com.jsp.medishop.response.ResponseStructure;
import com.jsp.medishop.service.OrderEntityService;

import jakarta.servlet.http.HttpSession;


@Service
public class OrderEntityServiceImpl implements OrderEntityService{

	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private OrderEntityDao entityDao;
	
	@Autowired
	private MedicineDao medicineDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ResponseStructure<OrderEntity> responseStructure;
	
	@Override
	public ResponseStructure<OrderEntity> saveOrderEntityService(OrderEntity entity, int medicineId) {
		
		String customerEmail =(String) httpSession.getAttribute("customerEmail");
		
		if(customerEmail!=null) {
			/**
			 * it will generate random 10 digits orderId
			 */
			long orderId= (long) (Math.floor(Math.random()* 9000000000L) + 1000000000);
			Medicine medicine=medicineDao.getMedicineByIdDao(medicineId);
			Customer customer=customerDao.getCustomerByEmailDao(customerEmail);
			entity.setCustomer(customer);
			entity.setMedicine(medicine);
			entity.setOrderId(orderId);
			entity.setOrderDate(LocalDate.now());
			/**
			 * this line will calculate final amount
			 */
			
			entity.setTotalAmount(medicine.getPrice()*entity.getQuantity());
			/**
			 * data calculation
			 */
			
			entity.setEstimateDeliveryDate(LocalDate.now().plusDays(4));
			
			
			if(entity.getCustomerDeliveryDate()==null) {
				entity.setCustomerDeliveryDate(entity.getEstimateDeliveryDate());
			}
			
			entityDao.saveEntityOrderDao(entity);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMsg("order placed successfully");
			responseStructure.setData(entity);
			
		}else {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMsg("please login and then order");
			responseStructure.setData(null);
			
		}
		
		return responseStructure;
	}

	@Override
	public ResponseStructure<OrderEntity> getOrderEntityByidService(int orderId) {
		
		return null;
	}

}
