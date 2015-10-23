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
import com.gsu.bean.Project;
import com.gsu.dao.DepartmentDao;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.EmployeeProjectMapDao;
import com.gsu.dao.ProjectDao;

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
		
		
		

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
