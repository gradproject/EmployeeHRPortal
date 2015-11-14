package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class EmployeeConnectDao {

	public static final String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=employee_jobs_portal;";
	// protocol:typeof server://hostname:portnumber;databasename;
	public static final String dbusername = "sa";
	public static final String dbpassword = "sqladmin";
	
//public static final String connectionString = "jdbc:sqlserver://l9je6yyylp.database.windows.net:1433;database=employee_jobs_portal;user=smudunuri@l9je6yyylp;password={your_password_here};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//public static final String dbusername = "smudunuri";
//public static final String dbpassword = "Grad2015";
	
	public Connection getConnection(){
		Connection connection = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			connection = DriverManager.getConnection(connectionString,dbusername,dbpassword);
			
			System.out.println("Connection establihed successfully!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found!! "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL exception!! "+e.getMessage());
		}
		
		return connection;
		
	}
	
	public static void main(String[] args){
		EmployeeConnectDao obj = new EmployeeConnectDao();
		
		Connection connection = obj.getConnection();
		
		
	}
}
