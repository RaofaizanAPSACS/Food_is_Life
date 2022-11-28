package com.project.fooisLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Admin;
import com.project.fooisLife.repository.NgoRegisterRepository;

@Service
public class NgoRegisterService {
	
	@Autowired
	private NgoRegisterRepository ngoRegisterRepository;
	
	
	public void registerNgoService(Admin admin, String name, String address, String city, String state, String phone,
			String email, String hours) {
		ngoRegisterRepository.registerNGOInfo(admin, name, address, city, state, phone, email, hours);
	}
}
