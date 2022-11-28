package com.project.fooisLife.repository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.entity.Login;

@Repository
public class LoginRepository {
	
	@Autowired
	private DataSource dataSource;
	 
	private CallableStatement callableStatement;
	
	
	public Boolean fetchNGOLoginDetails(Login login) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call fetchNGOLogin(?, ?, ?)}");
		callableStatement.setString(1, login.getUsername());
		callableStatement.setString(2, login.getPassword());
		callableStatement.registerOutParameter(3, Types.INTEGER);
		callableStatement.executeUpdate();
		System.out.println("Result : "+callableStatement.getInt(3));
		
		if(callableStatement.getInt(3) == 1)
			return true;
		return false;
	}

	public Boolean fetchStoreLoginDetails(Login login) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call fetchStoreLogin(?, ?, ?)}");
		callableStatement.setString(1, login.getUsername());
		callableStatement.setString(2, login.getPassword());
		callableStatement.registerOutParameter(3, Types.INTEGER);
		callableStatement.executeUpdate();
		
		if(callableStatement.getInt(3) == 1)
			return true;
		return false;
	}
}