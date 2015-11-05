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


public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeListServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDao empDaoObj = new EmployeeDao();
		List<Employee> empList = empDaoObj.selectAllEmployee();
		
		request.setAttribute("empList", empList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/employeelist.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	
	}

}
