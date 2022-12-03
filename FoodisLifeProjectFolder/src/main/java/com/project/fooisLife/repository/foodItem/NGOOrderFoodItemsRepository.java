package com.project.fooisLife.repository.foodItem;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.entity.FoodItemCard;
import com.project.fooisLife.mapper.FoodItemCardRowMapper;

@Repository
public class NGOOrderFoodItemsRepository {

	@Autowired
	private DataSource dataSource;
	
	CallableStatement callableStatement;
	
	public List<FoodItemCard> orderFoodItemsRepository() throws SQLException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
		return jdbcTemplate.query("call fetchLeftoversDetails();", new FoodItemCardRowMapper());
	}
}
