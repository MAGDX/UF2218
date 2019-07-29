<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>Idiomas</h1>
<hr>

<h3>Recuperar properties desde un Servlet</h3>

<ol>
	<li><a href="i18n?idiomaSeleccionado=es_ES"><img style="width: 25px;" src="resources/images/españa.jpg" alt="Imagen España"></a></li>
	<li><a href="i18n?idiomaSeleccionado=en_EN"><img style="width: 25px;" src="resources/images/england.jpg" alt="Imagen Reino Unido"></a></li>
	<li><a href="i18n?idiomaSeleccionado=eu_ES"><img style="width: 25px;" src="resources/images/ikurrina.jpg" alt="Imagen Euskadi"></a></li>
</ol>

<h3>Recuperar properties desde JSP</h3>

<fmt:message key="menu.ejemplos"/>

<%@include file="../includes/footer.jsp"%>