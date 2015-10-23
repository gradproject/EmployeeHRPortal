package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.dao.TimeSheetDao;

public class EnterTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EnterTimeSheet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String empId =  request.getParameter("empId");
		String projectId = request.getParameter("projectId");
		String date = request.getParameter("date");
		String workHours = request.getParameter("workHours");
		String approved = request.getParameter("approved");
		
		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
		int rowsUpdated = timeSheetDaoObj.insertTimeSheet(empId, projectId, date, workHours, approved);
		
		PrintWriter out = response.getWriter();
		out.println(rowsUpdated+" :: rows have been successfully inserted itno time sheet table!!");
		
		System.out.println(rowsUpdated+" :: rows have been successfully inserted itno time sheet table!!");
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
