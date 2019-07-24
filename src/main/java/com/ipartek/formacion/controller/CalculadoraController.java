package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/calcular")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final char OP_SUMAR = 's';
	private static final char OP_RESTAR = 'r';
	private static final char OP_MULTIPLICAR = 'm';
	private static final char OP_DIVIDIR = 'd';

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Calculando...");
		float n1 = Integer.parseInt(request.getParameter("n1"));
		float n2 = Integer.parseInt(request.getParameter("n2"));
		String res;
		char op = request.getParameter("op").toLowerCase().charAt(0);
		
		switch (op) {
		case OP_SUMAR:
			res = Float.toString(n1 + n2);
			break;
		case OP_RESTAR:
			res = Float.toString(n1 - n2);
			break;
		case OP_MULTIPLICAR:
			res = Float.toString(n1 * n2);
			break;
		case OP_DIVIDIR:
			if(n2 != 0) {
				res = Float.toString(n1 / n2);
			}else {
				res = "El divisor no puede ser 0";
			}
			break;
		default:
			res = "Inserte una operacion valida";
			break;
		}
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("calculadora/calculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}