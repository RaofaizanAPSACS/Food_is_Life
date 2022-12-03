package com.project.fooisLife.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.fooisLife.entity.Order;
import com.project.fooisLife.entity.Rider;
import com.project.fooisLife.entity.StoreOrder;

public class StoreOrderRowMapper implements RowMapper<StoreOrder>{

	@Override
	public StoreOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		StoreOrder storeOrder = new StoreOrder();
		Rider rider = new Rider();
		rider.setCnic(rs.getString("cnic"));
		rider.setName(rs.getString("rider_name"));
		rider.setPhone(rs.getString("phone"));
		
		Order order = new Order();
		order.setOrderStatus(rs.getString("order_status"));
		order.setOrderTime(rs.getDate("order_time"));
		order.setPickupTime(rs.getDate("pickup_time"));
		
		storeOrder.setOrder_id(rs.getInt("order_id"));
		storeOrder.setNgoName(rs.getString("NgoName"));
		storeOrder.setRider(rider);
		storeOrder.setOrder(order);
		return storeOrder;
	}
	
}
