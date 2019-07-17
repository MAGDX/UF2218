package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NombresController
 */
@WebServlet("nombres")
public class NombresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> nombres;
	
	public NombresController() {
		nombres = new ArrayList<String>();
		nombres.add("Manolo");
		nombres.add("Pepito");
		nombres.add("Ursiciano");
		nombres.add("Agapito");		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buscar = request.getParameter("buscar");
		
		request.setAttribute("mensaje", "TODO_mensaje");
		request.setAttribute("buscar", buscar);
		request.setAttribute("nombres", nombres);
		
		request.getRequestDispatcher("ejemplos/nombres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}