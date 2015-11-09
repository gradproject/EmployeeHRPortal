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


public class ListUnApprovedTimeSheets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListUnApprovedTimeSheets() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String projectId = request.getParameter("projectId");
	
	TimeSheetDao timesheetDaoObj = new TimeSheetDao();
	List<TimeSheet>  timesheetList = timesheetDaoObj.listunApprovedTimeSheet(projectId);
	
	request.setAttribute("timesheetList", timesheetList);
	
	
	request.setAttribute("projectId",projectId);
	
	RequestDispatcher rd = request.getRequestDispatcher("jsp/listUnApprovedTimeSheets.jsp");
	rd.forward(request, response);
	
	
	}

}
