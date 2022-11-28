package com.project.fooisLife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.NGO;
import com.project.fooisLife.service.StoreRegisterService;

@RestController
public class NGORegisterController {
	@Autowired
	private StoreRegisterService storeRegisterService;
	
	@GetMapping("/NgoRegistration")
	public String registerNGO(@RequestBody NGO ngo) {
		
		return null;
	}
	
	
}
