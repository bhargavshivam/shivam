package com.slokam.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.order.entity.Order;
import com.slokam.order.service.OrderService;

@RestController
@Service
@RequestMapping("order")
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		ResponseEntity<String> re=new ResponseEntity<>("sucessfully saved",HttpStatus.CREATED);
		return re;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
		ResponseEntity<String> re=new ResponseEntity<>("sucessfully updated",HttpStatus.OK);
		return re;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id) {
		Order order=new Order();
		order.setId(id);
		orderService.deleteOrder(order);
		ResponseEntity<String> re=new ResponseEntity<>("sucessfully deleted",HttpStatus.OK);
		return re;
	}
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<Order> getByIdOrder(@PathVariable("id") Integer id) {
		Order order=orderService.getByIdOrder(id);
		ResponseEntity<Order> re=null;
		if(order==null)
		re=new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		else
		re=new ResponseEntity<Order>(order,HttpStatus.OK);
		
		return re;
	}
	
	@RequestMapping(value="/all" ,method=RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders=orderService.getOrders();
		System.out.println("in get all orders");
		ResponseEntity<List<Order>> re=new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		return re;
	}
}
