package com.project.fooisLife.entity;

public class Cart {
	private String StoreName;
	private int bid;
	private int itemID;
	private String itemName;
	private int quantity;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String storeName, int bid, int itemID, String itemName, int quantity) {
		super();
		StoreName = storeName;
		this.bid = bid;
		this.itemID = itemID;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
