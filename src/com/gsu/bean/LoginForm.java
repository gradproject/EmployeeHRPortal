package com.gsu.bean;

public class LoginForm {

	
	private String empId;
	private String password;
	
	public LoginForm(){
		super();
	}
	
	   public LoginForm(String empId, String password){
		   this.empId = empId;
		   this.password = password;
		   
	   }

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginForm [empId=" + empId + ", password=" + password + "]";
	}
	   
	   
	   
	
}
