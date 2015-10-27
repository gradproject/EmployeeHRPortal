package com.gsu.servlet;

import java.io.IOException;

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
		String adminUserName = request.getParameter("adminUserName");
		String adminPassword = request.getParameter("password");
		
		AdminDao adminDaoObj = new AdminDao();
	int rowsUpdated =	adminDaoObj.insertAdmin(adminUserName, adminPassword);
	System.out.println(rowsUpdated+" : rows have been inserted into admin table. ");
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
