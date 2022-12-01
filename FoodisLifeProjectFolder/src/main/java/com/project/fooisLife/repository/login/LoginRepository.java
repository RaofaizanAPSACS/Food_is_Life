package com.project.fooisLife.repository.login;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.config.EncryptDecrypt;
import com.project.fooisLife.entity.Login;

@Repository
public class LoginRepository {
	
	@Autowired
	private DataSource dataSource;
	 
	private CallableStatement callableStatement;
	
	public Boolean fetchNGOLoginDetails(Login login) throws SQLException {
		
		EncryptDecrypt encrypt = new EncryptDecrypt();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call fetchNGOLogin(?, ?, ?)}");
		callableStatement.setString(1, login.getUsername());
		callableStatement.setString(2, encrypt.encrypt(login.getPassword(),"FAST"));
		callableStatement.registerOutParameter(3, Types.INTEGER);
		callableStatement.executeUpdate();
		
		int val = callableStatement.getInt(3);
		// close connection
		callableStatement.getConnection().close();
		
		if(val == 1)
			return true;
		return false;
	}

	public Boolean fetchStoreLoginDetails(Login login) throws SQLException {
		
		EncryptDecrypt encrypt = new EncryptDecrypt();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call fetchStoreLogin(?, ?, ?)}");
		callableStatement.setString(1, login.getUsername());
		callableStatement.setString(2, encrypt.encrypt(login.getPassword(),"FAST"));
		callableStatement.registerOutParameter(3, Types.INTEGER);
		callableStatement.executeUpdate();
		
		int val = callableStatement.getInt(3);
		// close connection
		callableStatement.getConnection().close();
		
		if(val == 1)
			return true;
		return false;
	}
}