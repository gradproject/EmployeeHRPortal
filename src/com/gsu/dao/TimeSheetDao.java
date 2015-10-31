package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsu.bean.TimeSheet;

public class TimeSheetDao {

	public Connection getConnection() {

		String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=employee_jobs_portal;";
		// protocol:typeof server://hostname:portnumber;databasename;

		Connection connection = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLException while loading SQLServerDriver :: "
					+ e.getMessage());
		}

		try {
			connection = DriverManager.getConnection(connectionString, "sa",
					"sqladmin");
			// connectionString,username,password.
			System.out.println("Connection established successfully :: ");
		} catch (SQLException e) {
			System.out.println("SQLException while connecting to database :: "
					+ e.getMessage());
		}

		return connection;
	}

	public int insertTimeSheet(String empId, String projectId, String date,
			String workHours, String approved) {
		Connection connection = getConnection();
		Statement statement = null;

		int rowsUpdated = 0;

		try {
			
			System.out.println("Date before insertion into DB :: " + date);
			
			statement = connection.createStatement();
			String insertQuery = "insert into employee_jobs_portal.dbo.timesheet (emp_id,project_id,date,work_hours,approved) values ('"
					+ empId
					+ "','"
					+ projectId
					+ "','"
					+ date
					+ "',"
					+ workHours
					+ "," + approved + ");";

			rowsUpdated = statement.executeUpdate(insertQuery);

			System.out.println(rowsUpdated
					+ " :: rows have been inserted successfully!!");
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		}

		return rowsUpdated;
	}

	public List<TimeSheet> selectTimeSheet(String empId, String startDate, String endDate) {
		Connection connection = getConnection();
		Statement statement = null;
		List<TimeSheet> timeSheetList = null;

		try {
			statement = connection.createStatement();
			String selectQuery = "select t.emp_id, p.project_name, t.work_hours, t.approved, t.date from employee_jobs_portal.dbo.timesheet as t, employee_jobs_portal.dbo.project as p where t.project_id = p.project_id and t.emp_id = '"+empId+"' and t.date between '"+startDate+"' and '"+endDate+"'";

			String empid = null;
			String projectName = null;
			String date = null;
			String workHours = null;
			String approved = null;

			timeSheetList = new ArrayList<TimeSheet>();

			ResultSet rs = statement.executeQuery(selectQuery);
			while (rs.next()) {
				empid = rs.getString("emp_id");
				projectName = rs.getString("project_name");
				String dateFromDB = rs.getString("date");
				date = dateFromDB.substring(0,10);
				System.out.println("Date from db in select method :: "+dateFromDB.toString());
				System.out.println("After formatting date :: "+date.toString());
				workHours = rs.getString("work_hours");
				approved = rs.getString("approved");
				
				
				//****************************************************************************
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
//				
//						
//				String finalDateFromDB = null;
//				try {
//					Date formattedDateFromDB = simpleDateFormat.parse(date);
//					System.out.println("formatted date from db :: "+formattedDateFromDB.toString());
//					finalDateFromDB = simpleDateFormat.format(formattedDateFromDB);
//					System.out.println("final date from db :: "+finalDateFromDB.toString());
//				} catch (ParseException e) {
//					System.out.println("ParseException while converting date :: "+e.getMessage());
//				}

				
				//******************************************************************************
				TimeSheet timeSheetObj = new TimeSheet();
				timeSheetObj.setEmpId(empid);
				timeSheetObj.setProjectName(projectName);
				timeSheetObj.setDate(date);
				timeSheetObj.setWorkHours(workHours);
				timeSheetObj.setApproved(approved);

				timeSheetList.add(timeSheetObj);

			}

		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		}

		return timeSheetList;
	}

	public static void main(String[] args) {
		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
		// int rowsUpdated = timeSheetDaoObj.insertTimeSheet("nrios", "3423",
		// "2014-12-03", "12.30", "1");
		// System.out.println(rowsUpdated);

		List<TimeSheet> list = timeSheetDaoObj.selectTimeSheet("njyothi","2015-10-25","2015-10-31");
		System.out.println(list.toString());
	}
}
