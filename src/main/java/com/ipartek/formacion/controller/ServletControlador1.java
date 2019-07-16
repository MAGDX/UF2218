package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletControlador1
 */
@WebServlet("/controlador1")
public class ServletControlador1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<h1>Respuesta desde el ServletControlador</h1>");
		out.print("<hr>");
		out.print("<h2>Parametros</h2>");
		out.print("<ul>");
		
		// Obtener datos del cliente a traves de la request
		Enumeration<String> params = request.getParameterNames();
		
		while(params.hasMoreElements()) {
			String valor = params.nextElement();
			out.print("<li><b>" + valor + ": </b>" + request.getParameter(valor) + "<br></li>");
		}
		out.print("</ul>");
		
		// Dar una respuesta a traves de la response
		out.print("<h2>User Agent</h2>");
		out.print("<p>User-Agent: <b>" + request.getHeader("user-agent") + "</b></p>");
		
		// Mirar version http y mas cosas
		
		// Todos los datos de la cabecera
		out.print("<h2>Cabecera</h2>");
		out.print("<ul>");
		Enumeration<String> header = request.getHeaderNames();
		
		while(header.hasMoreElements()) {
			String valor = header.nextElement();
			out.print("<li><b>" + valor + ": </b>" + request.getHeader(valor) + "<br></li>");
		}
		out.print("</ul>");
		
		// Todos los parametros que envie el usuario
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Tenemos el GET y el POST que hacen lo mismo
		doGet(request, response);
	}
}