package com.gsu.bean;

public class TimeSheet {
	
	private String empId;
	private String projectId;
	private String date;
	private String workHours;
	private String approved;
	
	public TimeSheet(){
		
	}

	
	public TimeSheet(String empId, String projectId, String date, String workHours, String approved){
		this.empId = empId;
		this.projectId = projectId;
		this.date = date;
		this.workHours = workHours;
		this.approved = approved;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getWorkHours() {
		return workHours;
	}


	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}


	public String getApproved() {
		return approved;
	}


	public void setApproved(String approved) {
		this.approved = approved;
	}


	@Override
	public String toString() {
		return "TimeSheet [empId=" + empId + ", projectId=" + projectId
				+ ", date=" + date + ", workHours=" + workHours + ", approved="
				+ approved + "]";
	}
	
	
}
