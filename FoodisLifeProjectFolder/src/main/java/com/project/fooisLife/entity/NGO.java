package com.project.fooisLife.entity;

import lombok.Data;

@Data
public class NGO extends Organization {

	private Admin admin;

	public NGO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NGO(String name, String address, String city, String state, String phone, String email, String openHours) {
		super(name, address, city, state, phone, email, openHours);
		// TODO Auto-generated constructor stub
	}

	public NGO(Admin admin) {
		super();
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
