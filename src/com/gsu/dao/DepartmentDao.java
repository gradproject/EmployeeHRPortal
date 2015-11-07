package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsu.bean.Department;

public class DepartmentDao extends EmployeeConnectDao{
	
	
	public int insertDept(String deptName, String deptId){
		
		int rowsUpdated = 0;
		Connection connection = getConnection();
		Statement statement = null;
		String insertQuery = "insert into employee_jobs_portal.dbo.department (dept_name,dept_id) values ('"+deptName+"','"+deptId+"');";
		try {
			statement = connection.createStatement();
		rowsUpdated = 	statement.executeUpdate(insertQuery);
		System.out.println("This is DepartmentDao and rowsUpdated = "+rowsUpdated);
			
		} catch (SQLException e) {
			System.out.println("SQLException :: "+e.getMessage());
		}finally {
			if(statement == null){
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("SQL exception while closing statement : "+e.getMessage());
				}
			}if(connection == null){
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("SQL exception while closing connection : "+e.getMessage());
				}
			}
		}
		
		
		return  rowsUpdated;
	}
	
	public List<Department> selectDepartment(){
		//String finalResult = null;
		String deptName = null;
		String deptId = null;
		Connection connection = getConnection();
		Statement statement = null;
		String selectQuery = "select dept_name,dept_id from employee_jobs_portal.dbo.department;"; 
		
		
		List<Department> deptList = new ArrayList<Department>();
		
				try {
					statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(selectQuery);
					while(rs.next()){
					
						deptName= rs.getString("dept_name");
						deptId= rs.getString("dept_id");
						
						Department departmentObj = new Department();//we created department class object in while loop because
						//we will be creating a new object for department class while retrieving each row from department table.
						
						departmentObj.setDeptName( deptName);
						departmentObj.setDeptId( deptId);
					System.out.println("Department name is :: "+deptName+", department id = "+deptId);
						deptList.add(departmentObj);
						//we wrote listObj.add(beanObj) in while loop 
						//because we will add each row of department table in ArrayList.
						//finalResult = "row selected";
					}
					
				} catch (SQLException e) {
					System.out.println("SQLException while creating statement ::"+e.getMessage());
				}finally{
					if(statement == null){
						try {
							statement.close();
						} catch (SQLException e) {
							System.out.println("SQLException while closing statement :: "+e.getMessage());
						}
					}if(connection == null){
						try {
							connection.close();
						} catch (SQLException e) {
							System.out.println("SQLException while closing connection :: "+e.getMessage());
						}
					}
				}
		
		return deptList;
	}
	
	public static void main(String[] args){
		DepartmentDao obj = new DepartmentDao();
		//int result = obj.insertDept("Biology", "8");
		List<Department> deptList = obj.selectDepartment();
		System.out.println(deptList.toString());
		
	}
	
	
}
