package com.project.fooisLife.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.fooisLife.entity.Branch;
import com.project.fooisLife.entity.BranchAdmin;
import com.project.fooisLife.entity.Restaurant;

public class RestaurantModel {
	@Autowired
	private Restaurant restaurant;
	@Autowired
	private Branch branch;
	@Autowired
	private BranchAdmin branchAdmin;
	
	public RestaurantModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantModel(Restaurant restaurant, Branch branch, BranchAdmin branchAdmin) {
		super();
		this.restaurant = restaurant;
		this.branch = branch;
		this.branchAdmin = branchAdmin;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public BranchAdmin getBranchAdmin() {
		return branchAdmin;
	}
	public void setBranchAdmin(BranchAdmin branchAdmin) {
		this.branchAdmin = branchAdmin;
	}
	
	
	
}
