package com.project.fooisLife.service.foodItem;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Leftover;
import com.project.fooisLife.repository.foodItem.RestaurantLeftoverRepository;

@Service
public class RestaurantLeftoverService {
	
	@Autowired
	private RestaurantLeftoverRepository restaurantLeftoverRepository;
	
	public boolean addLeftoversService(List<Leftover> leftover, String email) {
		try {
			return restaurantLeftoverRepository.addLeftoversRepository(leftover, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
