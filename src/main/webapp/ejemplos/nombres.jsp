
<%@page import="java.util.ArrayList"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>Listado Nombres</h1>

<div class="row">
	<div class="col-9 border-right">
		<form method="get" action="nombres" class="form-inline">
			<label for="buscar" class="sr-only text-secondary">Nombre: </label>
			<input
				type="search" name="buscar" id="buscar"
				class="form-control mb-2 mr-sm-2"
				value="${buscar}"
				placeholder="Inserte el nombre a buscar" required>
			<button type="submit" class="btn btn-primary mb-2">Buscar</button>
		</form>
		<%	if(request.getAttribute("buscar")==null){
				
			}
		%>
		<ul class="list-group">
			<%
				ArrayList<String> nombres = (ArrayList<String>)request.getAttribute("nombres");
				for(String nombre : nombres){
			%>
					<li class="list-group-item"><%=nombre %></li>
			<%
				}
			%>
			<li class="list-group-item">Name_0</li>
			<li class="list-group-item">Name_1</li>
			<li class="list-group-item">Name_2</li>
			<li class="list-group-item">Name_3</li>
			<li class="list-group-item">Name_4</li>
			<li class="list-group-item">Name_5</li>
			<li class="list-group-item">Name_6</li>
			<li class="list-group-item">Name_7</li>
			<li class="list-group-item">Name_8</li>
			<li class="list-group-item">Name_9</li>
		</ul>
	</div>
	<div class="col-3">
		<form method="get" action="nombres">
			<label for="nombre" class="text-secondary">Nombre: </label> <input
				type="text" name="nombre" placeholder="Inserte su nombre" required>
			<br> <br> <input type="submit">
		</form>
	</div>
</div>
<!-- End Grid -->
<%@include file="../includes/footer.jsp"%>