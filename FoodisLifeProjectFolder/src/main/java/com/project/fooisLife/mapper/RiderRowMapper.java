package com.project.fooisLife.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.fooisLife.entity.Rider;

public class RiderRowMapper implements RowMapper<Rider>{

	@Override
	public Rider mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Rider rider = new Rider();
		rider.setCnic(rs.getString("cnic"));
		rider.setEmail(rs.getString("email"));
		rider.setName(rs.getString("name"));
		rider.setPhone(rs.getString("phone"));
		return rider;
	}

}
