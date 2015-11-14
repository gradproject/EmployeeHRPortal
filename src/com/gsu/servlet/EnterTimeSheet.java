package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.TimeSheet;
import com.gsu.dao.TimeSheetDao;

public class EnterTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EnterTimeSheet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<TimeSheet> timeSheetList = new ArrayList<TimeSheet>();

		String empId = request.getParameter("empId");

		String approved = "0";

		Enumeration<String> names = request.getParameterNames();

		while (names.hasMoreElements()) {
			String parameterName = names.nextElement();
			String parameterValue = request.getParameter(parameterName);
			System.out.println("Parameter Name :: " + parameterName
					+ " , Parameter Value :: " + parameterValue);

			if (parameterName.indexOf("_") > -1) {

				StringTokenizer st = new StringTokenizer(parameterName, "_");
				String date = null;
				String projectId = null;
				String workHours = parameterValue;

				while (st.hasMoreTokens()) {

					String temp = st.nextToken();
					System.out.println("Token value :: " + temp);

					if (temp.indexOf("-") > -1) {
						date = temp;
					}
					try {
						Integer.parseInt(temp);
						projectId = temp;
					} catch (Exception e) {
						// do nothing exception
					}

				}
				TimeSheet timeSheetObj = new TimeSheet(empId, projectId, date,
						workHours, approved);

				timeSheetList.add(timeSheetObj);
			}
			System.out.println(parameterName + "index value :: "
					+ parameterName.indexOf("_"));

		}

		int totalRowsUpdated = 0;
		for (TimeSheet timeSheet : timeSheetList) {
			TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
			int rowsUpdated = timeSheetDaoObj.insertTimeSheet(
					timeSheet.getEmpId(), timeSheet.getProjectId(),
					timeSheet.getDate(), timeSheet.getWorkHours(),
					timeSheet.getApproved());
			totalRowsUpdated = totalRowsUpdated + rowsUpdated;

		}

//		PrintWriter out = response.getWriter();
//		out.println(totalRowsUpdated
//				+ " :: rows have been successfully inserted itno time sheet table!!");
//
//		System.out
//				.println(totalRowsUpdated
//						+ " :: rows have been successfully inserted itno time sheet table!!");

		String successMessage = " Timesheet is submitted successfully!!";

		String failureMessage = "Error!! Re-enter the timesheet";
		if (totalRowsUpdated > 0) {
			request.setAttribute("successMessage", successMessage);
		} else {
			request.setAttribute("failureMessage", failureMessage);
		}
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("InitalizeTimeSheet");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
