package com.project.fooisLife.entity;

import lombok.Data;

@Data
public class Restaurant {
	private Branch branch;
	private Admin admin;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(Branch branch, Admin admin) {
		super();
		this.branch = branch;
		this.admin = admin;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
