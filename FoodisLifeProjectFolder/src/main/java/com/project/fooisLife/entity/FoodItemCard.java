package com.project.fooisLife.entity;

public class FoodItemCard {
	private FoodItem foodItem;
	private Leftover leftover;
	private Branch branch;
	public FoodItemCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodItemCard(FoodItem foodItem, Leftover leftover, Branch branch) {
		super();
		this.foodItem = foodItem;
		this.leftover = leftover;
		this.branch = branch;
	}
	public FoodItem getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}
	public Leftover getLeftover() {
		return leftover;
	}
	public void setLeftover(Leftover leftover) {
		this.leftover = leftover;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
}
