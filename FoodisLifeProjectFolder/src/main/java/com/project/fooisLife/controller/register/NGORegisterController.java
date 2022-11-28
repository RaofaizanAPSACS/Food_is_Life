package com.project.fooisLife.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.NGO;
import com.project.fooisLife.service.register.NgoRegisterService;

@RestController
public class NGORegisterController {
	@Autowired
	private NgoRegisterService ngoRegisterService;
	
	@PostMapping("/NgoRegistration")
	public String registerNGO(@RequestBody NGO ngo) {
		
		ngoRegisterService.registerNgoService(ngo.getAdmin(), ngo.getName(), ngo.getAddress(), ngo.getCity(), ngo.getState(),
				ngo.getPhone(), ngo.getEmail(), ngo.getOpenHours());
		return "Registered Successfully";
	}
}
