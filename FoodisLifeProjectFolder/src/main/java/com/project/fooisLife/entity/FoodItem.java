package com.project.fooisLife.entity;

public class FoodItem {
	private String itemName;
	private String itemDescription;
	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodItem(String itemName, String itemDescription) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	
}
