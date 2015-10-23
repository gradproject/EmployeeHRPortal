package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Employee;
import com.gsu.dao.EmployeeProjectMapDao;

public class ListEmployeeByProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListEmployeeByProject() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	String projectId = request.getParameter("projectId");
	System.out.println(projectId);
	
	EmployeeProjectMapDao empProjectMapDaoObj = new EmployeeProjectMapDao();
List<Employee> employeeList = empProjectMapDaoObj.selectEmployeesByProject(projectId);
	
	request.setAttribute("employeeList",employeeList);
	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/listEmployeeByProject.jsp");
	requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
