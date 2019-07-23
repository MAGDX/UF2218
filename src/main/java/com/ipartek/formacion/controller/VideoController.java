package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.ipartek.formacion.controller.pojo.Alert;
import com.ipartek.formacion.model.dao.VideoDAO;
import com.ipartek.formacion.model.pojo.Video;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/backoffice/videos")
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

	private static Validator validator;

	@Override
	public void init() throws ServletException {
		super.init();
		videoDAO = VideoDAO.getInstance();
		validator = Validation.buildDefaultValidatorFactory().getValidator();
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

	private static void crearModificarVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Video v = new Video(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"),
					request.getParameter("nombre"));

			Set<ConstraintViolation<Video>> violations = validator.validate(v);
			
			// Comprobamos si hay violaciones de las validaciones
			if (violations.isEmpty()) {
				if (v.getId() == -1) {
					videoDAO.crear(v);
				} else {
					videoDAO.modificar(v);
				}
				request.setAttribute("mensaje", new Alert("success", "Registro creado con exito!"));
			} else {
				String mensaje = "";
				
				for (ConstraintViolation<Video> violation : violations) {
					mensaje += violation.getPropertyPath() +": " + violation.getMessage() +"<br>";
				}
				request.setAttribute("mensaje", new Alert("warning", mensaje));
			}
		} catch (Exception e) {
			request.setAttribute("mensaje", new Alert("danger", "El codigo insertado ya existe."));
		}
		listar(request, response);
	}

	private static void eliminarVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (videoDAO.delete(Integer.parseInt(request.getParameter("id")))) {
			request.setAttribute("mensaje", new Alert("success", "Registro eliminado con exito!"));
		} else {
			request.setAttribute("mensaje",
					new Alert("danger", "No se puedo eliminar el registro. Vuelva a intentarlo más tarde..."));
		}

		listar(request, response);
	}
}