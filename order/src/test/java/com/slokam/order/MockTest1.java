package com.slokam.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.slokam.order.dao.OrderDao;
import com.slokam.order.entity.Order;
import com.slokam.order.service.OrderService;

@RunWith(SpringRunner.class)
public class MockTest1 {

	
	@TestConfiguration
    static class OrderServiceImplTestContextConfiguration {
  
        @Bean
        public OrderService orderService() {
            return new OrderService();
        }
    }
 
    @Autowired
    private OrderService orderService;
 
    @MockBean
    private OrderDao oderDao;
    
    @Before
    public void setUp() {
    	Order order = new Order();
    	//order.setId(1);
    	order.setName("order1");
    	order.setType("sam1");
    	order.setCust("cust1");
     
        Mockito.when(oderDao.findOne(1))
          .thenReturn(order);
    }
    
    
    @Test
    public void whenValidId_thenOrderShouldBeFound() {
        String name = "order1";
        Order order = orderService.getByIdOrder(1);
        
        Assert.assertEquals(name,order.getName());
     }
    
    
    
    
    
    
    
    
    
}
