package com.project.fooisLife.service.foodItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.FoodItem;
import com.project.fooisLife.repository.foodItem.RestaurantFoodItemRepository;

@Service
public class RestaurantFoodItemService {
	
	@Autowired
	private RestaurantFoodItemRepository restaurantFoodItemRepository;
	
	public boolean addRestaurantFoodItemsService(List<FoodItem> foodItems) {
		return restaurantFoodItemRepository.addRestaurantFoodItemsRepository(foodItems);
		
	}
}
