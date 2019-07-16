<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
	<h1>Ejemplo Servlet Response Content Type</h1>
	<hr>
	<p>Un servlet de Java siempre responde por defecto con <code> text/html</code>, pero podemos cambiar el content-type.</p>
	<a href="https://developer.mozilla.org/es/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Lista_completa_de_tipos_MIME" target="_blank">Content Types</a>
	<p>Vamos a responde los mismos datos pero con diferente content type.</p>
	<p>Datos: perro [nombre: 'bubba', raza='boxer']</p>
	
	<a href="servlet3?p=1" class="btn btn-outline-primary">Respuesta Texto Plano</a>
	<a href="servlet3?p=2" class="btn btn-outline-primary">Respuesta HTML</a>
	<a href="servlet3?p=3" class="btn btn-outline-primary">Respuesta JSON</a>
	<a href="servlet3?p=4" class="btn btn-outline-primary">Respuesta PDF</a>
<%@include file="../includes/footer.jsp"%>