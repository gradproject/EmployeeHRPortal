package com.gsu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.TimeSheet;
import com.gsu.dao.TimeSheetDao;

public class DisplayTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayTimeSheet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		String empId = request.getParameter("empId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		
		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
			List<TimeSheet> timeSheetList = timeSheetDaoObj.selectTimeSheet(empId,startDate,endDate);
			
			request.setAttribute("timeSheetList", timeSheetList);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/displayTimeSheet.jsp");
			requestDispatcher.forward(request,response);
			
	}
}
