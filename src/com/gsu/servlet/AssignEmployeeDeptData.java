package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsu.bean.Department;
import com.gsu.bean.Employee;
import com.gsu.bean.Role;
import com.gsu.dao.DepartmentDao;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.RoleDao;

public class AssignEmployeeDeptData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AssignEmployeeDeptData() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			
		
		String empId = request.getParameter("empId");

		DepartmentDao deptDaoObj = new DepartmentDao();
		List<Department> deptList = deptDaoObj.selectDepartment();

		request.setAttribute("deptList", deptList);
		RoleDao roleDaoObj = new RoleDao();
		List<Role> roleList = roleDaoObj.selectRoles();
		request.setAttribute("roleList", roleList);

		if (empId == null) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("jsp/employee.jsp");
			requestDispatcher.forward(request, response);

		} else {
			EmployeeDao empDaoObj = new EmployeeDao();

			Employee emp = empDaoObj.selectEmployee(empId);

			request.setAttribute("emp", emp);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("jsp/empupdate.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
