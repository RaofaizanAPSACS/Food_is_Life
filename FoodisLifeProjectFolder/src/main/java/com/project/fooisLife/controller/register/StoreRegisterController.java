package com.project.fooisLife.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.Restaurant;
import com.project.fooisLife.service.register.StoreRegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
public class StoreRegisterController {
	@Autowired
	private StoreRegisterService storeRegisterService;
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to Food is Life Application";
	}
	
	@PostMapping("/registerStore")
	public String registerStore(@RequestBody Restaurant restaurant){
		int isRegistered = storeRegisterService.registerStoreService(restaurant.getBranch(), restaurant.getAdmin());
		
		if(isRegistered == 1) 
			return "Already have an account. Go for Login!";
		else if(isRegistered == 0)
			return "Successfully Registered";
		else 
			return "Account already exists with same Admin Email";
	}
	
	
}
