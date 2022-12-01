package com.project.fooisLife.controller.foodItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.FoodItem;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.foodItem.RestaurantFoodItemService;
import com.project.fooisLife.service.login.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RestaurantFoodItemController {
	
	@Autowired 
	private LoginService loginService;
	
	@Autowired
	private RestaurantFoodItemService restaurantFoodItemService;
	
	// helper private method
	private boolean helperAddfoodItems(List<FoodItem> foodItems) {
		return restaurantFoodItemService.addRestaurantFoodItemsService(foodItems);
	}
	
	@GetMapping("/addFoodItems")
	public String addFoodItems(@RequestBody List<FoodItem> foodItems, HttpServletRequest req ) {
		CookieSession cookie = new CookieSession();
		if(loginService.signInStore(new Login(cookie.getCookieValue(req, "StoreEmail"), cookie.getCookieValue(req, "StorePassword")))) {
			if(helperAddfoodItems(foodItems))
				return "Food Items Added";
		}
		return "Session Logged Out";
	}


}
