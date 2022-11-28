package com.project.fooisLife.entity;

public class Organization {
	private String Name;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	private String openHours;
	
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organization(String name, String address, String city, String state, String phone, String email,
			String openHours) {
		super();
		Name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.openHours = openHours;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String getOpenHours() {
		return openHours;
	}
	public void setOpenHours(String openHours) {
		this.openHours = openHours;
	}
	
	
}
