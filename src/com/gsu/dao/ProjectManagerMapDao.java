package com.gsu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectManagerMapDao extends EmployeeConnectDao {

	public int insertProjectManager(String empId, String projectId) {
		Connection connection = getConnection();
		Statement statement = null;
		int rowsUpdated = 0;
		try {
			statement = connection.createStatement();
			String insertQuery = "insert into employee_jobs_portal.dbo.project_manager_map (emp_id,project_id) values('"
					+ empId + "','" + projectId + "');";
			System.out.println(insertQuery);
			System.out.println("dao project id = "+projectId+", emp id = "+empId);
			rowsUpdated = statement.executeUpdate(insertQuery);
			System.out.println(rowsUpdated+" dao");
		} catch (SQLException e) {
			System.out
					.println("SQLException while creating insert statement in project manager dao!! "
							+ e.getMessage());
			rowsUpdated = -1;
		}

		return rowsUpdated;
	}

	
	
	
	public static void main(String[] args){
		ProjectManagerMapDao projManagerMapDaoObj = new ProjectManagerMapDao();
		int rowsUpdated = projManagerMapDaoObj.insertProjectManager("himabindu","1000");
		System.out.println("rows = "+rowsUpdated);
	}
}
