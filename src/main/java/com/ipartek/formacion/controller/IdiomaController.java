package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IdiomaController
 */
@WebServlet("/i18n")
public class IdiomaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idiomaSeleccionado = request.getParameter("idiomaSeleccionado");
		
		String ruta = request.getParameter("ruta");
		ruta = ruta.split("uf2218/")[1];
		
		if(idiomaSeleccionado == null) {
			idiomaSeleccionado = "eu_ES";
		}
		
		Locale locale = new Locale(idiomaSeleccionado.split("_")[0], idiomaSeleccionado.split("_")[1]);
		ResourceBundle properties = ResourceBundle.getBundle("i18n/i18nmessages", locale);
		
		request.setAttribute("mensajeIdioma", properties.getString("menu.inicio"));
		
		// Guardamos el idioma seleccionado en la sesion
		HttpSession sesion = request.getSession();
		sesion.setAttribute("language", idiomaSeleccionado);
		
		if ( ruta != null ) {
			request.getRequestDispatcher(ruta).forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}