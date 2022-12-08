package com.project.fooisLife.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.fooisLife.entity.utilClasses.DisplayFoodItemUtil;

public class displayFoodItemRowMapper implements RowMapper<DisplayFoodItemUtil>{

	@Override
	public DisplayFoodItemUtil mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		DisplayFoodItemUtil item = new DisplayFoodItemUtil();
		item.setItemID(rs.getInt("id"));
		item.setItemName(rs.getString("item_name"));
		item.setItemDesc(rs.getString("item_description"));
		item.setResName(rs.getString("name"));
		
		return item;
	}

}
