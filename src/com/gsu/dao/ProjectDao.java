package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsu.bean.Project;

public class ProjectDao {
	
	public Connection getConnection(){
		Connection connection = null;
		
		String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=employee_jobs_portal;";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found exception while loading driver class :: "+e.getMessage());
		}
		
		try {
			connection = DriverManager.getConnection(connectionString,"sa","sqladmin");
			System.out.println("Connection established successfully :: ");
		} catch (SQLException e) {
			System.out.println("SQLException while connecting to database :: "+e.getMessage());
		}
		
		return connection;
	}
	
	
	
	public List<Project> selectProject(){
		//String finalResult = null;
		String projectName = null;
		String projectId = null;
		Connection connection = getConnection();
		Statement statement = null;
		String selectQuery = "select project_name,project_id from employee_jobs_portal.dbo.project;";
	     
		
		List<Project> projectList = new ArrayList<Project>();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectQuery);
			while(rs.next()){
				projectName = rs.getString("project_name");
				projectId = rs.getString("project_id");
				System.out.println("Project Name is :: "+projectName+", Project Id is :: "+projectId);
				
				Project projectObj = new Project();
				projectObj.setProjectName(projectName);
				projectObj.setProjectId(projectId);
				projectList.add(projectObj);
			}
			//finalResult = "1 row selected ";
			
			
		} catch (SQLException e) {
			System.out.println("SQLException occured while creating statement :: "+e.getMessage());
			
		}finally{
			if(statement == null){
				try {
					statement.close();
				} catch (SQLException e) {
				System.out.println("SqlException while closing statement :: "+e.getMessage());
				}
			}
			if(connection == null){
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("SqlException while closing connection :: "+e.getMessage());
				}
				
			}
		}
	
		return projectList;
	}
	
	public int insertProject(String projectName, String projectId){
		int rowsUpdated = 0;
		Connection connection = getConnection();
		Statement statement = null;
		String insertQuery = "insert into employee_jobs_portal.dbo.project (project_name,project_id) values ('"+projectName+"','"+projectId+"');";
		try {
			statement = connection.createStatement();
			rowsUpdated = statement.executeUpdate(insertQuery);
			System.out.println(rowsUpdated +" rows updated successfully into Project Table.");
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "+e.getMessage());
		}finally {
			if(statement == null){
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("SQLException occured :: "+e.getMessage());
				}
			}if(connection == null){
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("SQLException occured :: "+e.getMessage());
				}
			}
		}
		
		
		return rowsUpdated;
	}
	public static void main(String[] args){
		ProjectDao obj = new ProjectDao();
	List<Project> prjList = obj.selectProject();
		//int result = obj.insertProject("Walmart","1235");
		//System.out.println(result);
		
	}

}
