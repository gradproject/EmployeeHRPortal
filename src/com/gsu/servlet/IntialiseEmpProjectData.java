package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Department;
import com.gsu.bean.Employee;
import com.gsu.bean.Project;
import com.gsu.dao.DepartmentDao;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.ProjectDao;


public class IntialiseEmpProjectData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public IntialiseEmpProjectData() {
        super();
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmployeeDao empDaoObj = new EmployeeDao();
		List<Employee> empList = empDaoObj.selectAllEmployee();
		
		request.setAttribute("empList", empList);
    	
    	
    	
    	DepartmentDao deptDaoObj = new DepartmentDao();
		List<Department> deptList = deptDaoObj.selectDepartment();
		
		//System.out.println("DeptList items are :: "+deptList.toString());
		//only response.setContentType is set before using PrintWriter object.
		//always setAttribute before forwarding the data to jsp.
		request.setAttribute("deptList", deptList);
		
		
		
		ProjectDao projectDaoObj = new ProjectDao();
		List<Project> projectList = projectDaoObj.selectProject();
		//System.out.println("Project List :: "+projectList.toString());
		
		request.setAttribute("prjList", projectList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/assignEmpProject.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
