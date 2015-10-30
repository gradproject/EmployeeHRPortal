package com.gsu.bean;

public class AdminLoginForm {

	private String adminUserName;
	private String adminPassword;

	public AdminLoginForm() {
		super();
	}

	public AdminLoginForm(String adminUserName, String adminPassword) {
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public String toString() {
		return "Admin UserName :: " + adminUserName + " , Admin Password :: "
				+ adminPassword;
	}
}
