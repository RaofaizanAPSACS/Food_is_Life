package com.project.fooisLife.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Login;
import com.project.fooisLife.repository.LoginRepository;

@Service
public class LoginServiceImp implements LoginService{
	@Autowired
	private LoginRepository loginRepository;
	
	private Login fetchedCredentials;
	
	public boolean signInNGO(Login login) {
		
		try {
			fetchedCredentials = loginRepository.fetchNGOLoginDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( (fetchedCredentials.getUsername().equals(login.getUsername())) &&
				(fetchedCredentials.getPassword().equals(login.getPassword()) ) )
			return true;
		
		return false;
		
	}
	
	public boolean signInStore(Login login) {
		
		try {
			fetchedCredentials = loginRepository.fetchStoreLoginDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( (fetchedCredentials.getUsername().equals(login.getUsername())) &&
				(fetchedCredentials.getPassword().equals(login.getPassword()) ) )
			return true;
		
		return false;
	}
}
