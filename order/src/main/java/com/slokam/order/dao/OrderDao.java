package com.slokam.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.order.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer>{

}
