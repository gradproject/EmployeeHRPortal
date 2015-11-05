package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.Project;
import com.gsu.dao.ProjectDao;


public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProjectListServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("eneterd project list servlet");
		ProjectDao projectDaoObj = new ProjectDao();
		List<Project> projectList = projectDaoObj.selectProject();
		System.out.println("called select project list method :: "+projectList.toString());
		
		request.setAttribute("prjList", projectList);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/projectlist.jsp");
		rd.forward(request, response);
		
	}

}
