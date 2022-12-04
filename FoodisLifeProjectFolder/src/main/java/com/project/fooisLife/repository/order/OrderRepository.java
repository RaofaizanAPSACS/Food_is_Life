package com.project.fooisLife.repository.order;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.entity.Cart;
import com.project.fooisLife.entity.Order;
import com.project.fooisLife.entity.StoreOrder;
import com.project.fooisLife.mapper.StoreOrderRowMapper;

@Repository
public class OrderRepository {
	@Autowired
	private DataSource dataSource;
	
	CallableStatement callableStatement;
	
	public boolean orderRepository(List<Cart> cart, Order order) throws SQLException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call bookOrder(?, ?, ?, ?, ?, ?)}");
		callableStatement.setDate(1, order.getOrderTime());
		callableStatement.setString(2, order.getOrderStatus());
		callableStatement.setDate(3, order.getPickupTime());
		callableStatement.setString(4, cart.get(0).getStoreName());
		callableStatement.setInt(5, cart.get(0).getBid());
		callableStatement.setString(6, order.getRider_cnic());
		callableStatement.executeUpdate();
		
		for( Cart c : cart) {
			callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call addOrderItems(?, ?, ?)}");
			callableStatement.setInt(1, c.getItemID());
			callableStatement.setString(2,c.getStoreName());
			callableStatement.setInt(3, c.getBid());
			callableStatement.executeUpdate();
		}
		
		
		// close connection
		callableStatement.getConnection().close();
		return true;
	}

	public List<StoreOrder> showOrdersRepository(String email) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		return jdbcTemplate.query("call showStoreOrders(?);",new Object[] {email}, new StoreOrderRowMapper());
	}
}
