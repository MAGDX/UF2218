package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContentTypeController
 */
@WebServlet("/servlet3")
public class ContentTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("p");
		String responseContent = "";
		
		switch (tipo) {
		case "1":
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			responseContent = "perro buba, raza boxer, <p>No renderiza HTML porque le hemos dicho que es texto plano.</p>";
			break;
		case "2":
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			responseContent = "<h2>Perro:</h2><h3>Buba</h3><br><h2>Raza:</h2><h3>Boxer</h3><br><p>Ahora SI renderiza HTML porque le hemos dicho que es <code>text/html</code>.</p>";
			break;
		case "3":
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			responseContent += " { ";
			responseContent += " \"nombre\": \"buba\", ";
			responseContent += " \"raza\": \"boxer\" ";
			responseContent += " } ";
			break;
		case "4":
			response.setContentType("application/pdf");
			response.setCharacterEncoding("UTF-8");
			responseContent = "Perro: Buba Raza: Boxer";
			break;
		default:
			response.setContentType("text/plain");
			break;
		}
		
		PrintWriter out = response.getWriter();
		out.print(responseContent);
		
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
