package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsu.bean.Employee;
import com.gsu.bean.LoginForm;
import com.gsu.bean.Role;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.RoleDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String empId = request.getParameter("empId");
		String password = request.getParameter("password");

		LoginForm loginForm = new LoginForm();
		loginForm.setEmpId(empId);
		loginForm.setPassword(password);

		if (empId == null || password == null) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/jsp/login.jsp");
			request.setAttribute("failureMessage",
					"Employee Id, and  Password are required, Please try again.");

			request.setAttribute("empId", empId);
			requestDispatcher.forward(request, response);
		} else {
			if ("".equals(empId.trim()) || "".equals(password.trim())) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/jsp/login.jsp");

				request.setAttribute("empId", empId);
				request.setAttribute("failureMessage",
						"Employee Id, and  Password are required, Please try again.");
				requestDispatcher.forward(request, response);
			}
		}

		EmployeeDao employeeDaoObj = new EmployeeDao();
		String targetPage = employeeDaoObj.validatePassword(loginForm);
		Employee employeeObj = employeeDaoObj.selectEmployee(empId);
		String empName = "";

		if (employeeObj != null) {
			empName = (employeeObj.getEmpFirstName() != null ? employeeObj
					.getEmpFirstName() : "")
					+ " "
					+ (employeeObj.getEmpMiddleName() != null ? employeeObj
							.getEmpMiddleName() : "")
					+ " "
					+ (employeeObj.getEmpLastName() != null ? employeeObj
							.getEmpLastName() : "");
			System.out.println("Target Page :: " + targetPage);
		}

		request.setAttribute("empId", empId);
		RequestDispatcher requestDispatcherObj = request
				.getRequestDispatcher("/jsp/" + targetPage);
		String failureMessage = "Login was unsuccessful. Please try again";
		if ("login.jsp".equals(targetPage)) {

			request.setAttribute("empId", empId);
			request.setAttribute("failureMessage", failureMessage);
			requestDispatcherObj.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			
			
			session.setAttribute("userLoggedIn", "true");
			session.setAttribute("empId", empId);
			session.setAttribute("empName", empName);
			
			RoleDao roleDaoObj = new RoleDao();
			Role roleObj = roleDaoObj.selectRole(empId);
			session.setAttribute("role",roleObj.getRoleName());

			
			if ("employeelist.jsp".equalsIgnoreCase(targetPage)) {
				EmployeeDao emplyeeDaoObj = new EmployeeDao();
				List<Employee> employeeList = employeeDaoObj
						.selectAllEmployee();
				request.setAttribute("empList", employeeList);
			}
			requestDispatcherObj.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
