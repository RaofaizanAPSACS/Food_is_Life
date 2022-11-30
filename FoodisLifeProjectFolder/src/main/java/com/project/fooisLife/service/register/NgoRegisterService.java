package com.project.fooisLife.service.register;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Admin;
import com.project.fooisLife.repository.register.NgoRegisterRepository;

@Service
public class NgoRegisterService {
	
	@Autowired
	private NgoRegisterRepository ngoRegisterRepository;
	
	
	public boolean registerNgoService(Admin admin, String name, String address, String city, String state, String phone,
			String email, String hours) {
		try {
			return ngoRegisterRepository.registerNGOInfo(admin, name, address, city, state, phone, email, hours);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
