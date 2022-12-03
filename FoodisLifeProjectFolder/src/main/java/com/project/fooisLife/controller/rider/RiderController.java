package com.project.fooisLife.controller.rider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.entity.Rider;
import com.project.fooisLife.entity.utilClasses.RiderEmailUpdate;
import com.project.fooisLife.service.login.LoginService;
import com.project.fooisLife.service.rider.RiderService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/NGO")
public class RiderController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RiderService riderService;

	@PostMapping("/addRiderDetails")
	public String addRiderDetails(@RequestBody List<Rider> rider, HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");

		if (loginService.signInNGO(new Login(email, password))) {
			if (riderService.addRiderDetailsService(rider, email))
				return "Rider Details Added";
		}
		return "Session Logged Out";
	}
	
	
	
	@PostMapping("/displayRiderDetails")
	public List<Rider> displayRiderDetails(HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");

		if (loginService.signInNGO(new Login(email, password))) {
			return riderService.displayRiderDetailsService(email);
		}
		return null;
	}
	
	
	@PostMapping("/updateRiderbyEmail")
	public String updateRiderEmail(@RequestBody RiderEmailUpdate updateRider,HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");

		if (loginService.signInNGO(new Login(email, password))) {
			if(riderService.updateRiderEmailService(updateRider))
				return "Updated";
		}
		return "Session Logged out";
	}
	
	@PostMapping("/updateRiderbyPhone")
	public String updateRiderPhone(@RequestBody RiderEmailUpdate updateRider,HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");

		if (loginService.signInNGO(new Login(email, password))) {
			if(riderService.updateRiderPhoneService(updateRider))
				return "Updated";
		}
		return "Session Logged out";
	}
	
	@PostMapping("/removeRiderDetails")
	public String removeRider(@RequestParam String cnic,HttpServletRequest req) {
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "NgoEmail");
		String password = cookie.getCookieValue(req, "NgoPassword");

		if (loginService.signInNGO(new Login(email, password))) {
			if(riderService.removeRiderService(cnic))
				return "Rider Removed";
		}
		return "Session Logged out";
	}
}