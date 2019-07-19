<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
<%@page isErrorPage="true"%>

<h1>Error 500</h1>
<hr>
<p>Lo sentimos pero esta pagina bajo mantenimiento.</p>
<p>
	<a href="index.jsp">Ve al inicio</a> o <a href="mailto:magnum_dx@hotmail.com"> mandanos un mail indicando el problema. </a>
</p>

<div class="p-2 border border-danger">
	<h2>Usar solo en Desarrollo</h2>
	<p class="text-danger"><%=exception%></p>
	<!-- Stack trace -->
	<jsp:scriptlet>exception.printStackTrace(new java.io.PrintWriter(out));</jsp:scriptlet>
</div>
<%@include file="includes/footer.jsp"%>