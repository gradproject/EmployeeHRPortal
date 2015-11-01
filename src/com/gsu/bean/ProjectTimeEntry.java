package com.gsu.bean;

public class ProjectTimeEntry {

	private String projectName;
	private String sunday;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sundayApprovedStatus;
	private String mondayApprovedStatus;
	private String tuesdayApprovedStatus;
	private String wednesdayApprovedStatus;
	private String thursdayApprovedStatus;
	private String fridayApprovedStatus;
	private String saturdayApprovedStatus;
	private int lineNumber;

	public ProjectTimeEntry() {

	}

	@Override
	public String toString() {
		return "ProjectTimeEntry [projectName=" + projectName + ", sunday="
				+ sunday + ", monday=" + monday + ", tuesday=" + tuesday
				+ ", wednesday=" + wednesday + ", thursday=" + thursday
				+ ", friday=" + friday + ", saturday=" + saturday
				+ ", sundayApprovedStatus=" + sundayApprovedStatus
				+ ", mondayApprovedStatus=" + mondayApprovedStatus
				+ ", tuesdayApprovedStatus=" + tuesdayApprovedStatus
				+ ", wednesdayApprovedStatus=" + wednesdayApprovedStatus
				+ ", thursdayApprovedStatus=" + thursdayApprovedStatus
				+ ", fridayApprovedStatus=" + fridayApprovedStatus
				+ ", saturdayApprovedStatus=" + saturdayApprovedStatus + "]";
	}

	public ProjectTimeEntry(String projectName, String sunday, String monday,
			String tuesday, String wednesday, String thursday, String friday,
			String saturday, String sundayApprovedStatus,
			String mondayApprovedStatus, String tuesdayApprovedStatus,
			String wednesdayApprovedStatus, String thursdayApprovedStatus,
			String fridayApprovedStatus, String saturdayApprovedStatus) {
		super();
		this.projectName = projectName;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sundayApprovedStatus = sundayApprovedStatus;
		this.mondayApprovedStatus = mondayApprovedStatus;
		this.tuesdayApprovedStatus = tuesdayApprovedStatus;
		this.wednesdayApprovedStatus = wednesdayApprovedStatus;
		this.thursdayApprovedStatus = thursdayApprovedStatus;
		this.fridayApprovedStatus = fridayApprovedStatus;
		this.saturdayApprovedStatus = saturdayApprovedStatus;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSundayApprovedStatus() {
		return sundayApprovedStatus;
	}

	public void setSundayApprovedStatus(String sundayApprovedStatus) {
		this.sundayApprovedStatus = sundayApprovedStatus;
	}

	public String getMondayApprovedStatus() {
		return mondayApprovedStatus;
	}

	public void setMondayApprovedStatus(String mondayApprovedStatus) {
		this.mondayApprovedStatus = mondayApprovedStatus;
	}

	public String getTuesdayApprovedStatus() {
		return tuesdayApprovedStatus;
	}

	public void setTuesdayApprovedStatus(String tuesdayApprovedStatus) {
		this.tuesdayApprovedStatus = tuesdayApprovedStatus;
	}

	public String getWednesdayApprovedStatus() {
		return wednesdayApprovedStatus;
	}

	public void setWednesdayApprovedStatus(String wednesdayApprovedStatus) {
		this.wednesdayApprovedStatus = wednesdayApprovedStatus;
	}

	public String getThursdayApprovedStatus() {
		return thursdayApprovedStatus;
	}

	public void setThursdayApprovedStatus(String thursdayApprovedStatus) {
		this.thursdayApprovedStatus = thursdayApprovedStatus;
	}

	public String getFridayApprovedStatus() {
		return fridayApprovedStatus;
	}

	public void setFridayApprovedStatus(String fridayApprovedStatus) {
		this.fridayApprovedStatus = fridayApprovedStatus;
	}

	public String getSaturdayApprovedStatus() {
		return saturdayApprovedStatus;
	}

	public void setSaturdayApprovedStatus(String saturdayApprovedStatus) {
		this.saturdayApprovedStatus = saturdayApprovedStatus;
	}

}
