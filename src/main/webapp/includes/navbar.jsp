<%@page import="com.ipartek.formacion.controller.VideoController"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="index.jsp">JEE</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item active"><a class="nav-link" href="${(user==null)?'login.jsp':'logout'}">${(user==null)?'Login':'Logout'}</a></li>
			<li class="nav-item active dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Utilidades
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="calculadora/calculator.jsp">Calculadora</a>
					<a class="dropdown-item" href="ahorcado/ahorcado.jsp">Ahorcado</a>
				</div>
			</li>
			<li class="nav-item ${(user==null)?'':'active'} dropdown">
				<a class="nav-link dropdown-toggle" href="backoffice/videos?op=1" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Youtube
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="backoffice/videos?op=1">Listado</a>
					<a class="dropdown-item" href="backoffice/videos?op=2">Crear Video</a>
				</div>
			</li>
			<li class="nav-item ${(user==null)?'d-none':'active'} dropdown">
				<a class="nav-link dropdown-toggle" href="backoffice/videos?op=1" id="navbarDropdown" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Últimos videos
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<c:if test = "${videosVistos != null}">
						<c:forEach items="${videosVistos}" var="vv"> 
							<a class="dropdown-item" href="backoffice/videos?op=3&id=${vv.value.id}">${vv.value.nombre}</a>
						</c:forEach>
					</c:if>
					<c:if test = "${videosVistos == null}">
						<a class="dropdown-item" href="backoffice/videos?op=1">No existen videos recientes</a>
					</c:if>
				</div>
			</li>
			<li class="nav-item"><a class="nav-link ${(user==null)?'d-none':'active'}" href="backoffice/index.jsp"
				tabindex="-1" aria-disabled="true">BackOffice</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Buscar..." aria-label="Search">
			<button class="btn btn-primary my-2 my-sm-0" type="submit">Buscar</button>
		</form>
	</div>
</nav> <!-- End NavBar -->
<main class="container text-primary">