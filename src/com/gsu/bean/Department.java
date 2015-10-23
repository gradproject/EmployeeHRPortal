package com.gsu.bean;

public class Department {
	
	String deptName;
	String deptId;
	
	public Department(){
		super();
	}
	public Department(String deptName, String deptId) {
		super();
		this.deptName = deptName;
		this.deptId = deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}
	
	
	

}
