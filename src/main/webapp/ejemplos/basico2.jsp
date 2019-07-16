<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
	<h1>Ejemplo Básico con JSP</h1>
	<hr>
	<p>Hacemos una peticion GET a traves del enlace (boton) de abajo.</p>
	<p>Cuando recibe la peticio, el servlet realiza una request interna a esta misma jsp, pasandole dos atributos.</p>
	<br>
	<a href="useragent" class="btn btn-outline-primary">Detecta navegador que estas utilizando</a>
	<br>
	<h2>Respuesta</h2>
	
	<!-- <i class="fab fa-internet-explorer"></i>
	<i class="fab fa-firefox"></i>
	<i class="fab fa-chrome"></i> -->
	<p>Navegador: <i class="fab fa-${icono}"></i>&nbsp;${navegador}</p>
	<p>Dispositivo: <i class="fas fa-${disp}"></i></p>
<%@include file="../includes/footer.jsp"%>