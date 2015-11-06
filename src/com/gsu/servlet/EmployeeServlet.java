package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Department;
import com.gsu.bean.Employee;
import com.gsu.dao.DepartmentDao;
import com.gsu.dao.EmployeeDao;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public EmployeeServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String empId = request.getParameter("empId");
		String empFirstName = request.getParameter("empFirstName");
		String empMiddleName = request.getParameter("empMiddleName");
		String empLastName = request.getParameter("empLastName");
		String empEmailId = request.getParameter("empEmailId");
		String phoneNumber = request.getParameter("phoneNumber");
		String deptId = request.getParameter("deptId");
		String empDesg = request.getParameter("empDesg");
		String empExp = request.getParameter("empExp");
		String password = request.getParameter("password");
		String submitValue = request.getParameter("submit");
		
		System.out.println(empId+" = emp id, first name = "+ empFirstName+" middle name = "+empMiddleName+" last name ="+empLastName+"email id = "+empEmailId+" phone number = "+phoneNumber+" dept id =  "+deptId+" designation =  "+empDesg+" experience = "+empExp);

		System.out.println("Submit Value == " + submitValue);

		EmployeeDao empDaoObj = new EmployeeDao();
		int rowsUpdated = 0;
		String successMessage = "";
		if ("Create".equals(submitValue)) {
			rowsUpdated = empDaoObj.insertEmployee(empId, empFirstName,
					empMiddleName, empLastName, empEmailId, phoneNumber,
					deptId, empDesg, empExp, password);
			successMessage = rowsUpdated
					+ " rows have been successfully inserted into Employee Table "
					+ "<br>";
		} else if ("Update".equals(submitValue)) {
			rowsUpdated = empDaoObj.updateEmployee(empId, empFirstName,
					empMiddleName, empLastName, empEmailId, phoneNumber,
					deptId, empDesg, empExp);
			successMessage = rowsUpdated
					+ " rows have been successfully updated into Employee Table "
					+ "<br>";
		}

		if (rowsUpdated > 0) {
			request.setAttribute("successMessage", successMessage);
			List<Employee> empList = empDaoObj.selectAllEmployee();
			request.setAttribute("empList", empList);
			 RequestDispatcher requestDispatcher =
			 request.getRequestDispatcher("jsp/employeelist.jsp");
			 requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("failureMessage", "Error occured, please try again.");
			 if("Create".equals(submitValue)){
			 RequestDispatcher requestDispatcher =
			 request.getRequestDispatcher("jsp/employee.jsp");
			 requestDispatcher.forward(request, response);
			 }else if("Update".equals(submitValue)){
			 RequestDispatcher requestDispatcher =
			 request.getRequestDispatcher("AssignEmployeeDeptData?empId="+empId);
			 requestDispatcher.forward(request, response);
			
			 }			
		}



		// to print these details we need to call the getWriter() method of the
		// HttpservletResponse class
		// --> this method returns PrintWriter class obj so writer is
		// PrintWriter class obj and we are storing it in it.
		// PrintWriter writer = response.getWriter();
		// writer.println(rowsUpdated+" rows have been successfully inserted into Employee Table "+"<br>");
		// writer.println(empId+","+empFirstName+","+empMiddleName+","+empLastName+","+empEmailId+","+phoneNumber+","+deptId+","+empDesg+","+empExp);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
