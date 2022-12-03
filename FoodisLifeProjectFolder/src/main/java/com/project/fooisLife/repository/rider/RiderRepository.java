package com.project.fooisLife.repository.rider;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.fooisLife.entity.Rider;
import com.project.fooisLife.entity.utilClasses.RiderEmailUpdate;
import com.project.fooisLife.mapper.RiderRowMapper;

@Repository
public class RiderRepository {
	@Autowired
	private DataSource dataSource;
	
	private CallableStatement callableStatement;
	
	
	public boolean addRiderDetailsRepository(List<Rider> riders, String email) throws SQLException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		for( Rider rider : riders) {
			callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call addRiderDetails(?, ?, ?, ?, ?)}");
			callableStatement.setString(1, rider.getCnic() );
			callableStatement.setString(2, rider.getName() );
			callableStatement.setString(3, rider.getPhone() );
			callableStatement.setString(4, rider.getEmail() );
			callableStatement.setString(5, email); 
			callableStatement.executeUpdate();
		}
		
		// close connection
		callableStatement.getConnection().close();
		
		return true;
	}

	public List<Rider> displayRiderDetailsRepository(String email){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		return jdbcTemplate.query("call displayRiderDetails(?)", new Object[] {email}, new RiderRowMapper());
	}

	public boolean updateRiderEmailRepository(RiderEmailUpdate updateRider) throws SQLException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call updateRiderByEmail(?, ?)}");
		callableStatement.setString(1, updateRider.getCnic() );
		callableStatement.setString(2, updateRider.getNewEmail() );
		callableStatement.executeUpdate();
		
		// close connection
		callableStatement.getConnection().close();
		return true;
	}

	public boolean updateRiderPhoneRepository(RiderEmailUpdate updateRider) throws SQLException {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call updateRiderByPhone(?, ?)}");
		callableStatement.setString(1, updateRider.getCnic() );
		callableStatement.setString(2, updateRider.getNewEmail() );
		callableStatement.executeUpdate();
		
		// close connection
		callableStatement.getConnection().close();
		return true;
	}

	public boolean removeRiderRepository(String cnic) throws SQLException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call removeRider(?)}");
		callableStatement.setString(1, cnic );
		callableStatement.executeUpdate();
		
		// close connection
		callableStatement.getConnection().close();
		return true;
	}
	
	
	
	
}
