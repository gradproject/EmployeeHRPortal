package com.gsu.bean;

public class Admin {

	
	private String adminUserName;
	private String adminPassword;
	
	
	public Admin(){
		super();
	}
	
	public Admin(String adminUserName, String adminPassword){
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminUserName=" + adminUserName + ", adminPassword="
				+ adminPassword + "]";
	}
	
	
}
