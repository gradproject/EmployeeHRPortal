package com.gsu.bean;

public class Project {
	String projectName;
	String projectId;
	
	public Project(){
		super();
	}

	public Project(String projectName, String projectId) {
		super();
		this.projectName = projectName;
		this.projectId = projectId;
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

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectId="
				+ projectId + "]";
	}

	
}
