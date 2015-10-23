package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Department;
import com.gsu.bean.Project;
import com.gsu.dao.DepartmentDao;
import com.gsu.dao.ProjectDao;

/**
 * Servlet implementation class IntialiseProjectDeptData
 */
public class IntialiseProjectDeptData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntialiseProjectDeptData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		DepartmentDao deptDaoObj = new DepartmentDao();
		List<Department> deptList = deptDaoObj.selectDepartment();
		
		//only response.setContentType is set before using PrintWriter object.
		//always setAttribute before forwarding the data to jsp.
		request.setAttribute("deptList", deptList);
		
		ProjectDao projectDaoObj = new ProjectDao();
		List<Project> projectList = projectDaoObj.selectProject();
		
		request.setAttribute("prjList", projectList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/prjdeptmap.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(request,response);
	}

}
