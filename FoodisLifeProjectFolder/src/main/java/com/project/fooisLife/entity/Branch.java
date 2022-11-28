package com.project.fooisLife.entity;

import lombok.Data;

@Data
public class Branch extends Organization {
	private int bid;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
		this.bid = 1;
	}

	public Branch(String name, String address, String city, String state, String phone, String email,
			String openHours) {
		super(name, address, city, state, phone, email, openHours);
		// TODO Auto-generated constructor stub
	}

	public Branch(int bid) {
		super();
		this.bid = bid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

}
