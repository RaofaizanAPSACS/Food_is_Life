package com.project.fooisLife.service.login;

import com.project.fooisLife.entity.Login;

public interface LoginService {
	
	public boolean signInNGO(Login login);
	public boolean signInStore(Login login);
}
