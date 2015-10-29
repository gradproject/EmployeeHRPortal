package com.gsu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gsu.bean.WeekDays;

/**
 * Servlet implementation class InitalizeTimeSheet
 */
public class InitalizeTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public InitalizeTimeSheet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String weekIncrement = request.getParameter("weekIncrement");
		
		if(weekIncrement == null) weekIncrement = "0";
		
		HttpSession session = request.getSession();
		
		String currentWeek = (String)session.getAttribute("currentWeek");
		
		System.out.println("currentWeek = " + currentWeek);
		
		if(currentWeek == null) currentWeek = "0";
		
		int weekInc = Integer.parseInt(weekIncrement);
		
		int curWeek = Integer.parseInt(currentWeek);
		
		curWeek = curWeek + weekInc;
		
		session.setAttribute("currentWeek", Integer.toString(curWeek));
		
		
		WeekDays weekDays = new WeekDays(curWeek);
		
		request.setAttribute("sunday", weekDays.getSunday());
		request.setAttribute("monday", weekDays.getMonday());
		request.setAttribute("tuesday", weekDays.getTuesday());
		request.setAttribute("wednesday", weekDays.getWednesday());
		request.setAttribute("thursday", weekDays.getThursday());
		request.setAttribute("friday", weekDays.getFriday());
		request.setAttribute("saturday", weekDays.getSaturday());
		
		request.setAttribute("startDate", weekDays.getStartDateValue());
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/timesheet.jsp");
		rd.forward(request, response);
		
		
	}

}
