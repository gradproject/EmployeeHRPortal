package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsu.bean.Project;
import com.gsu.dao.ProjectDao;


public class ListProjectByManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListProjectByManager() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String manager = (String) session.getAttribute("empId");
		
		
	ProjectDao projectDaoObj = new ProjectDao();
	List<Project> projectList = projectDaoObj.listProjectsByManager(manager);
	
	request.setAttribute("projectList",projectList);
	
	RequestDispatcher rd = request.getRequestDispatcher("jsp/listProjectsByManager.jsp");
	rd.forward(request, response);
	
	
	}

}
