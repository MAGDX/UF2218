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
	private static final String VIEW_INDEX = "youtube/index.jsp";
	private static final String VIEW_FORM = "youtube/formulario.jsp";
	private static final int OPCION_LISTAR = 1;
	private static final int OPCION_FORM_CREAR = 2;
	private static final int OPCION_FORM_MODIFICAR = 3;
	private static final int OPCION_CREAR_MODIFICAR_VIDEO = 4;
	private static final int OPCION_ELIMINAR_VIDEO = 5;
	private static VideoDAO videoDAO;
	private static String view;

	@Override
	public void init() throws ServletException {
		super.init();
		videoDAO = VideoDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int op = Integer.parseInt(request.getParameter("op"));

		switch (op) {
		case OPCION_LISTAR:
			listar(request, response);
			break;
		case OPCION_FORM_CREAR:
			formCrear(request, response);
			break;
		case OPCION_FORM_MODIFICAR:
			formModificar(request, response);
			break;
		case OPCION_CREAR_MODIFICAR_VIDEO:
			crearModificarVideo(request, response);
			break;
		case OPCION_ELIMINAR_VIDEO:
			eliminarVideo(request, response);
			break;
		default:
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	private static void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("videos", videoDAO.getAll());

		view = VIEW_INDEX;
	}

	private static void formCrear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("dCrear", "block");
		request.setAttribute("dModificar", "none");
		request.setAttribute("video", new Video());

		view = VIEW_FORM;
	}

	private static void formModificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = videoDAO.getById(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("dCrear", "none");
		request.setAttribute("dModificar", "block");
		request.setAttribute("video", video);

		view = VIEW_FORM;
	}

	private static void crearModificarVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String codigo = request.getParameter("codigo");

		try {
			if (id == -1) {
				videoDAO.crear(new Video(codigo, nombre));
			} else {
				videoDAO.modificar(new Video(id, codigo, nombre));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		listar(request, response);
	}

	private static void eliminarVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		videoDAO.delete(Integer.parseInt(request.getParameter("id")));

		listar(request, response);
	}
}