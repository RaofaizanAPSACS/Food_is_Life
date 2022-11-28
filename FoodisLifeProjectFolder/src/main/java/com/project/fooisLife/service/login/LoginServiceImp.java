package com.project.fooisLife.service.login;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Login;
import com.project.fooisLife.repository.login.LoginRepository;

@Service
public class LoginServiceImp implements LoginService{
	@Autowired
	private LoginRepository loginRepository;
	
	public boolean signInNGO(Login login) {
		try {
			return loginRepository.fetchNGOLoginDetails(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean signInStore(Login login) {
		try {
			return loginRepository.fetchStoreLoginDetails(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
