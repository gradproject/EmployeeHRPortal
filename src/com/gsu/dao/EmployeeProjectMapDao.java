package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsu.bean.Employee;
import com.gsu.bean.Project;

public class EmployeeProjectMapDao extends EmployeeConnectDao{

	

	public int insertEmployeeProjectMap(String empId, String deptId,
			String projectId) {
		int rowsUpdated = 0;

		Connection connection = getConnection();
		Statement statement = null;
		String insertQuery = "insert into employee_jobs_portal.dbo.emp_project_map (emp_id, dept_id, project_id ) values('"
				+ empId + "','" + deptId + "','" + projectId + "');";
		try {
			statement = connection.createStatement();
			rowsUpdated = statement.executeUpdate(insertQuery);
			System.out.println(rowsUpdated
					+ " : rows have been updated in projectdeptmap table. ");
		} catch (SQLException e) {
			System.out
					.println("SQLException occured while creating statement :: "
							+ e.getMessage());
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException occured while closing statement :: "
									+ e.getMessage());
				}

			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException occured while closing connection :: "
									+ e.getMessage());
				}

			}
		}

		return rowsUpdated;
	}

	public String selectEmployeeProjectMap() {
		String finalString = null;
		Connection connection = getConnection();
		Statement statement = null;
		String selectQuery = "select emp_id, dept_id, project_id from employee_jobs_portal.dbo.emp_project_map;";

		return finalString;
	}

	public List<Employee> selectEmployeesByProject(String projectId) {
		Connection connection = getConnection();
		Statement statement = null;
		String selectQuery = "select employee.emp_id, emp_firstname, emp_middlename, emp_lastname from employee_jobs_portal.dbo.emp_project_map as empmap , employee_jobs_portal.dbo.employee as employee where empmap.emp_id = employee.emp_id and empmap.project_id = "
				+ projectId + ";";

		List<Employee> employeeList = null;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectQuery);

			employeeList = new ArrayList<Employee>();

			while (rs.next()) {
				Employee employeeObj = new Employee();
				employeeObj.setEmpId(rs.getString("emp_id"));
				employeeObj.setEmpFirstName(rs.getString("emp_firstname"));
				employeeObj.setEmpMiddleName(rs.getString("emp_middlename"));
				employeeObj.setEmpLastName(rs.getString("emp_lastname"));
				employeeList.add(employeeObj);
			}
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException occured while closing statement :: "
									+ e.getMessage());
				}

			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException occured while closing connection :: "
									+ e.getMessage());
				}

			}
		}

		return employeeList;
	}

	public List<Project> selectProjectsByEmployee(String empId) {
		Connection connection = getConnection();
		Statement statement = null;
		List<Project> projectList = null;

		try {
			statement = connection.createStatement();
			String selectQuery = "select p.project_name, p.project_id from employee_jobs_portal.dbo.project as p, employee_jobs_portal.dbo.emp_project_map as ep where p.project_id = ep.project_id and ep.emp_id = '"
					+ empId + "';";

			ResultSet rs = statement.executeQuery(selectQuery);
			projectList = new ArrayList<Project>();
			while (rs.next()) {
				Project projectObj = new Project();
				projectObj.setProjectId(rs.getString("project_id"));
				projectObj.setProjectName(rs.getString("project_name"));
				projectList.add(projectObj);
			}
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement "
					+ e.getMessage());
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException occured while closing statement :: "
									+ e.getMessage());
				}

			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException occured while closing connection :: "
									+ e.getMessage());
				}

			}
		}

		return projectList;
	}

	public static void main(String[] args) {
		EmployeeProjectMapDao obj = new EmployeeProjectMapDao();
		List<Employee> empList = obj.selectEmployeesByProject("1235");
		System.out.println(empList.toString());
		
//		List<Project> prjList = obj.selectProjectsByEmployee("njyothi");
//		System.out.println(prjList.toString());
//		String str = obj.selectEmployeeProjectMap();
//		System.out.println(str.toString());
//		
//		
	}
}
