package com.slokam.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slokam.order.dao.OrderDao;
import com.slokam.order.entity.Order;

@Service
public class OrderService {
    
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public void saveOrder(Order order) {
		orderDao.save(order);
	}
	
	@Transactional
	public void updateOrder(Order order) {
		orderDao.save(order);
	}
	
	@Transactional
	public void deleteOrder(Order order) {
		orderDao.delete(order);;
	}
	
	public Order getByIdOrder(Integer id) {
		
		return orderDao.findOne(id);
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
}
