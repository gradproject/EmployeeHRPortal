package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.EmployeeProjectMapDao;

public class AssignEmployeeProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AssignEmployeeProject() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String deptId = request.getParameter("deptId");
		String projectId = request.getParameter("prjId");
		
		
		
		EmployeeProjectMapDao empProjectMapDaoObj = new EmployeeProjectMapDao();
	int rowsUpdated =	empProjectMapDaoObj.insertEmployeeProjectMap(empId,  deptId,  projectId);
	
	response.setContentType("text/html");
	
	PrintWriter writer = response.getWriter();
	writer.println(rowsUpdated+" : row has been inserted in the projectDeptMap table. "+"<br>");
	writer.println("project id = "+projectId +", department id = "+deptId+", emp id = "+empId);
		
		String successMessage = "Employee is added to the project";
		
		String failureMessage = "Error!! Please re-enter the values";
		
		
		if(rowsUpdated > 0){
		request.setAttribute("successMessage", successMessage);	
		}else {
			request.setAttribute("failureMessage", failureMessage);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("IntialiseEmpProjectData");
		requestDispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
