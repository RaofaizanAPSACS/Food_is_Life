package com.project.fooisLife.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.fooisLife.entity.Branch;
import com.project.fooisLife.entity.FoodItem;
import com.project.fooisLife.entity.FoodItemCard;
import com.project.fooisLife.entity.Leftover;

public class FoodItemCardRowMapper implements RowMapper<FoodItemCard>{

	@Override
	public FoodItemCard mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FoodItemCard card = new FoodItemCard();
		card.setBranch(new Branch(rs.getString("name"), rs.getString("address"), rs.getString("city"), rs.getString("state"),
				rs.getString("phone"), rs.getString("email"), rs.getString("openingHours")));
		card.getBranch().setBid(rs.getInt("bid"));
		card.setFoodItem(new FoodItem(rs.getString("item_name"), rs.getString("item_description")));
		card.setLeftover(new Leftover(rs.getInt("item_id"), rs.getInt("quantity"), rs.getDate("best_before")));
		
		return card;
	}

}



