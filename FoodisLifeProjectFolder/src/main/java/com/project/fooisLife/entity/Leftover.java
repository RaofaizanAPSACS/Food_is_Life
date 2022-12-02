package com.project.fooisLife.entity;

import java.sql.Date;

public class Leftover {
	private int itemID;
	private int quantity;
	private Date bestBefore;
	public Leftover() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leftover(int itemID, int quantity, Date bestBefore) {
		super();
		this.itemID = itemID;
		this.quantity = quantity;
		this.bestBefore = bestBefore;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getBestBefore() {
		return bestBefore;
	}
	public void setBestBefore(Date bestBefore) {
		this.bestBefore = bestBefore;
	}
	
	
	
}
