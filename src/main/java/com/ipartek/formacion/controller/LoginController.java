package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		if ("admin".equalsIgnoreCase(user.toLowerCase()) && "admin".equalsIgnoreCase(pass.toLowerCase())) {
			HttpSession sesion = request.getSession();
			//sesion.setMaxInactiveInterval(X); Cambia el tiempo de sesion de inactividad antes de caducarse a X segundos
			
			sesion.setAttribute("user", "user"+request.getRemoteAddr());
			
			request.setAttribute("mensaje", new Alert("success", "Sesión iniciada con exito!"));
			String callback = (String) sesion.getAttribute("callback");
			
			if ( callback == null ) {
				response.sendRedirect("backoffice/index.jsp");
			}else {
				sesion.removeAttribute("callback");				
				response.sendRedirect(callback);
			}
		} else {
			request.setAttribute("mensaje", new Alert("danger", "Usuario y/o contraseña erroneos"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}