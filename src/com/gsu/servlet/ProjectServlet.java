package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.ProjectDao;

/**
 * Servlet implementation class ProjectServlet
 */
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// project jsp I am getting project name and project id.
		String projectName = request.getParameter("prjName");
		String projectId = request.getParameter("prjId");
		
		ProjectDao projectDaoObj = new ProjectDao();
	int rowsUpdated =	projectDaoObj.insertProject(projectName, projectId);
		
		
		//to know what type of data i am going to display in the web browser.
				response.setContentType("text/html");
		
		//to print the data i need to call getWriter() method of HttpServletResponse class with response obj.
		// --> it returns a Printwriter class referenece so I am storing it in PrintWriter class obj(writer).
		PrintWriter writer = response.getWriter();
			if(rowsUpdated > 0){
				writer.println(rowsUpdated +" rows updated successfully into Project Table."+"<br>");
			}
		writer.println("Project Name == "+projectName+"<br>");
		writer.println("Project ID == "+projectId);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
