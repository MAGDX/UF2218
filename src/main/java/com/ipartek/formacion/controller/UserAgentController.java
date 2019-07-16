package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAgentController
 */
@WebServlet("/useragent")
public class UserAgentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userAgent = request.getHeader("user-agent").toLowerCase();
		request.setAttribute("disp", "desktop");
		
		if(userAgent.contains("firefox")) {
			request.setAttribute("navegador", "Firefox");
			request.setAttribute("icono", "firefox");
		}else if(userAgent.contains("opr")) {
			request.setAttribute("navegador", "Opera");
			request.setAttribute("icono", "opera");
		}else if(userAgent.contains("chrome")) {
			request.setAttribute("navegador", "Chrome");
			request.setAttribute("icono", "chrome");
		}else if(userAgent.contains("trident")) {
			request.setAttribute("navegador", "IE");
			request.setAttribute("icono", "internet-explorer");
		}else {
			request.setAttribute("navegador", "Otro");
			request.setAttribute("icono", "firefox");
		}
		
		if(userAgent.contains("mobile")) {
			request.setAttribute("disp", "mobile-alt");
		}
		
		request.getRequestDispatcher("ejemplos/basico2.jsp").forward(request, response);
	}
}