package com.gsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsu.bean.TimeSheet;
import com.gsu.dao.TimeSheetDao;


public class ApproveTimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ApproveTimeSheet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] approveTimeSheet =  request.getParameterValues("approveTimeSheet");
		
		TimeSheetDao timeSheetDaoObj = new TimeSheetDao();
			
		for(int i = 0; i < approveTimeSheet.length; i++){
			//System.out.println("Parameters Are :: "+approveTimeSheet[i]);
			String temp = approveTimeSheet[i];
			StringTokenizer st = new StringTokenizer(temp,"_");
			
			int j = 0;
			
			TimeSheet timeSheetObj = new TimeSheet();
			
			while(st.hasMoreTokens()){
				
				String token = st.nextToken();
				if(j == 0){
					timeSheetObj.setProjectId(token);
				}else if(j == 1){
					timeSheetObj.setEmpId(token);
				}else if( j == 2){
					timeSheetObj.setDate(token);
				}
				
				j++;
			}
			System.out.println(timeSheetObj.toString());
			
			int timeSheetsApproved = timeSheetDaoObj.approveTimeSheet(timeSheetObj.getProjectId(),timeSheetObj.getEmpId(), timeSheetObj.getDate());
			
			PrintWriter out = response.getWriter();
			out.println(timeSheetsApproved+" timeSheets have been approved");
		}
	}

}
