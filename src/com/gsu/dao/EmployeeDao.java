package com.gsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gsu.bean.Employee;
import com.gsu.bean.LoginForm;

public class EmployeeDao extends EmployeeConnectDao{


	
	public List<Employee> selectManager(){
		Connection connection = getConnection();
		Statement statement = null;
		List<Employee> managerList = new ArrayList<Employee>();
		
		try{
			statement = connection.createStatement();
			String selectQuery = "select emp_id, emp_firstname from employee_jobs_portal.dbo.employee where role_id = '2';";
			ResultSet rs = statement.executeQuery(selectQuery);
			while(rs.next()){
				Employee manager = new Employee();
				manager.setEmpId(rs.getString("emp_id"));
				manager.setEmpFirstName(rs.getString("emp_firstname"));
				managerList.add(manager);
			}
			
		}catch(SQLException e){
			System.out.println("SQLException while selecting manager list from employee table. "+e.getMessage());
		}
		
		return managerList;
	}
	
	public Employee selectEmployee(String empId) {
		// String finalResult = null;
		Connection connection = getConnection();
		Statement statement = null;

		String empFirstName = null;
		String empMiddleName = null;
		String empLastName = null;
		String empEmailId = null;
		String empPhoneNumber = null;
		String deptId = null;
		String empDesg = null;
		String empExperience = null;
		String password = null;
		String roleId = null;
		String selectQuery = "select emp_id, emp_firstname, emp_middlename, emp_lastname, emp_emailid, emp_phonenumber, dept_id, emp_desg, emp_experience, password, role_id from employee_jobs_portal.dbo.employee where emp_id='"
				+ empId + "';";

		// List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee();

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectQuery);

			while (rs.next()) {
				empId = rs.getString("emp_id");
				empFirstName = rs.getString("emp_firstname");
				empMiddleName = rs.getString("emp_middlename");
				empLastName = rs.getString("emp_lastname");
				empEmailId = rs.getString("emp_emailid");
				empPhoneNumber = rs.getString("emp_phonenumber");
				deptId = rs.getString("dept_id");
				empDesg = rs.getString("emp_desg");
				empExperience = rs.getString("emp_experience");
				password = rs.getString("password");
				roleId = rs.getString("role_id");
				// finalResult = "Row selected";

				emp.setEmpId(empId);
				emp.setEmpFirstName(empFirstName);
				emp.setEmpMiddleName(empMiddleName);
				emp.setEmpLastName(empLastName);
				emp.setEmpEmailId(empEmailId);
				emp.setPhoneNumber(empPhoneNumber);
				emp.setDeptId(deptId);
				emp.setEmpDesg(empDesg);
				emp.setEmpExp(empExperience);
				emp.setPassword(password);
				emp.setRoleId(roleId);

				// empList.add(emp);

			}

			System.out.println("Employee details are :: ");
			System.out.println("first name :: " + empFirstName);
			System.out.println("middle name :: " + empMiddleName);
			System.out.println("last name :: " + empLastName);
			System.out.println("email id :: " + empEmailId);
			System.out.println("phone number :: " + empPhoneNumber);
			System.out.println("department :: " + deptId);
			System.out.println("desgination :: " + empDesg);
			System.out.println("experience :: " + empExperience);
			System.out.println("Role :: "+roleId);

		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing statement :: "
									+ e.getMessage());
				}
			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing connection :: "
									+ e.getMessage());
				}
			}

		}

		return emp;
	}

	public List<Employee> listEmployeesByDepartment(String deptId) {
		Connection connection = getConnection();
		Statement statement = null;
		List<Employee> empList = null;

		String empId = null;
		String empFirstName = null;
		String empMiddleName = null;
		String empLastName = null;
		String empEmailId = null;
		String empPhoneNumber = null;
		String empDesg = null;
		String empExperience = null;
		

		try {
			statement = connection.createStatement();
			String selectQuery = "select emp_id,emp_firstname, emp_middlename,emp_lastname,emp_emailid,emp_phonenumber,emp_desg, emp_experience from employee_jobs_portal.dbo.employee where dept_id = '"
					+ deptId + "';";

			ResultSet rs = statement.executeQuery(selectQuery);

			empList = new ArrayList<Employee>();

			while (rs.next()) {

				empId = rs.getString("emp_id");
				empFirstName = rs.getString("emp_firstname");
				empMiddleName = rs.getString("emp_middlename");
				empLastName = rs.getString("emp_lastname");
				empEmailId = rs.getString("emp_emailid");
				empPhoneNumber = rs.getString("emp_phonenumber");
				empDesg = rs.getString("emp_desg");
				empExperience = rs.getString("emp_experience");

				Employee emp = new Employee();

				emp.setEmpId(empId);
				emp.setEmpFirstName(empFirstName);
				emp.setEmpMiddleName(empMiddleName);
				emp.setEmpLastName(empLastName);
				emp.setEmpEmailId(empEmailId);
				emp.setPhoneNumber(empPhoneNumber);
				emp.setEmpDesg(empDesg);
				emp.setEmpExp(empExperience);

				empList.add(emp);

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
							.println("SQLException while closing statement :: "
									+ e.getMessage());
				}
			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing connection :: "
									+ e.getMessage());
				}
			}

		}

		return empList;
	}

	public List<Employee> selectAllEmployee() {
		// String finalResult = null;
		Connection connection = getConnection();
		Statement statement = null;

		String empId = null;
		String empFirstName = null;
		String empMiddleName = null;
		String empLastName = null;
		String empEmailId = null;
		String empPhoneNumber = null;
		String deptName = null;
		String empDesg = null;
		String empExperience = null;
		String roleName = null;
		String selectQuery = "select emp_id, emp_firstname, emp_middlename, emp_lastname, emp_emailid, emp_phonenumber, d.dept_name,emp_desg, emp_experience, password,r.role_name from employee_jobs_portal.dbo.employee as e,employee_jobs_portal.dbo.role as r, employee_jobs_portal.dbo.department as d where d.dept_id = e.dept_id and r.role_id = e.role_id ;";
		List<Employee> empList = new ArrayList<Employee>();

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectQuery);

			while (rs.next()) {
				empId = rs.getString("emp_id");
				empFirstName = rs.getString("emp_firstname");
				empMiddleName = rs.getString("emp_middlename");
				empLastName = rs.getString("emp_lastname");
				empEmailId = rs.getString("emp_emailid");
				empPhoneNumber = rs.getString("emp_phonenumber");
				deptName = rs.getString("dept_name");
				empDesg = rs.getString("emp_desg");
				empExperience = rs.getString("emp_experience");
				roleName = rs.getString("role_name");
				// finalResult = "Row selected";

				Employee emp = new Employee();
				emp.setEmpId(empId);
				emp.setEmpFirstName(empFirstName);
				emp.setEmpMiddleName(empMiddleName);
				emp.setEmpLastName(empLastName);
				emp.setEmpEmailId(empEmailId);
				emp.setPhoneNumber(empPhoneNumber);
				emp.setDeptId(deptName);
				emp.setEmpDesg(empDesg);
				emp.setEmpExp(empExperience);
				emp.setRoleId(roleName);

				empList.add(emp);

			}

			System.out.println("Employee details are :: ");
			System.out.println("emp id :: " + empId);
			System.out.println("first name :: " + empFirstName);
			System.out.println("middle name :: " + empMiddleName);
			System.out.println("last name :: " + empLastName);
			System.out.println("email id :: " + empEmailId);
			System.out.println("phone number :: " + empPhoneNumber);
			System.out.println("department :: " + deptName);
			System.out.println("desgination :: " + empDesg);
			System.out.println("experience :: " + empExperience);
			System.out.println("role :: "+roleName);

		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing statement :: "
									+ e.getMessage());
				}
			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing connection :: "
									+ e.getMessage());
				}
			}

		}

		return empList;
	}

	public int insertEmployee(String empId, String empFirstName,
			String empMiddleName, String empLastName, String empEmailId,
			String empPhoneNumber, String deptId, String empDesg,
			String empExperience, String password, String roleId) {
		int rowsUpdated = 0;
		Connection connection = getConnection();
		Statement statement = null;
		String insertQuery = "insert into employee_jobs_portal.dbo.employee (emp_id,emp_firstname, emp_middlename, emp_lastname, emp_emailid, emp_phonenumber, dept_id, emp_desg, emp_experience, password, role_id) values ('"+empId+"','"+empFirstName+"','"+empMiddleName+"','"+empLastName+"','"+empEmailId+"','"+empPhoneNumber+"','"+deptId+"','"+empDesg+"','"+empExperience+"','"+password+"','"+roleId+"');";
		try {
			statement = connection.createStatement();
			rowsUpdated = statement.executeUpdate(insertQuery);
			System.out
					.println(rowsUpdated
							+ " rows have been successfully inserted into Employee Table ");

		} catch (SQLException e) {
			System.out.println("SQLException while creating statement :: "
					+ e.getMessage());
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing statement :: "
									+ e.getMessage());
				}
			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out
							.println("SQLException while closing connection :: "
									+ e.getMessage());
				}
			}

		}

		return rowsUpdated;
	}

	public int updateEmployee(String empId, String empFirstName,
			String empMiddleName, String empLastName, String empEmailId,
			String phoneNumber, String deptId, String empDesg, String empExp, String roleId) {

		int rowsUpdated = 0;
		Connection connection = getConnection();
		Statement statement = null;
		String updateQuery = "update employee_jobs_portal.dbo.employee set emp_firstname ='"
				+ empFirstName
				+ "', emp_middlename='"
				+ empMiddleName
				+ "', emp_lastname='"
				+ empLastName
				+ "', emp_emailid='"
				+ empEmailId
				+ "',emp_phonenumber='"
				+ phoneNumber
				+ "',emp_desg='"
				+ empDesg
				+ "', emp_experience='"
				+ empExp
				+ "',dept_id='" + deptId + "', role_id='"+roleId+"' where emp_id ='" + empId + "';";
		try {
			statement = connection.createStatement();
			rowsUpdated = statement.executeUpdate(updateQuery);

			System.out.println(rowsUpdated
					+ " : rows have been updated in employee tabble.");
		} catch (SQLException e) {
			System.out.println("SQLException while creating an exception");
		} finally {
			if (statement == null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("SQLException while closing statement "
							+ e.getMessage());
				}
			}
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("SQLException while closing connecion "
							+ e.getMessage());
				}

			}
		}

		return rowsUpdated;
	}

	public boolean validateProfileExists(String empId) {

		EmployeeDao employeeDaoObj = new EmployeeDao();

		Employee employeeObj = employeeDaoObj.selectEmployee(empId);

		if (employeeObj != null) {

			String databaseEmpId = employeeObj.getEmpId();
			if (databaseEmpId != null && empId != null) {
				if (empId.equalsIgnoreCase(databaseEmpId)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean validatePassword(LoginForm loginForm) {
		boolean profileExists = false;
		String loginEmpId = loginForm.getEmpId();

		if (loginEmpId != null) {
			EmployeeDao empLoginDaoObj = new EmployeeDao();
			Employee employeeObj = empLoginDaoObj.selectEmployee(loginEmpId);

			if (employeeObj != null) {

				String loginPassword = loginForm.getPassword();
				String registeredPassword = employeeObj.getPassword();
				if (registeredPassword.equals(loginPassword)) {

					EmployeeDao employeeDaoObj = new EmployeeDao();

					 profileExists = employeeDaoObj
							.validateProfileExists(employeeObj.getEmpId());

				

				}

			}

		}

		return profileExists;
	}

	public static void main(String[] args) {
		EmployeeDao obj = new EmployeeDao();
		// int result =
		// obj.updateEmployee("divakar","divakar","sri","mudunuri","sri_divakar@gmail.com","452523523523","10","Developer","8");

		// String result = obj.selectEmployee("dmudunuri");
		// int result = obj.insertEmployee("divakar","Divakar","","Mudunuri",
		// "divakar@gmail.com","342341421421","dev", "Sr.Java Developer","8");
		
//		List<Employee> empList = obj.selectAllEmployee();
//		System.out.println(empList.toString());
		
		List<Employee> managerList = obj.selectManager();
		System.out.println(managerList.toString());
	}

}
