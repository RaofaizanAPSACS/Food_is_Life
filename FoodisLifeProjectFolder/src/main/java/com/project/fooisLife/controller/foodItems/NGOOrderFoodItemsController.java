package com.project.fooisLife.controller.foodItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.FoodItemCard;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.foodItem.NGOOrderFoodItemsService;
import com.project.fooisLife.service.login.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/NGO")
@CrossOrigin(origins = "http://localhost:3000" ,allowCredentials="true")
public class NGOOrderFoodItemsController {
	
	@Autowired
	private NGOOrderFoodItemsService nGOOrderFoodItemsService; 
	
	@Autowired 
	private LoginService loginService;
	
	@GetMapping("/OrderFoodItems")
	public List<FoodItemCard> orderFoodItems(HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");
		
		
		if(loginService.signInNGO(new Login(email, password))) {
			return nGOOrderFoodItemsService.orderFoodItemsService();
		}
		return null;
	}
	
	@GetMapping("/searchFoodByStore")
	public List<FoodItemCard> searchFoodByStoreName(HttpServletRequest req, @RequestParam String name) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");
		
		
		if(loginService.signInNGO(new Login(email, password))) {
			return nGOOrderFoodItemsService.searchFoodByStoreNameService(name);
		}
		return null;
	}
	
	@GetMapping("/searchFoodByItem")
	public List<FoodItemCard> searchFoodByItemName(HttpServletRequest req, @RequestParam String name) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");
		
		
		if(loginService.signInNGO(new Login(email, password))) {
			return nGOOrderFoodItemsService.searchFoodByItemNameService(name);
		}
		return null;
	}
}
