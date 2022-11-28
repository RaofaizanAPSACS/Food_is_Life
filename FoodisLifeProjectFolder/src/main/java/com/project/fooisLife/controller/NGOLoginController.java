package com.project.fooisLife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.LoginService;

@RestController
public class NGOLoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/NGOLogin")
	public String loginNGO(@RequestBody Login login) {
		if(loginService.signInNGO(login))
			return "Logged In";
		return "Wrong Credentials";
	}
}
