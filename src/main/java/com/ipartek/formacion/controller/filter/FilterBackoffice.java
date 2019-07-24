package com.ipartek.formacion.controller.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Servlet Filter implementation class FilterBackoffice
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/backoffice/*" })
public class FilterBackoffice implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession sesion = req.getSession();

		if (req.getParameter("op") != null) {
			sesion.setAttribute("callback", req.getRequestURI() + "?op=" + req.getParameter("op"));
		} else {
			sesion.setAttribute("callback", req.getRequestURI());
		}

		if (sesion.getAttribute("user") != null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			// response redireccionar a login
			sesion.setAttribute("mensaje", new Alert("info", "Es necesario iniciar sesión"));
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}