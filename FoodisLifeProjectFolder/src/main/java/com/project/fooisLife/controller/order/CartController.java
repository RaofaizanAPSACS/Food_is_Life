package com.project.fooisLife.controller.order;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.Cart;

@RestController
@RequestMapping("/NGO/Cart")
public class CartController {
	
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
}
