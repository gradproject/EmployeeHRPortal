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
			String insertQuery = "insert into employee_jobs_portal.dbo.timesheet (emp_id,project_id,timesheet_date,work_hours,approved) values ('"
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

	public List<TimeSheet> selectTimeSheet(String empId, String startDate, String endDate, String approvedStatus) {
		Connection connection = getConnection();
		Statement statement = null;
		List<TimeSheet> timeSheetList = null;

		try {
			statement = connection.createStatement();
			String selectQuery = "select t.emp_id, p.project_name, t.timesheet_date, sum(t.work_hours) as total_work_hours, t.approved from employee_jobs_portal.dbo.timesheet as t, employee_jobs_portal.dbo.project as p where t.project_id = p.project_id and t.emp_id = '"+empId+"' and t.timesheet_date between '"+startDate+"' and '"+endDate+"' and t.approved = "+approvedStatus+" group by t.emp_id, p.project_name, t.timesheet_date, t.approved;";

			String empid = null;
			String projectName = null;
			String date = null;
			String totalworkHours = null;
			String approved = null;

			timeSheetList = new ArrayList<TimeSheet>();

			ResultSet rs = statement.executeQuery(selectQuery);
			while (rs.next()) {
				empid = rs.getString("emp_id");
				projectName = rs.getString("project_name");
				date = rs.getString("timesheet_date");
				totalworkHours = rs.getString("total_work_hours");
				approved = rs.getString("approved");
				
				
				TimeSheet timeSheetObj = new TimeSheet();
				timeSheetObj.setEmpId(empid);
				timeSheetObj.setProjectName(projectName);
				timeSheetObj.setDate(date);
				timeSheetObj.setWorkHours(totalworkHours);
				timeSheetObj.setApproved(approved);

				timeSheetList.add(timeSheetObj);

			}

		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		}

		return timeSheetList;
	}

	
	public List<TimeSheet> listunApprovedTimeSheet(String projectId){
		Connection connection = getConnection();
		Statement statement = null;
		List<TimeSheet> timesheetList = new ArrayList<TimeSheet>();
		
		String empFullName = null;
		String empId = null;
		String prjId = null;
		String date = null;
		 String totalworkHours = null;
		 String approved = null;
		
		try{
		statement = connection.createStatement();
		String selectQuery = "select  (e.emp_firstname + ' ' + e.emp_middlename + ' ' + e.emp_lastname) as emp_name, ts.emp_id, ts.project_id, ts.timesheet_date, sum(ts.work_hours) as total_work_hours, ts.approved  from employee_jobs_portal.dbo.timesheet as ts, employee_jobs_portal.dbo.employee as e where ts.emp_id = e.emp_id  and ts.project_id = '"+projectId+"' and ts.approved = 0   group by ts.emp_id,  ts.timesheet_date, ts.project_id, ts.approved, e.emp_firstname, e.emp_middlename, e.emp_lastname;";
		
		
		
		ResultSet rs = statement.executeQuery(selectQuery);
		while(rs.next()){
			
			empFullName = rs.getString("emp_name");
			empId = rs.getString("emp_id");
			prjId = rs.getString("project_id"); 
			date = rs.getString("timesheet_date");
			totalworkHours = rs.getString("total_work_hours");
			approved = rs.getString("approved");
			
			TimeSheet timesheetObj = new TimeSheet();
			timesheetObj.setApproved(approved);
			timesheetObj.setDate(date);
			timesheetObj.setEmpFullName(empFullName);
			timesheetObj.setEmpId(empId);
			timesheetObj.setProjectId(prjId);
			timesheetObj.setWorkHours(totalworkHours);
			
			timesheetList.add(timesheetObj);
		}
		
		}catch(SQLException e){
			System.out.println("SQLException while creating select query in listUnApprovedTimeSheet method of TimeSheetDao. "+e.getMessage());
		}
		
		
		return timesheetList;
	}
	
	public int approveTimeSheet(String projectId, String empId, String date){
		Connection connection = getConnection();
		Statement statement = null;
		int rowsUpdated = 0;
		try{
		statement = connection.createStatement();
		String updateQuery = "update employee_jobs_portal.dbo.timesheet set approved = 1 where project_id = '"+projectId+"' and emp_id = '"+empId+"' and timesheet_date = '"+date+"';";
		rowsUpdated = statement.executeUpdate(updateQuery);
		}catch(SQLException e){
			System.out.println("SQLException while creating statement in approveTimeSheet method in timeSheetDao. "+e.getMessage());
		}
		
		return rowsUpdated;
	}
	public static void main(String[] args) {
		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
//		 int rowsUpdated = timeSheetDaoObj.insertTimeSheet("nrios", "3423",
//		 "2015-10-30", "12", "1");
//		 System.out.println(rowsUpdated);

//		List<TimeSheet> list = timeSheetDaoObj.selectTimeSheet("njyothi","2015-10-25","2015-10-31","1");
//		System.out.println(list.toString());
		
//		List<TimeSheet> tsList = timeSheetDaoObj.listunApprovedTimeSheet("1235");
//		System.out.println(tsList.toString());
		
		int rowsUpdated = timeSheetDaoObj.approveTimeSheet("9990", "njyothi", "2015-10-11");
		System.out.println("Approve time sheet = "+rowsUpdated);
	}
}
