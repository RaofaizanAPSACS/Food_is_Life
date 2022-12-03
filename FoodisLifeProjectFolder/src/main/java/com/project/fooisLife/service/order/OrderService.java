package com.project.fooisLife.service.order;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Cart;
import com.project.fooisLife.entity.Order;
import com.project.fooisLife.repository.order.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public boolean orderService(List<Cart> cart, Order order) {
		try {
			return orderRepository.orderRepository(cart, order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
