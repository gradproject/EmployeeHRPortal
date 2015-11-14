package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsu.bean.Admin;
import com.gsu.bean.AdminLoginForm;
import com.gsu.bean.Employee;
import com.gsu.dao.AdminDao;
import com.gsu.dao.EmployeeDao;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminUserName = request.getParameter("adminUserName");
		String adminPassword = request.getParameter("adminPassword");

		System.out.println(adminUserName + " , "+adminPassword);
		
		
		
		AdminLoginForm adminLoginForm = new AdminLoginForm();
		adminLoginForm.setAdminUserName(adminUserName);
		adminLoginForm.setAdminPassword(adminPassword);

		if (adminUserName == null || adminPassword == null) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/adminLogin.jsp");
			request.setAttribute("failureMessage",
					"Admin User Name, and  Password are required, Please try again.");

			request.setAttribute("adminUserName", adminUserName);
			requestDispatcher.forward(request, response);
		} else {
			if ("".equals(adminUserName.trim())
					|| "".equals(adminPassword.trim())) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/jsp/adminLogin.jsp");

				request.setAttribute("adminUserName", adminUserName);
				request.setAttribute("failureMessage",
						"Admin User Name, and  Password are required, Please try again.");
				requestDispatcher.forward(request, response);
			}
		}

		AdminDao adminDaoObj = new AdminDao();
		String targetPage = adminDaoObj.validatePassword(adminLoginForm);
		Admin adminObj = adminDaoObj.selectAdmin(adminUserName);

		
		
		if (adminObj != null) {

			System.out.println("Target Page :: " + targetPage);
		}
System.out.println("target page one= "+targetPage);
		request.setAttribute("adminUserName", adminUserName);
		
		String failureMessage = "Login was unsuccessful. Please try again";
		if ("adminLogin.jsp".equals(targetPage)) {
			System.out.println("target page two = "+targetPage);
			request.setAttribute("adminUserName", adminUserName);
			request.setAttribute("failureMessage", failureMessage);
			targetPage = "jsp/adminLogin.jsp";
			RequestDispatcher requestDispatcherObj = request
					.getRequestDispatcher("/" + targetPage);
			
			requestDispatcherObj.forward(request, response);
		} else {
			System.out.println("target page three = "+targetPage);
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", "true");
			session.setAttribute("adminUserName", adminUserName);
			session.setAttribute("role","admin");
			
			targetPage = "/EmployeeListServlet";
			RequestDispatcher requestdispatcherObj = request
					.getRequestDispatcher("/" + targetPage);
			
				requestdispatcherObj.forward(request, response);
			}
		}

	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
