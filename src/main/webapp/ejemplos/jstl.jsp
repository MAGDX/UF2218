<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>JSTL - Java Server Tag Libraries</h1>

<section class="p-3 bg-light text-dark">
	<p>La tecnología JavaServer Pages Standard Tag Library (JSTL) es un componente de Java EE. Extiende las ya conocidas JavaServer Pages (JSP) proporcionando cuatro bibliotecas de etiquetas (Tag Libraries) con utilidades ampliamente utilizadas en el desarrollo de páginas web dinámicas.</p>
	<p>Estas bibliotecas de etiquetas extienden de la especificación de JSP (la cual a su vez extiende de la especificación de Servlet). Su API nos permite además desarrollar nuestras propias bibliotecas de etiquetas.</p>
	<p class="">*Nota: recordar que hay que importar los taglibraries <code>taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"</code></p>
	<a href="https://www.tutorialspoint.com/jsp/jsp_standard_tag_library">Documentacion y ejemplos</a>
</section>

<section class="p-3 bg-light text-dark">
	<h2>&lt;c:foreach&gt;</h2>
	<p>Sirve para iterar sobre una coleccion sin tener que usar scriptlets <code>&lt;% ... %&gt;</code>.</p>
	<p>Usando EL con el <code>&dollar;{colores}</code> --> ${colores}</p>
	<ol>
		<c:forEach items="${colores}" var="color">
			<li>${color}
		</c:forEach>
	</ol>
	
	<c:if test="${isLunes}"><p>Hoy es Lunes</p></c:if>
	<c:if test="${!isLunes}"><p>Hoy NO es Lunes</p></c:if>
</section>
<%@include file="../includes/footer.jsp"%>