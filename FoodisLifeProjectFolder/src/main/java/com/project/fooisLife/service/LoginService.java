package com.project.fooisLife.service;

import com.project.fooisLife.entity.Login;

public interface LoginService {
	
	public boolean signInNGO(Login login);
	public boolean signInStore(Login login);
}
