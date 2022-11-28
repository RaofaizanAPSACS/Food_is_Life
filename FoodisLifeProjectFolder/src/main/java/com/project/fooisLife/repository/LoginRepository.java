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
	
	@Autowired 
	private CallableStatement callableStatement;
	
	private Login login;
	
	public Login fetchNGOLoginDetails() throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call fetchNGOLogin(?, ?)}");
		callableStatement.registerOutParameter(1, Types.VARCHAR);
		callableStatement.registerOutParameter(2, Types.VARCHAR);
		callableStatement.executeUpdate();
		
		login.setUsername(callableStatement.getString(1));
		login.setPassword(callableStatement.getString(2));
		return login;
	}

	public Login fetchStoreLoginDetails() throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call fetchStoreLogin(?, ?)}");
		callableStatement.registerOutParameter(1, Types.VARCHAR);
		callableStatement.registerOutParameter(2, Types.VARCHAR);
		callableStatement.executeUpdate();
		
		login.setUsername(callableStatement.getString(1));
		login.setPassword(callableStatement.getString(2));
		return login;
	}
}
