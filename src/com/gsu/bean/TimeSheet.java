package com.gsu.bean;

public class TimeSheet {

	private String empId;
	private String projectId;
	private String projectName;
	private String date;
	private String workHours;
	private String approved;
	private String empFullName;

	public TimeSheet() {

	}

	
	public TimeSheet(String empId, String projectId, String date,
			String workHours, String approved) {
		this.empId = empId;
		this.projectId = projectId;
		this.date = date;
		this.workHours = workHours;
		this.approved = approved;
	}

	
	
	public TimeSheet(String empId, String projectId, String projectName,
			String date, String workHours, String approved, String empFullName) {
		super();
		this.empId = empId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.date = date;
		this.workHours = workHours;
		this.approved = approved;
		this.empFullName = empFullName;
	}


	public String getEmpFullName() {
		return empFullName;
	}


	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
		return "\n"+"TimeSheet [empId=" + empId + ", projectId=" + projectId
				+ ", projectName=" + projectName + ", date=" + date
				+ ", workHours=" + workHours + ", approved=" + approved
				+ ", empFullName=" + empFullName + "]";
	}

}
