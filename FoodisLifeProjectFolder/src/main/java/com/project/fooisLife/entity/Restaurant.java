package com.project.fooisLife.entity;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Restaurant {
	private Branch branch;
	private BranchAdmin admin;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(Branch branch, BranchAdmin admin) {
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
	public BranchAdmin getAdmin() {
		return admin;
	}
	public void setAdmin(BranchAdmin admin) {
		this.admin = admin;
	}
	
}
