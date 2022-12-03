package com.project.fooisLife.entity.utilClasses;

public class RiderEmailUpdate {
	private String cnic;
	private String newEmail;
	public RiderEmailUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RiderEmailUpdate(String cnic, String newEmail) {
		super();
		this.cnic = cnic;
		this.newEmail = newEmail;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	
}
