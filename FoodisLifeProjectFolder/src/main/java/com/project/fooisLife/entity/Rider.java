package com.project.fooisLife.entity;

public class Rider {
	private String cnic;
	private String name;
	private String email;
	private String phone;
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rider(String cnic, String name, String email, String phone) {
		super();
		this.cnic = cnic;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
