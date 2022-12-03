package com.project.fooisLife.service.foodItem;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.FoodItemCard;
import com.project.fooisLife.repository.foodItem.NGOOrderFoodItemsRepository;

@Service
public class NGOOrderFoodItemsService {

	@Autowired
	private NGOOrderFoodItemsRepository nGOFoodItemsRepository;
	
	public List<FoodItemCard> orderFoodItemsService(){
		try {
			System.out.println(nGOFoodItemsRepository.orderFoodItemsRepository());
			return nGOFoodItemsRepository.orderFoodItemsRepository();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
