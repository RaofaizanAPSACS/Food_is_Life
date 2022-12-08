package com.project.fooisLife.entity.utilClasses;

public class DisplayFoodItemUtil {
	private int itemID;
	private String ItemName;
	private String ItemDesc;
	private String resName;
	public DisplayFoodItemUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DisplayFoodItemUtil(int itemID, String itemName, String itemDesc, String resName) {
		super();
		this.itemID = itemID;
		ItemName = itemName;
		ItemDesc = itemDesc;
		this.resName = resName;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	
	

}
