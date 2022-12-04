package com.project.fooisLife.service.foodItem;

import java.sql.SQLException;
import java.util.ArrayList;
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
			ArrayList<FoodItemCard> newList = new ArrayList<FoodItemCard>();
			
			for( FoodItemCard item : nGOFoodItemsRepository.orderFoodItemsRepository()) {
				if(item.getLeftover().getQuantity() > 0) {
					newList.add(item);
				}
			}
			return newList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<FoodItemCard> searchFoodByStoreNameService(String name) {
		try {
			ArrayList<FoodItemCard> newList = new ArrayList<FoodItemCard>();
			
			for( FoodItemCard item : nGOFoodItemsRepository.orderFoodItemsRepository()) {
				if( item.getLeftover().getQuantity() > 0 && item.getBranch().getName().equals(name)) {
					newList.add(item);
				}
			}
			return newList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<FoodItemCard> searchFoodByItemNameService(String name) {
		try {
			ArrayList<FoodItemCard> newList = new ArrayList<FoodItemCard>();
			
			for( FoodItemCard item : nGOFoodItemsRepository.orderFoodItemsRepository()) {
				if( item.getLeftover().getQuantity() > 0 && item.getFoodItem().getItemName().equals(name)) {
					newList.add(item);
				}
			}
			return newList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
