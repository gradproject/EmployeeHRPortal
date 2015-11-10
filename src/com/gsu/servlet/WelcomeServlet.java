package com.gsu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WelcomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		String applicationContext = request.getContextPath();

		Cookie cookie = new Cookie("JSESSIONID", null);
		cookie.setHttpOnly(true);
		cookie.setPath(applicationContext + "/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		response.sendRedirect("jsp/login.jsp");

	}

}
