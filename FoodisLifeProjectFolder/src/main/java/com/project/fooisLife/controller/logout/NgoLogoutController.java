package com.project.fooisLife.controller.logout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/NGO")
public class NgoLogoutController {
	
	@GetMapping("/logout")
	public void StoreLogout(HttpServletResponse res) {
		CookieSession cookie = new CookieSession();
		cookie.deleteCookies(res, "NgoEmail" , "NgoPassword");
	}
}