package com.project.fooisLife.repository.foodItem;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.entity.FoodItem;
import com.project.fooisLife.entity.utilClasses.DisplayFoodItemUtil;
import com.project.fooisLife.mapper.displayFoodItemRowMapper;

@Repository
public class RestaurantFoodItemRepository {
	
	@Autowired
	private DataSource dataSource;
	
	CallableStatement callableStatement;
	
	
	// private method to get the next item index of food items of particular branch of restaurant
	private int getAddIndex(String email) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call getAddFoodItemNextIndex(?, ?)}");
		callableStatement.setString(1, email);
		callableStatement.registerOutParameter(2, Types.INTEGER);
		callableStatement.executeUpdate();
		int val = callableStatement.getInt(2); 
		
		callableStatement.getConnection().close();
		return val;
	}
	
	public boolean addRestaurantFoodItemsRepository(List<FoodItem> foodItems, String email) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int index = getAddIndex(email);
		
		
		for(FoodItem item : foodItems) {
			
			callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call addStoreFoodItems(?, ?, ?, ?)}");
			callableStatement.setInt(1, ++index);
			callableStatement.setString(2, item.getItemName());
			callableStatement.setString(3, item.getItemDescription());
			callableStatement.setString(4, email);
			callableStatement.executeUpdate();
		}
		
		callableStatement.getConnection().close();
		return true;
	}

	public List<DisplayFoodItemUtil> displayFoodItemsRepository(String email) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		return jdbcTemplate.query("call displayFoodItems(?, ?);", new Object[] {email, status}, new displayFoodItemRowMapper());
		
	}
}
