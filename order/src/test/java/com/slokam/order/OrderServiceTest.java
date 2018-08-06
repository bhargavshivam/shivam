package com.slokam.order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slokam.order.entity.Order;
import com.slokam.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class OrderServiceTest {

	@Autowired
	OrderService orderService;
	
	@Test
	public void verifyOrderDetails() {
		
		Order order1=new Order();
		order1.setName("order1");
		order1.setType("type1");
		order1.setCust("cust2");
		
		orderService.saveOrder(order1);
		
		Order order=orderService.getByIdOrder(1);
		
		Assert.assertEquals(order1.getName(),order.getName() );
		
	}
}
