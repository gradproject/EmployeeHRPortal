package com.gsu.bean;

public class Project {
	private String projectName;
	private String projectId;
	private String projectStatus;
	private String empId;
	private String description;
	private String totalCost;
	
	public Project(){
		super();
	}

	public Project(String projectName, String projectId, String projectStatus, String empId, String description, String totalCost) {
		super();
		this.projectName = projectName;
		this.projectId = projectId;
		this.projectStatus = projectStatus;
		this.empId = empId;
		this.description = description;
		this.totalCost = totalCost;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectId="
				+ projectId + ", projectStatus=" + projectStatus + ", empId="
				+ empId + ", description=" + description + ", totalCost="
				+ totalCost + "]";
	}

	

	
}
