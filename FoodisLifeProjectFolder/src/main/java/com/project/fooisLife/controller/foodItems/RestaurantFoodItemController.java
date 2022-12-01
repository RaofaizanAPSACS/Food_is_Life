package com.project.fooisLife.controller.foodItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.FoodItem;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.foodItem.RestaurantFoodItemService;
import com.project.fooisLife.service.login.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RestaurantFoodItemController {
	
	@Autowired 
	private LoginService loginService;
	
	@Autowired
	private RestaurantFoodItemService restaurantFoodItemService;
	
	// helper private method
	private boolean helperAddfoodItems(List<FoodItem> foodItems, String email) {
		return restaurantFoodItemService.addRestaurantFoodItemsService(foodItems, email);
	}
	
	@PostMapping("/addFoodItems")
	public String addFoodItems(@RequestBody List<FoodItem> foodItems, HttpServletRequest req ) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "StoreEmail");
		String password = cookie.getCookieValue(req, "StorePassword");
		
		if(loginService.signInStore(new Login(email, password))) {
			if(helperAddfoodItems(foodItems, email))
				return "Food Items Added";
		}
		return "Session Logged Out";
	}
}
