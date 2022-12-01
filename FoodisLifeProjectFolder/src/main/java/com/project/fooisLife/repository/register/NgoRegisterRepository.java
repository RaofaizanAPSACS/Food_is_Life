package com.project.fooisLife.repository.register;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.config.EncryptDecrypt;
import com.project.fooisLife.entity.Admin;

@Repository
public class NgoRegisterRepository {
	@Autowired
	private DataSource dataSource;
	
	private CallableStatement callableStatement;

	public boolean registerNGOInfo(Admin admin, String name, String address, String city, String state, String phone,
			String email, String hours) throws SQLException {
		
		EncryptDecrypt encrypt = new EncryptDecrypt();
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call RegisterNGO(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		callableStatement.setString(1, name);
		callableStatement.setString(2, address);
		callableStatement.setString(3, city);
		callableStatement.setString(4, state);
		callableStatement.setString(5, phone);
		callableStatement.setString(6, email);
		callableStatement.setString(7, hours);
		callableStatement.setString(8, admin.getUsername());
		callableStatement.setString(9, encrypt.encrypt(admin.getPassword(), "FAST"));
		callableStatement.setString(10, admin.getPhone());
		callableStatement.setString(11, admin.getEmail());
		callableStatement.registerOutParameter(12, Types.BOOLEAN);
		callableStatement.executeUpdate();
		
		
		boolean val = callableStatement.getBoolean(12);
		// close connection
		callableStatement.getConnection().close();
		if(val)
			return true;
		return false;
	}
}
