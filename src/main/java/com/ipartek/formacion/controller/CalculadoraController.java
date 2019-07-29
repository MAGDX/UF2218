package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/calcular")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final char OP_SUMAR = 's';
	public static final char OP_RESTAR = 'r';
	public static final char OP_MULTIPLICAR = 'm';
	public static final char OP_DIVIDIR = 'd';

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Calculando...");
		float n1 = 0;
		float n2 = 0;
		char op = 0;
		try {
			n1 = Float.parseFloat(request.getParameter("n1").trim().replaceAll(",", "."));
			n2 = Float.parseFloat(request.getParameter("n2").trim().replaceAll(",", "."));
			float res;
			op = request.getParameter("op").toLowerCase().charAt(0);

			switch (op) {
			case OP_SUMAR:
				res = n1 + n2;
				break;
			case OP_RESTAR:
				res = n1 - n2;
				break;
			case OP_MULTIPLICAR:
				res = n1 * n2;
				break;
			case OP_DIVIDIR:
				if (n2 != 0) {
					res = n1 / n2;
				} else {
					throw new Exception("El divisor no puede ser 0");
				}
				break;
			default:
				throw new Exception("Inserte una operacion valida");
			}
			
			request.setAttribute("res", res);
		} catch (NumberFormatException e) {
			request.setAttribute("mensaje", new Alert("danger","Datos incorrectos"));
		}catch (Exception e) {
			request.setAttribute("mensaje", new Alert("warning",e.getMessage()));
		}finally {
			request.setAttribute("n1", n1);
			request.setAttribute("n2", n2);
			request.setAttribute("op", op);
			
			request.getRequestDispatcher("calculadora/calculator.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}