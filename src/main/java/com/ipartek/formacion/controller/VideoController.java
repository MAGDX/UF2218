package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Video;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/videos")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int OPCION_LISTAR = 1;
	private static final int OPCION_CREAR = 2;
	private static final int OPCION_MODIFICAR = 3;
	private static VideoDAO videoDAO = VideoDAO.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op = Integer.parseInt(request.getParameter("op"));
		
		switch(op) {
		case OPCION_LISTAR:
			listar(request, response);
			break;
		case OPCION_CREAR:
			crear(request, response);
			break;
		case OPCION_MODIFICAR:
			modificar(request, response);
			break;
		default:
			break;
		}
	}
	
	private static void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("videos", videoDAO.getAll());
		
		request.getRequestDispatcher("youtube/index.jsp").forward(request, response);
	}
	
	private static void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("dCrear", "block");
		request.setAttribute("dModificar", "none");
		
		request.getRequestDispatcher("youtube/formulario.jsp").forward(request, response);
	}
	
	private static void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		Video video = videoDAO.getById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("dCrear", "none");
		request.setAttribute("dModificar", "block");
		request.setAttribute("video", video);
		
		request.getRequestDispatcher("youtube/formulario.jsp").forward(request, response);
	}
}