package com.project.fooisLife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.model.RestaurantModel;
import com.project.fooisLife.service.StoreService;

@RestController
public class StoreRegisterController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Food is Life Application";
	}
	
	@GetMapping("/registerStore")
	public String registerStore(@RequestParam RestaurantModel resModel){
		return "Successfully Registered";
	}
	
	
}
