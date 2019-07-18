package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NombresController
 */
@WebServlet("/nombres")
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
		request.setAttribute("buscar", buscar);
		
		
		
		if(nombres.indexOf(buscar)!=-1) {
			request.setAttribute("nombres", nombres.subList(nombres.indexOf(buscar),nombres.indexOf(buscar)+1));
			request.setAttribute("mensaje", "Nombre encontrado");
		}else{
			request.setAttribute("nombres", nombres);
			if(buscar!=null) {
				request.setAttribute("mensaje", "Nombre no encontrado");
			}
		}
		
		request.getRequestDispatcher("ejemplos/nombres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		nombres.add(request.getParameter("nombre"));
		
		request.setAttribute("mensaje", "Nombre añadido");
		request.setAttribute("nombres", nombres);
		
		request.getRequestDispatcher("ejemplos/nombres.jsp").forward(request, response);
	}
}