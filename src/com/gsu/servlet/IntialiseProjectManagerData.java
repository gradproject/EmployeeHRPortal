package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Employee;
import com.gsu.bean.Project;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.ProjectDao;


public class IntialiseProjectManagerData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IntialiseProjectManagerData() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmployeeDao empDaoObj = new EmployeeDao();
		List<Employee> managerList = empDaoObj.selectManager();
		System.out.println("servlet "+managerList.toString());
		
		ProjectDao projectDaoObj = new ProjectDao();
		List<Project> projectList = projectDaoObj.selectProject();
		System.out.println("servlet "+projectList.toString());
		
		request.setAttribute("managerList", managerList);
		request.setAttribute("projectList",projectList);
		

		RequestDispatcher rd = request.getRequestDispatcher("jsp/assignProjectManager.jsp");
		rd.forward(request, response);
	}

}
