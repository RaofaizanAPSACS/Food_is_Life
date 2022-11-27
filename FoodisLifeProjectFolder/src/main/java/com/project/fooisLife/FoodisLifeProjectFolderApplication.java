package com.project.fooisLife;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class FoodisLifeProjectFolderApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FoodisLifeProjectFolderApplication.class, args);
	}
	@Autowired
	private DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {
		String sqlQuery = "call CreateTables();";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(sqlQuery);
	}

}
