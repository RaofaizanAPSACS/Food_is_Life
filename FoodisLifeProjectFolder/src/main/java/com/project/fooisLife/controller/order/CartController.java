package com.project.fooisLife.controller.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.Cart;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.entity.Order;
import com.project.fooisLife.service.login.LoginService;
import com.project.fooisLife.service.order.OrderService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/NGO/Cart")
public class CartController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private LoginService loginService;
	// storing cart items temporarily
	private ArrayList<Cart> cart;
	
	public CartController() {
		cart = new ArrayList<Cart>();
	}
	@PostMapping("/addToCart")
	public void addToCart(@RequestBody Cart item) {
		cart.add(item);
	}
	
	@GetMapping("/fetchCartItems")
	public ArrayList<Cart> fetchCartItems() {
		return cart;
	}
	
	@PostMapping("/order")
	public String order(@RequestBody Order order, HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");
		
		
		if(loginService.signInNGO(new Login(email, password))) {
			if(orderService.orderService(cart, order))
				cart.clear();
				return "Order Booked";
		}
		return "Session Logged out";
	}
}
