package com.project.fooisLife.entity;

public class Branch {
	private int id;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	
	public Branch() {
		super();
		this.id = 1;
	}
	public Branch(int id, String address, String city, String state, String phone, String email) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Branch [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
	
}
