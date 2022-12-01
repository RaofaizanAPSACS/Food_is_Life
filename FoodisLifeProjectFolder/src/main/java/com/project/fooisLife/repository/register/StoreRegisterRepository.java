package com.project.fooisLife.repository.register;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.config.EncryptDecrypt;

@Repository
public class StoreRegisterRepository{
	
	@Autowired
	private DataSource dataSource;
	
	private CallableStatement callableStatement;
	
	 public int registerStoreInfo(int bid, String name, String address, String city, String email, String hours,
			 String phone, String state, String username,String password, String adminEmail, String adminPhone ) throws SQLException {
		 
		 	EncryptDecrypt encrypt = new EncryptDecrypt();
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call RegisterRestaurantStore(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			callableStatement.setString(1, name);
			callableStatement.setInt(2, bid);
			callableStatement.setString(3, address);
			callableStatement.setString(4, city);
			callableStatement.setString(5, state);
			callableStatement.setString(6, phone);
			callableStatement.setString(7, email);
			callableStatement.setString(8, hours);
			callableStatement.setString(9, username);
			callableStatement.setString(10, encrypt.encrypt(password, "FAST"));
			callableStatement.setString(11, adminPhone);
			callableStatement.setString(12, adminEmail);
			callableStatement.registerOutParameter(13, Types.BOOLEAN);
			callableStatement.registerOutParameter(14, Types.BOOLEAN);
			callableStatement.executeUpdate();
			
			boolean val1 = callableStatement.getBoolean(13);
			boolean val2 = callableStatement.getBoolean(14);
			
			// close connection
			callableStatement.getConnection().close();
			
			if(val1)
				return 1;
			else if(val2)
				return 2;
			else
				return 0;
	 }
}






