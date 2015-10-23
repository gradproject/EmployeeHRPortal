package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
			statement = connection.createStatement();
			String insertQuery = "insert into employee_jobs_portal.dbo.timesheet (emp_id,project_id,date,work_hours,approved) values ('"+ empId+ "','"+ projectId+ "',"+ date+ ","+workHours+"," + approved + ");";
			
			 rowsUpdated = statement.executeUpdate(insertQuery);
			 
			 System.out.println(rowsUpdated+" :: rows have been inserted successfully!!");
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		}

		return rowsUpdated;
	}

	
	public static void main(String[] args) {
		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
		int rowsUpdated = timeSheetDaoObj.insertTimeSheet("nrios", "3423", "2014-12-03", "12.30", "1");
	System.out.println(rowsUpdated);
	}
}
