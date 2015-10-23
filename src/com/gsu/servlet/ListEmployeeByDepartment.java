package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Employee;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.EmployeeProjectMapDao;


public class ListEmployeeByDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListEmployeeByDepartment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		System.out.println(deptId);
		
		EmployeeDao empDaoObj = new EmployeeDao();
		List<Employee> employeeList = empDaoObj.listEmployeesByDepartment(deptId);
			
			request.setAttribute("employeeList",employeeList);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/listEmployeeByDepartment.jsp");
			requestDispatcher.forward(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
