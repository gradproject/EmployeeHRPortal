package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gsu.bean.Admin;
import com.gsu.bean.AdminLoginForm;
import com.gsu.bean.Employee;

public class AdminDao extends EmployeeConnectDao{

	

	public Admin selectAdmin(String adminUserName){
		Connection connection = getConnection();
		Statement statement = null;
		String adminPassword = null;
		Admin adminObj = null;

		try {
			statement = connection.createStatement();
			String selectQuery = "select * from employee_jobs_portal.dbo.admin where admin_username = '"+adminUserName+"';";

			ResultSet rs = statement.executeQuery(selectQuery);

			while (rs.next()) {
				adminUserName = rs.getString("admin_username");
				adminPassword = rs.getString("admin_password");

				adminObj = new Admin();
				adminObj.setAdminUserName(adminUserName);
				adminObj.setAdminPassword(adminPassword);
				System.out.println(adminObj.toString());

			}
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		}

		return adminObj;

	}
	
	
	public Admin selectAdmin() {
		Connection connection = getConnection();
		Statement statement = null;
		String adminUserName = null;
		String adminPassword = null;
		Admin adminObj = null;

		try {
			statement = connection.createStatement();
			String selectQuery = "select * from employee_jobs_portal.dbo.admin;";

			ResultSet rs = statement.executeQuery(selectQuery);

			while (rs.next()) {
				adminUserName = rs.getString("admin_username");
				adminPassword = rs.getString("admin_password");

				adminObj = new Admin();
				adminObj.setAdminUserName(adminUserName);
				adminObj.setAdminPassword(adminPassword);
				System.out.println(adminObj.toString());

			}
		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		}

		return adminObj;

	}
	
	public int insertAdmin(String adminUserName, String adminPassword){
		int numberOfRowsUpdated = 0;
		Connection connection = getConnection();
		Statement statement = null;
		
		
		try {
			statement = connection.createStatement();
			String insertQuery = "insert into employee_jobs_portal.dbo.admin (admin_username, admin_password) values ('"+adminUserName+"','"+adminPassword+"');";
			numberOfRowsUpdated = statement.executeUpdate(insertQuery);
			System.out.println(numberOfRowsUpdated +" :: rows have been inserted into admin table. ");
		} catch (SQLException e) {
		System.out.println("SQLException while creating statement :: "+e.getMessage());
		}
		
		
		return numberOfRowsUpdated;
	}
	
	public boolean validateProfileExists(String adminUserName) {

		AdminDao adminDaoObj = new AdminDao();

		Admin adminObj = adminDaoObj.selectAdmin(adminUserName);

		if (adminObj != null) {

			String databaseAdminUserName = adminObj.getAdminUserName();
			if (databaseAdminUserName != null && adminUserName != null) {
				if (adminUserName.equalsIgnoreCase(databaseAdminUserName)) {
					return true;
				}
			}
		}

		return false;
	}

	public String validatePassword(AdminLoginForm adminLoginForm) {
		String targetPage = "adminLogin.jsp";
		String loginAdminUserName = adminLoginForm.getAdminUserName();

		if (loginAdminUserName != null) {
			AdminDao adminDaoObj = new AdminDao();
			Admin adminObj = adminDaoObj.selectAdmin(loginAdminUserName);

			if (adminObj != null) {

				String loginAdminPassword = adminLoginForm.getAdminPassword();
				String registeredAdminPassword = adminObj.getAdminPassword();
				if (registeredAdminPassword.equals(loginAdminPassword)) {

					AdminDao admindaoObj = new AdminDao();

					boolean profileExists = admindaoObj
							.validateProfileExists(adminObj.getAdminUserName());
					

					if (profileExists) {
						targetPage = "";
					} else {
						targetPage = "adminLogin.jsp";
					}

				}

			}

		}

		return targetPage;
	}
	
	public static void main(String[] args) {
		AdminDao adminDaoObj = new AdminDao();
		//adminDaoObj.selectAdmin();
		//adminDaoObj.insertAdmin("MSha","MSha");
		Admin admin = adminDaoObj.selectAdmin();
		System.out.println(admin.toString());
	}

}
