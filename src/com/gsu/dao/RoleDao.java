package com.gsu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsu.bean.Role;

public class RoleDao extends EmployeeConnectDao{
	
	
	public Role selectRole(String empId){
		Connection connection = getConnection();
		Statement statement = null;
		Role roleObj = new Role();
		try{
		statement = connection.createStatement();
		String selectQuery = "select r.role_id, r.role_name from employee_jobs_portal.dbo.role as r, employee_jobs_portal.dbo.employee as e where r.role_id = e.role_id and e.emp_id = '"+empId+"';";
		ResultSet rs = statement.executeQuery(selectQuery);
		while(rs.next()){
			
			roleObj.setRoleId(rs.getString("role_id"));
			roleObj.setRoleName(rs.getString("role_name"));
		}
		System.out.println("Role values are : "+roleObj.toString());
		}catch(SQLException e){
			System.out.println("SQLException while creating statement :: "+e.getMessage());
		}
		
		return roleObj;
	}
	
	public static void main(String[] args){
		RoleDao roleDaoObj = new RoleDao();
		Role Role = roleDaoObj.selectRole("rmudunuri");
	}

}
