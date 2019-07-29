package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class AhorcadoController
 */
@WebServlet("/ahorcar")
public class AhorcadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int VIDAS_MAXIMAS = 9;
	private static int vidas;
	private static String palabraAdivinar = "viernes";
	private static char[] letras;
	private static char[] letrasOcultas;
	private static char letra;
	private static boolean fallo;
	private static int win;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AhorcadoController() {
        super();
        vidas = VIDAS_MAXIMAS;
        fallo = false;
        win = 0;
        letras = new char[palabraAdivinar.length()];
		letrasOcultas = new char[palabraAdivinar.length()];
		rellenar();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fallo = true;
		letra = request.getParameter("letra").toLowerCase().charAt(0);

		for (int i = 0; i < letras.length; i++) {
			if (letra == letras[i]) {
				letrasOcultas[i] = letras[i];
				fallo = false;
				win++;
			}
		}
		
		if (fallo) {
			vidas--;
			if (vidas==0) {
				new Alert("warning","HAS PERDIDO!!!");
			}
		}
		
		if (win==letrasOcultas.length) {
			new Alert("success","HAS GANADO!!!");
		}
		
		
		request.setAttribute("palabra", pasarAString(letrasOcultas));
		request.setAttribute("vidasRestantes", vidas);
		
		request.getRequestDispatcher("ahorcado/ahorcado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static void rellenar() {
		for (int i = 0; i < palabraAdivinar.length(); i++) {
			letras[i] = palabraAdivinar.charAt(i);
			letrasOcultas[i] = '_';
		}
	}
	
	private static String pasarAString(char[] cadena) {
		String palabra = "";
		
		//Pasar cadena a string
		for(int i = 0; i < cadena.length;i++) {
			palabra = palabra + cadena[i];
		}
		
		return palabra;
	}
}