<%@page import="java.util.List"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>Listado Nombres</h1>

<div class="row">
	<div class="col-9 border-right">
		<form method="get" action="nombres" class="form-inline">
			<label for="buscar" class="sr-only text-secondary">Nombre: </label> <input
				type="search" name="buscar" id="buscar"
				class="form-control mb-2 mr-sm-2" value="${buscar}"
				placeholder="Inserte un nombre" required>
			<button type="submit" class="btn btn-primary mb-2">Buscar</button>
		</form>
		<%
			if (request.getAttribute("buscar") == null) {

			}
		%>
		<p>${mensaje}</p>
		<ul class="list-group mb-3">
			<%
				List<String> nombres = (List<String>) request.getAttribute("nombres");
				for (String nombre : nombres) {
			%>
			<li class="list-group-item"><%=nombre%></li>
			<%
				}
			%>
		</ul>
		<a href="nombres" class="btn btn-primary">Volver a la lista</a>
	</div>
	<div class="col-3">
		<form method="post" action="nombres">
			<label for="nombre" class="text-secondary">Nombre: </label> <input
				type="text" name="nombre" placeholder="Inserte su nombre" required>
			<br> <br> <input type="submit">
		</form>
	</div>
</div>
<!-- End Grid -->
<%@include file="../includes/footer.jsp"%>