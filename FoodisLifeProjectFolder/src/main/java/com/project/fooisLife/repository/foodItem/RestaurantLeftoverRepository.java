package com.project.fooisLife.repository.foodItem;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.entity.Leftover;

@Repository
public class RestaurantLeftoverRepository {

	@Autowired
	private DataSource dataSource;
	
	CallableStatement callableStatement;
	
	public boolean addLeftoversRepository(List<Leftover> leftovers, String email) throws SQLException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println(email);
		
		for(Leftover leftover : leftovers) {
			
			callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call addLeftovers(?, ?, ?, ?)}");
			callableStatement.setInt(1, leftover.getItemID());
			callableStatement.setInt(2, leftover.getQuantity());
			callableStatement.setDate(3, leftover.getBestBefore());
			callableStatement.setString(4, email);
			callableStatement.executeUpdate();
		}
		
		callableStatement.getConnection().close();
		return true;
	}
}
