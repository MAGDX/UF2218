<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
	<h1>Ejemplo Basico sin JSP</h1>
	<p>Vamos a crear un Servlet para mostrar la RESQUEST y la RESPONSE</p>
	<p>El Servlet sera el encargado de pintar la respuesta a pelo, sin usar una JSP.</p>
	
	<a class="btn btn-primary" href="controlador1">PETICION GET</a>
	
	<a class="btn btn-primary" href="controlador1?param1=value1&param2=foo&p3=manolito">PETICION GET2</a>
	
	<a class="btn btn-danger" href="asdf">PETICION GET - Response 404</a>
<%@include file="../includes/footer.jsp"%>