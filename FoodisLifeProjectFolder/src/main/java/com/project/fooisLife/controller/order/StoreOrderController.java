package com.project.fooisLife.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.fooisLife.config.CookieSession;
import com.project.fooisLife.entity.Login;
import com.project.fooisLife.entity.StoreOrder;
import com.project.fooisLife.service.login.LoginService;
import com.project.fooisLife.service.order.OrderService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/restaurant")
public class StoreOrderController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public List<StoreOrder> showOrders(HttpServletRequest req){
		CookieSession cookie = new CookieSession();
		String email = cookie.getCookieValue(req, "StoreEmail");
		String password = cookie.getCookieValue(req, "StorePassword");
		
		
		if(loginService.signInStore(new Login(email, password))) {
			return orderService.showOrders(email);
		}
		return null;
	}
}
