package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsu.bean.Project;

public class ProjectDao extends EmployeeConnectDao {
	
	
	
	public List<Project> selectProject(){
		//String finalResult = null;
		String projectName = null;
		String projectId = null;
		String projectStatus = null;
		String empId = null;
		String totalCost = null;
		String description = null;
		Connection connection = getConnection();
		Statement statement = null;
		String selectQuery = "select project_name,project_id, project_status, emp_id, description, total_cost from employee_jobs_portal.dbo.project;";
	     
		
		List<Project> projectList = new ArrayList<Project>();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectQuery);
			while(rs.next()){
				projectName = rs.getString("project_name");
				projectId = rs.getString("project_id");
				projectStatus = rs.getString("project_status");
				description = rs.getString("description");
				empId = rs.getString("emp_id");
				totalCost = rs.getString("total_cost");
				
				System.out.println("Project Name is :: "+projectName+", Project Id is :: "+projectId+", Project Status is :: "+projectStatus+", description is :: "+description+", emp id is :: "+empId+", total cost is :: "+totalCost);
				
				Project projectObj = new Project();
				projectObj.setProjectName(projectName);
				projectObj.setProjectId(projectId);
				projectObj.setDescription(description);
				projectObj.setEmpId(empId);
				projectObj.setProjectStatus(projectStatus);
				projectObj.setTotalCost(totalCost);
				
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
	
	public List<Project> listProjectsByManager(String empId){
		Connection connection = getConnection();
		Statement statement = null;
		List<Project> projectList =  new ArrayList<Project>();
		String projectName = null;
		String projectId = null;
		String projectStatus = null;
		String manager = null;
		String totalCost = null;
		String description = null;
		
		try {
			statement = connection.createStatement();
			String selectQuery = "select project_name, project_id, project_status, description, emp_id, total_cost from employee_jobs_portal.dbo.project where emp_id = '"+empId+"';";
		
		ResultSet rs = statement.executeQuery(selectQuery);
		while(rs.next()){
			projectName = rs.getString("project_name");
			projectId = rs.getString("project_id");
			projectStatus = rs.getString("project_status");
			description = rs.getString("description");
			manager = rs.getString("emp_id");
			totalCost = rs.getString("total_cost");
			
			System.out.println("Project Name is :: "+projectName+", Project Id is :: "+projectId+", Project Status is :: "+projectStatus+", description is :: "+description+", manager(emp id) is :: "+manager+", total cost is :: "+totalCost);
			
			Project projectObj = new Project();
			projectObj.setProjectName(projectName);
			projectObj.setProjectId(projectId);
			projectObj.setDescription(description);
			projectObj.setEmpId(manager);
			projectObj.setProjectStatus(projectStatus);
			projectObj.setTotalCost(totalCost);
			
			projectList.add(projectObj);
		}
		
		} catch (SQLException e) {
System.out.println("SQLException while creating statement in list project by manager method in project dao. "+e.getMessage());
		}
		
		return projectList;
	}
	
	
	public int insertProject(String projectName, String projectId, String projectStatus, String empId, String description, String totalCost){
		int rowsUpdated = 0;
		Connection connection = getConnection();
		Statement statement = null;
		String insertQuery = "insert into employee_jobs_portal.dbo.project (project_name,project_id, project_status, description, emp_id, total_cost) values ('"+projectName+"','"+projectId+"','"+projectStatus+"','"+description+"','"+empId+"',"+totalCost+");";
		try {
			System.out.println("insert query :: "+insertQuery);
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
//	List<Project> prjList = obj.listProjectsByManager("rmudunuri");
//	System.out.println(prjList.toString());
			//obj.selectProject();
		//int result = obj.insertProject("INDIA BAZAR","1236","done","rmudunuri","abcdefghijklmnopqrstuvwxyz","34313231");
		//System.out.println(result);
		List<Project> projList = obj.selectProject();
		System.out.println(projList.toString());
	}

}
