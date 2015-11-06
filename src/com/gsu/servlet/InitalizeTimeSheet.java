package com.gsu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsu.bean.Project;
import com.gsu.bean.ProjectTimeEntry;
import com.gsu.bean.TimeSheet;
import com.gsu.bean.WeekDays;
import com.gsu.dao.EmployeeProjectMapDao;
import com.gsu.dao.TimeSheetDao;


public class InitalizeTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InitalizeTimeSheet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		String empId = (String) session.getAttribute("empId");

		String weekIncrement = request.getParameter("weekIncrement");

		if (weekIncrement == null)
			weekIncrement = "0";


		String currentWeek = (String) session.getAttribute("currentWeek");

		System.out.println("currentWeek = " + currentWeek);

		if (currentWeek == null)
			currentWeek = "0";

		int weekInc = Integer.parseInt(weekIncrement);

		int curWeek = Integer.parseInt(currentWeek);

		curWeek = curWeek + weekInc;

		session.setAttribute("currentWeek", Integer.toString(curWeek));

		WeekDays weekDays = new WeekDays(curWeek, "MM/dd");

		request.setAttribute("sunday", weekDays.getSunday());
		request.setAttribute("monday", weekDays.getMonday());
		request.setAttribute("tuesday", weekDays.getTuesday());
		request.setAttribute("wednesday", weekDays.getWednesday());
		request.setAttribute("thursday", weekDays.getThursday());
		request.setAttribute("friday", weekDays.getFriday());
		request.setAttribute("saturday", weekDays.getSaturday());

		request.setAttribute("startDate", weekDays.getStartDateValue());

		weekDays = new WeekDays(curWeek);

		request.setAttribute("sundayMDY", weekDays.getSunday());
		request.setAttribute("mondayMDY", weekDays.getMonday());
		request.setAttribute("tuesdayMDY", weekDays.getTuesday());
		request.setAttribute("wednesdayMDY", weekDays.getWednesday());
		request.setAttribute("thursdayMDY", weekDays.getThursday());
		request.setAttribute("fridayMDY", weekDays.getFriday());
		request.setAttribute("saturdayMDY", weekDays.getSaturday());

		EmployeeProjectMapDao employeeProjectMapDaoObj = new EmployeeProjectMapDao();
		List<Project> projectList = employeeProjectMapDaoObj
				.selectProjectsByEmployee(empId);

		request.setAttribute("projectList", projectList);
		request.setAttribute("empId", empId);
		
		int currentLineNumber = 0;

		List<ProjectTimeEntry> projectTimeEntryList = listProjectEntries(
				curWeek, empId, "0", currentLineNumber);

		request.setAttribute("projectTimeEntryList", projectTimeEntryList);
		
		currentLineNumber = currentLineNumber + projectTimeEntryList.size();
		
		List<ProjectTimeEntry> approvedProjectTimeEntryList = listProjectEntries(
				curWeek, empId, "1", currentLineNumber);

		request.setAttribute("approvedProjectTimeEntryList", approvedProjectTimeEntryList);
		
		 currentLineNumber = currentLineNumber + approvedProjectTimeEntryList.size();
		
		request.setAttribute("currentLineNumber", currentLineNumber);

		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/timesheet.jsp");
		rd.forward(request, response);

	}

	public List<ProjectTimeEntry> listProjectEntries(int curWeek, String empId, String approvedStatus, int lineNumber) {

		List<ProjectTimeEntry> projectTimeEntryList = new ArrayList<ProjectTimeEntry>();

		Map<String, ProjectTimeEntry> mapObj = new HashMap<String, ProjectTimeEntry>();

		WeekDays weekDays = new WeekDays(curWeek);

		String startDate = weekDays.getSunday();
		String endDate = weekDays.getSaturday();

		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
		List<TimeSheet> timeSheetList = timeSheetDaoObj.selectTimeSheet(empId,
				startDate, endDate, approvedStatus);

		for (TimeSheet timeSheetObj : timeSheetList) {
			String projectName = timeSheetObj.getProjectName();

			ProjectTimeEntry projectTimeEntryObj = mapObj.get(projectName);
			if (projectTimeEntryObj != null) {
				projectTimeEntryObj = setProjectTimeEntryValues(
						projectTimeEntryObj, timeSheetObj, weekDays);

				mapObj.put(projectName, projectTimeEntryObj);

			} else {
				ProjectTimeEntry projectTimeEntry = new ProjectTimeEntry();
				projectTimeEntry.setProjectName(projectName);
				projectTimeEntry = setProjectTimeEntryValues(projectTimeEntry,
						timeSheetObj, weekDays);

				mapObj.put(projectName, projectTimeEntry);
			}

		}

		
		Set keys = mapObj.keySet();
		Iterator iterator = keys.iterator();
		while (iterator.hasNext()) {
			String projectName = (String) iterator.next();
			ProjectTimeEntry projectTimeEntry = mapObj.get(projectName);
			projectTimeEntry.setLineNumber(lineNumber);
			projectTimeEntryList.add(projectTimeEntry);
			lineNumber++;
		}

		return projectTimeEntryList;
	}

	public ProjectTimeEntry setProjectTimeEntryValues(
			ProjectTimeEntry prjTimeEntry, TimeSheet timeSheet,
			WeekDays weekDays) {

		String projectName = prjTimeEntry.getProjectName();
		String tsProjectName = timeSheet.getProjectName();

		String sunday = weekDays.getSunday();
		String monday = weekDays.getMonday();
		String tuesday = weekDays.getTuesday();
		String wednesday = weekDays.getWednesday();
		String thursday = weekDays.getThursday();
		String friday = weekDays.getFriday();
		String saturday = weekDays.getSaturday();

		if (projectName.equalsIgnoreCase(tsProjectName)) {
			String date = timeSheet.getDate();
			String workHours = timeSheet.getWorkHours();

			System.out.println("Date in set Project Time Entry "+date);
			
			if (sunday.equals(date)) {
				prjTimeEntry.setSunday(workHours);
			} else if (monday.equals(date)) {
				prjTimeEntry.setMonday(workHours);
			} else if (tuesday.equals(date)) {
				prjTimeEntry.setTuesday(workHours);
			} else if (wednesday.equals(date)) {
				prjTimeEntry.setWednesday(workHours);
			} else if (thursday.equals(date)) {
				prjTimeEntry.setThursday(workHours);
			} else if (friday.equals(date)) {
				prjTimeEntry.setFriday(workHours);
			} else if (saturday.equals(date)) {
				prjTimeEntry.setSaturday(workHours);
			}

		}

		return prjTimeEntry;
	}

}
