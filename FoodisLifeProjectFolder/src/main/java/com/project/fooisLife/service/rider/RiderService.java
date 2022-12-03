package com.project.fooisLife.service.rider;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Rider;
import com.project.fooisLife.entity.utilClasses.RiderEmailUpdate;
import com.project.fooisLife.repository.rider.RiderRepository;

@Service
public class RiderService {
	
	@Autowired
	private RiderRepository riderRepository;
	
	public boolean addRiderDetailsService(List<Rider> rider, String email) {
		try {
			return riderRepository.addRiderDetailsRepository(rider, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Rider> displayRiderDetailsService(String email) {
	
		return riderRepository.displayRiderDetailsRepository(email);
	}

	public boolean updateRiderEmailService(RiderEmailUpdate updateRider) {
		
		try {
			return riderRepository.updateRiderEmailRepository(updateRider);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateRiderPhoneService(RiderEmailUpdate updateRider) {
		try {
			return riderRepository.updateRiderPhoneRepository(updateRider);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeRiderService(String cnic) {
		
		try {
			return riderRepository.removeRiderRepository(cnic);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
