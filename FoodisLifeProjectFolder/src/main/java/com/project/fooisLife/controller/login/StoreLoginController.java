package com.project.fooisLife.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.login.LoginService;

@RestController
public class StoreLoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/StoreLogin")
	public String loginNGO(@RequestBody Login login) {
		if(loginService.signInStore(login))
			return "Logged In";
		return "Wrong Credentials";
	}
}
