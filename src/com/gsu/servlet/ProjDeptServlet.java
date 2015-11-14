package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.ProjectDeptMapDao;
import com.sun.java.browser.net.ProxyServiceProvider;


public class ProjDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProjDeptServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projectId = request.getParameter("prjId");
		String deptId = request.getParameter("deptId");
		String hoursAllocated = request.getParameter("hoursAllocated");
		
		ProjectDeptMapDao prjDeptMapObj = new ProjectDeptMapDao();
		int rowsUpdated = prjDeptMapObj.insertPrjDeptMap(projectId, deptId, hoursAllocated);
		
//		response.setContentType("text/html");
//		
//		PrintWriter writer = response.getWriter();
//		writer.println(rowsUpdated+" : row has been inserted in the projectDeptMap table. "+"<br>");
//		writer.println("project id = "+projectId +", department id = "+deptId+", hours allocated = "+hoursAllocated);
//		
String successMessage = " Project is successfully assigned to the Department. ProjectId =  "+projectId +", Department id = "+deptId+", Hours allocated = "+hoursAllocated ;
		
		String failureMessage = "Error!! Please check the values!!";
		
		
		if(rowsUpdated > 0){
		request.setAttribute("successMessage", successMessage);	
		}else {
			request.setAttribute("failureMessage", failureMessage);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("IntialiseProjectDeptData");
		requestDispatcher.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
