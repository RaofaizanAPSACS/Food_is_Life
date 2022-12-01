package com.project.fooisLife.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.entity.Login;
import com.project.fooisLife.service.login.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class StoreLoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/StoreLogin")
	public String loginNGO(@RequestBody Login login, HttpServletRequest req, HttpServletResponse res) {
		
		// adding session management for login details
		Cookie cookie1 = new Cookie("email", login.getUsername());
		Cookie cookie2 = new Cookie("password", login.getPassword());
		
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		
		if(loginService.signInStore(login))
			return "Logged In";
		return "Wrong Credentials";
	}
}
