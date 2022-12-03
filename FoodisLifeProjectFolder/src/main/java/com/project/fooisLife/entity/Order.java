package com.project.fooisLife.entity;

import java.sql.Date;

public class Order {
	private Date orderTime;
	private String orderStatus;
	private Date pickupTime;
	private String rider_cnic;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Date orderTime, String orderStatus, Date pickupTime, String rider_cnic) {
		super();
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.pickupTime = pickupTime;
		this.rider_cnic = rider_cnic;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	public String getRider_cnic() {
		return rider_cnic;
	}
	public void setRider_cnic(String rider_cnic) {
		this.rider_cnic = rider_cnic;
	}
	
	
}
