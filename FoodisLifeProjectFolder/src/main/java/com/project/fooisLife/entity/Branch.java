package com.project.fooisLife.entity;

import lombok.Data;

@Data
public class Branch {
	
	private String restaurantName;
	private int bid;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	private String openHours;
	
	public Branch() {
		super();
		this.bid = 1;
	}
	public Branch(String resName, int bid, String address, String city, String state, String phone, String email, String hours) {
		super();
		this.restaurantName = resName;
		this.bid = bid;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.openHours = hours;
	}
	public int getId() {
		return bid;
	}
	public void setId(int bid) {
		this.bid = bid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getOpenHours() {
		return openHours;
	}
	public void setOpenHours(String openHours) {
		this.openHours = openHours;
	}
	@Override
	public String toString() {
		return "Branch [restaurantName=" + restaurantName + ", bid=" + bid + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", phone=" + phone + ", email=" + email + ", openHours=" + openHours + "]";
	}
	
	
}
