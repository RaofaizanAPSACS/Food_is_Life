package com.project.fooisLife.controller.foodItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.Leftover;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.foodItem.RestaurantLeftoverService;
import com.project.fooisLife.service.login.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000" ,allowCredentials="true")
public class RestaurantLeftoverController {

	@Autowired
	private RestaurantLeftoverService restaurantLeftoverService; 
	
	@Autowired 
	private LoginService loginService;
	
	private boolean helperAddLeftovers(List<Leftover> leftover, String email) {
		return restaurantLeftoverService.addLeftoversService(leftover, email);
	}
//	@CrossOrigin(origins = "http://localhost:3000" )
	@PostMapping("/addLeftovers")
	public String addLeftovers(@RequestBody List<Leftover> leftovers, HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "StoreEmail");
		String password = cookie.getCookieValue(req, "StorePassword");
		
		
		if(loginService.signInStore(new Login(email, password))) {
			if(helperAddLeftovers(leftovers, email))
				return "Leftovers Added";
		}
		return "Session Logged Out";
	}
}
