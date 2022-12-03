package com.project.fooisLife.entity;

public class StoreOrder {
	private Rider rider;
	private Order order;
	private String ngoName;
	private int order_id;
	public StoreOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreOrder(Rider rider, Order order, String ngoName, int order_id) {
		super();
		this.rider = rider;
		this.order = order;
		this.ngoName = ngoName;
		this.order_id = order_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	
	
}
