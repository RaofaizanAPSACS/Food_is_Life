package com.project.fooisLife.repository.register;

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

	public void registerNGOInfo(Admin admin, String name, String address, String city, String state, String phone,
			String email, String hours) {
		
		EncryptDecrypt encrypt = new EncryptDecrypt();
		
		String sqlQuery = "call RegisterNGO('" + name + "', '" + address + "', '" + city + "', '" + state + "', '"
				+ phone + "', '" + email + "', '" + hours + "', '" + admin.getUsername() + "' , '"
				+ encrypt.encrypt(admin.getPassword(), "FAST") + "', '" + admin.getEmail() + "', '" + admin.getPhone()
				+ "')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(sqlQuery);
	}
}
