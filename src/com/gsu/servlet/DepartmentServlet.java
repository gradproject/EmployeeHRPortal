package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.DepartmentDao;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		//to get the deptName from department.jsp we write getParameter().
		String departmentName = request.getParameter("deptName");
		String departmentId = request.getParameter("deptId");
		
		DepartmentDao deptDaoObj = new DepartmentDao();
		int rowsUpdated = deptDaoObj.insertDept(departmentName, departmentId);
			
		
		response.setContentType("text/html");
		// to know what type of content we are going to display in the web browser.
		
		// to print these parameters we write response.getWriter() ---> this returns PrintWriter class reference 
		//so we created a reference of PrintWriter and stored it.
		PrintWriter writer = response.getWriter();
		
			if(rowsUpdated > 0){
				writer.println(rowsUpdated+" :: row successfully inserted into Department Table."+"<br>");
			}
		writer.println("department Name == "+departmentName+"<br>");
		writer.println("department Id == "+departmentId);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
