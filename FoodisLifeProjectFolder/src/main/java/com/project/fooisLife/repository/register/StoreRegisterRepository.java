package com.project.fooisLife.repository.register;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.config.EncryptDecrypt;

@Repository
public class StoreRegisterRepository{
	
	@Autowired
	private DataSource dataSource;
	
	 public void registerStoreInfo(int bid, String name, String address, String city, String email, String hours,
			 String phone, String state, String username,String password, String adminEmail, String adminPhone ) {
		 
		 	EncryptDecrypt encrypt = new EncryptDecrypt();
			
		 	String sqlQuery = "call RegisterRestaurantStore('" + name +"', '"+bid+"', '"+address+"', '"+city+"', '"+state+"', '"+
		 	phone+"', '"+email+"', '"+hours+"', '"+username+"' , '"+encrypt.encrypt(password, "FAST") +"', '"+adminEmail+"', '"+ adminPhone+"')";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.execute(sqlQuery);
	 }
	
	
}
