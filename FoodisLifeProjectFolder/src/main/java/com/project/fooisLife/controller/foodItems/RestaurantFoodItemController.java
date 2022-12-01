package com.project.fooisLife.controller.foodItems;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.FoodItem;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RestaurantFoodItemController {
	
	//@RequestBody List<FoodItem> foodItems,
	@GetMapping("/addFoodItems")
	public String addFoodItems(HttpServletRequest req ) {
		CookieSession cookie = new CookieSession();
		
		System.out.println(cookie.getCookieValue(req, "StoreEmail"));
		return "Food items";
	}
}
