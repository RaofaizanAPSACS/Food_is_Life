package com.project.fooisLife.repository.register;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRegisterRepository{
	
	@Autowired
	private DataSource dataSource;
	
//	@Query(nativeQuery=true, value="call RegisterRestaurantStore(:resName, :bid, :address, :city, :state, :phone, :email, :openHours,"
//			+ ":username, :password, :adminPhone, :adminEmail);")
//	public void registerStoreInfo(@Param("bid") int bid, @Param("resName") String ResName, @Param("address") String address,
//			@Param("city") String city, @Param("email") String email, @Param("openHours") String openHours,
//			@Param("phone") String phone, @Param("state") String state, @Param("username") String username,
//			@Param("password") String password, @Param("adminEmail") String adminEmail, @Param("adminPhone") String adminPhone) {
//		
//	}
	
	 public void registerStoreInfo(int bid, String name, String address, String city, String email, String hours,
			 String phone, String state, String username,String password, String adminEmail, String adminPhone ) {
			
		 	String sqlQuery = "call RegisterRestaurantStore('" + name +"', '"+bid+"', '"+address+"', '"+city+"', '"+state+"', '"+
		 	phone+"', '"+email+"', '"+hours+"', '"+username+"' , '"+password+"', '"+adminEmail+"', '"+ adminPhone+"')";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.execute(sqlQuery);
	 }
	
	
}
