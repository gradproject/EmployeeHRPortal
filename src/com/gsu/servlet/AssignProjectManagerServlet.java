package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Employee;
import com.gsu.bean.Project;
import com.gsu.dao.EmployeeDao;
import com.gsu.dao.ProjectDao;
import com.gsu.dao.ProjectManagerMapDao;


public class AssignProjectManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AssignProjectManagerServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String empId = request.getParameter("empId");
		String projectId = request.getParameter("prjId");
		
		System.out.println("servlet project id = "+projectId+", emp id = "+empId);
		ProjectManagerMapDao projManagerMapDaoObj = new ProjectManagerMapDao();
		int rowsUpdated = projManagerMapDaoObj.insertProjectManager(empId, projectId);
		
		EmployeeDao empDaoObj = new EmployeeDao();
		List<Employee> managerList = empDaoObj.selectManager();
		System.out.println("servlet "+managerList.toString());
		
		ProjectDao projectDaoObj = new ProjectDao();
		List<Project> projectList = projectDaoObj.selectProject();
		System.out.println("servlet "+projectList.toString());
		
			
		
		String successMessage = null;
		String failureMessage = null;
		if(rowsUpdated > 0){
			successMessage = "manager is assigned to project successfully.";
			request.setAttribute("successMessage", successMessage);
		}else if(rowsUpdated < 0){
			failureMessage = "Error!!. Manager already assigned to that project.";
			request.setAttribute("failureMessage", failureMessage);
			
		}
		else {
			failureMessage = "Error!!. Please re-enter data.";
			request.setAttribute("failureMessage", failureMessage);
			
		}
		
		request.setAttribute("managerList", managerList);
		request.setAttribute("projectList",projectList);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/assignProjectManager.jsp");
		rd.forward(request, response);
		
	}

}
