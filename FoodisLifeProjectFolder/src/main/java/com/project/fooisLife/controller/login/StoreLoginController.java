package com.project.fooisLife.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.login.LoginService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000" ,allowCredentials="true")
public class StoreLoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/StoreLogin")
	public String loginNGO(@RequestBody Login login, HttpServletResponse res) {
		
		CookieSession cookie = new CookieSession();
		cookie.setCookieForLogin(login, res, "StoreEmail", "StorePassword");
		
		if(loginService.signInStore(login))
			return "Logged In";
		return "Wrong Credentials";
	}
}
