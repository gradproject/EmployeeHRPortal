package com.gsu.bean;

public class Employee {
	
	
	String empId;
	String empFirstName;
	String empMiddleName;
	String empLastName;
	String empEmailId;
	String phoneNumber;
	String deptId;
	String empDesg;
	String empExp;
	String password;
	
	
	public Employee(){
		super();
	}

	
	public Employee(String empId, String empFirstName, String empMiddleName, String empLastName, String empEmailId, String phoneNumber, String deptId, String empDesg, String empExp,String password){
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.empEmailId = empEmailId;
		this.phoneNumber = phoneNumber;
		this.deptId = deptId;
		this.empDesg = empDesg;
		this.empDesg = empDesg;
		this.password = password;
	}
	
	public void setEmpId(String empId){
		this.empId = empId;
	}
	
	public String getEmpId(){
		return empId;
	}
	
	public void setEmpFirstName(String empFirstName){
		this.empFirstName = empFirstName;
		}
	
	public String getEmpFirstName(){
		return empFirstName;	
	}
	
	public void setEmpMiddleName(String empMiddleName){
		this.empMiddleName = empMiddleName;
		}
	
	public String getEmpMiddleName(){
		return empMiddleName;	
	}
	
	public void setEmpLastName(String empLastName){
		this.empLastName = empLastName;
		}
	
	public String getEmpLastName(){
		return empLastName;	
	}
	
	public void setEmpEmailId(String empEmailId){
		this.empEmailId = empEmailId;
	}
	
	public String getEmpEmailId(){
		return empEmailId;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setDeptId(String deptId){
		this.deptId = deptId;
	}
	
	public String getDeptId(){
		return deptId;
	}
	
	public void setEmpDesg(String empDesg){
		this.empDesg = empDesg;
	}
	
	public String getEmpDesg(){
		return empDesg;
	}
	
	public void setEmpExp(String empExp){
		this.empExp = empExp;
	}
	
	public String getEmpExp(){
		return empExp;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName
				+ ", empMiddleName=" + empMiddleName + ", empLastName="
				+ empLastName + ", empEmailId=" + empEmailId + ", phoneNumber="
				+ phoneNumber + ", deptId=" + deptId + ", empDesg=" + empDesg
				+ ", empExp=" + empExp + ", password=" + password + "]";
	}


	
	
	
}
