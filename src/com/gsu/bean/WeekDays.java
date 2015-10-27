package com.gsu.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeekDays {

	int year;
	int weekOfYear;
	
	String sunday;
	String monday;
	String tuesday;
	String wednesday;
	String thursday;
	String friday;
	String saturday;
	
	public WeekDays(){
		Calendar calendar = Calendar.getInstance();
		Date trialTime = new Date();
		calendar.setTime(trialTime);
		this.weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		this.year = calendar.get(Calendar.YEAR);
		initializeDays();
	}
	
	public WeekDays(int currentWeek){
		Calendar calendar = Calendar.getInstance();
		Date trialTime = new Date();
		calendar.setTime(trialTime);
		this.weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR) + currentWeek;
		this.year = calendar.get(Calendar.YEAR);
		
		initializeDays();
	}
	
	public WeekDays(int weekOfYear, int year){
		this.weekOfYear = weekOfYear;
		this.year = year;
		initializeDays();
	}
	
	private void initializeDays(){
		setSunday(getDateValue(Calendar.SUNDAY));
		setMonday(getDateValue(Calendar.MONDAY));
		setTuesday(getDateValue(Calendar.TUESDAY));
		setWednesday(getDateValue(Calendar.WEDNESDAY));
		setThursday(getDateValue(Calendar.THURSDAY));
		setFriday(getDateValue(Calendar.FRIDAY));
		setSaturday(getDateValue(Calendar.SATURDAY));
	}
	
	private String getDateValue(int dayOfWeek){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);        
		cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		String date = sdf.format(cal.getTime());
		return date;
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
	
	@Override
	public String toString() {
		
		return super.toString() + " :: year = " + year + ", weekOfYear = " + weekOfYear + ", sunday = " + sunday + ", monday = " + monday + ", tuesday = " + tuesday + ", wednesday = " + wednesday + ", thursday = " + thursday + ", friday = " + friday + ", saturday = " + saturday;
	}
	
	public static void main(String[] args) {
		WeekDays weekDays = new WeekDays();
		
		System.out.println(weekDays);
	}

}
