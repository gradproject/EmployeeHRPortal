package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.ProjectDeptMapDao;
import com.sun.java.browser.net.ProxyServiceProvider;

/**
 * Servlet implementation class ProjDeptServlet
 */
public class ProjDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projectId = request.getParameter("prjId");
		String deptId = request.getParameter("deptId");
		String hoursAllocated = request.getParameter("hoursAllocated");
		
		ProjectDeptMapDao prjDeptMapObj = new ProjectDeptMapDao();
		int rowsUpdated = prjDeptMapObj.insertPrjDeptMap(projectId, deptId, hoursAllocated);
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		writer.println(rowsUpdated+" : row has been inserted in the projectDeptMap table. "+"<br>");
		writer.println("project id = "+projectId +", department id = "+deptId+", hours allocated = "+hoursAllocated);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
