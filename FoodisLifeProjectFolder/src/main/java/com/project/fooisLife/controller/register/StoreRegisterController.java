package com.project.fooisLife.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.Restaurant;
import com.project.fooisLife.service.register.StoreRegisterService;

@RestController
public class StoreRegisterController {
	@Autowired
	private StoreRegisterService storeRegisterService;
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to Food is Life Application";
	}
	
	@PostMapping("/registerStore")
	public String registerStore(@RequestBody Restaurant restaurant){
		boolean isRegistered = storeRegisterService.registerStoreService(restaurant.getBranch(), restaurant.getAdmin());
		
		if(isRegistered) {
			return "Already have an account. Go for Login!";
		}
		return "Successfully Registered";
	}
	
	
}
