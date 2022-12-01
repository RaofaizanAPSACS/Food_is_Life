package com.project.fooisLife.controller.foodItems;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.FoodItem;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RestaurantFoodItemController {
	
	//@RequestBody List<FoodItem> foodItems,
	@GetMapping("/addFoodItems")
	public String addFoodItems( HttpServletRequest req ) {
		Cookie cookies[] = req.getCookies();
		
		for( Cookie c : cookies) {
			if(c.getName().equals("email") || c.getName().equals("password"))
				System.out.println("Cookie 1 value : " + c.getName() +" : "+ c.getValue());
		}
		return "Food items";
	}
}
