package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Department;
import com.gsu.dao.DepartmentDao;


public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepartmentListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DepartmentDao deptDaoObj = new DepartmentDao();
		List<Department> deptList = deptDaoObj.selectDepartment();
		
		request.setAttribute("deptList", deptList);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/departmentlist.jsp");
		rd.forward(request,response);
		
	}

}
