package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDeptMapDao {

	public Connection getConnection(){
		Connection connection = null;
		String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=employee_jobs_portal;";
		//protocol:typeof server://hostname:portnumber;databasename;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException :: "+e.getMessage());
		}
		try {
			connection = DriverManager.getConnection(connectionString,"sa","sqladmin");
			System.out.println("Connection has been successfully established ");
		} catch (SQLException e) {
			System.out.println("SQLException while connecting to database :: "+e.getMessage());
		}
		
		return connection;
	}
	
	public int insertPrjDeptMap(String projectId, String deptId, String hoursAllocated){
		int rowsUpdated = 0;
		
		Connection connection = getConnection();
		Statement statement = null;
		String insertQuery = "insert into employee_jobs_portal.dbo.project_dept_map (project_id, dept_id, hours_allocated ) values('"+projectId+"','"+deptId+"','"+hoursAllocated+"');";
		try {
			statement = connection.createStatement();
			rowsUpdated = statement.executeUpdate(insertQuery);
			System.out.println(rowsUpdated+" : rows have been updated in projectdeptmap table. ");
		} catch (SQLException e) {
			System.out.println("SQLException occured while creating statement :: "+e.getMessage());
		}finally{
			if(statement == null){
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("SQLException occured while closing statement :: "+e.getMessage());
				}
				
			}if(connection == null){
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("SQLException occured while closing connection :: "+e.getMessage());
				}
				
			}
		}
		
		
		
		return rowsUpdated;
	}
	
	public String selectPrjDeptMap(){
		String finalString = null;
		Connection connection = getConnection();
		Statement statement = null;
		String selectQuery = "select project_id, dept_id, hours_allocated from employee_jobs_portal.dbo.project_dept_map;";
		
		return finalString;
	}
	
	public static void main(String[] args){
		ProjectDeptMapDao obj = new ProjectDeptMapDao();
		int count = obj.insertPrjDeptMap("1235", "10", "50");
		System.out.println(count);
		
	}
}
