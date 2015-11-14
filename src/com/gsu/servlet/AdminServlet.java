package com.gsu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.AdminDao;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminUserName = request.getParameter("adminUserName");
		String adminPassword = request.getParameter("password");
		
		AdminDao adminDaoObj = new AdminDao();
	int rowsUpdated =	adminDaoObj.insertAdmin(adminUserName, adminPassword);
	//System.out.println(rowsUpdated+" : rows have been inserted into admin table. ");
	response.setContentType("text/html");
	String successMessage = rowsUpdated+" :: rows updated successfully into Admin Table.";
	
	String failureMessage = "Dulpicate Value. Please enter the values again!!";
	if(rowsUpdated > 0){
		 request.setAttribute("successMessage",successMessage);
	} else {
	request.setAttribute("failureMessage",failureMessage);
	}
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin.jsp");
	requestDispatcher.forward(request, response);
		
	}

}
