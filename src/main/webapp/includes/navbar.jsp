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
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><fmt:message key="menu.inicio"/><span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item active"><a class="nav-link" href="${(user==null)?'login.jsp':'logout'}">${(user==null)?'Login':'Logout'}</a></li>
			<li class="nav-item active dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<fmt:message key="menu.utilidades"/>
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
		<div class="d-inline my-2 my-lg-0">
			<a href="i18n?idiomaSeleccionado=es_ES&ruta=${pageContext.request.requestURI}"><img class="ml-2 ${sessionScope.idiomaSeleccionado != 'es_ES' ? 'inactive': ''  }" src="resources/images/españa.jpg" alt="Castellano"></a>
			<a href="i18n?idiomaSeleccionado=en_EN&ruta=${pageContext.request.requestURI}"><img class="ml-2 ${sessionScope.idiomaSeleccionado != 'en_EN' ? 'inactive': ''  }" src="resources/images/england.jpg" alt="Inglés"></a>
			<a href="i18n?idiomaSeleccionado=eu_ES&ruta=${pageContext.request.requestURI}"><img class="ml-2 ${sessionScope.idiomaSeleccionado != 'eu_ES' ? 'inactive': ''  }" src="resources/images/ikurrina.jpg" alt="Euskera"></a>
		</div>
	</div>
</nav> <!-- End NavBar -->
<main class="container text-primary">