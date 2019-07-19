<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<h2 class="mt-2">Crear Video de YT</h2>
<hr>

<form action="videos" method="get">
	<label class="obligatorio" for="id">ID: ${video.id}</label> <br>
	<label class="obligatorio" for="nombre">Nombre:</label> <br>
	<input
		type="text" id="nombre" name="nombre" required pattern=.{2,150}
		placeholder="Entre 2 y 150 caracteres"
		title="Entre 2 y 150 caracteres"
		value="${video.nombre}">
	<br>
	<label class="obligatorio" for="codigo">Código:</label> <br>
	<input
		type="text" id="codigo" name="codigo" required pattern=.{11,11}
		placeholder="Exactamente 11 caracteres"
		title="Exactamente 11 caracteres"
		value="${video.codigo}">
	<br>
	<p class="text-danger">${mensaje}</p>
	<br>
	<button type="submit" class="btn btn-primary mb-2 d-${dCrear}">Crear Video</button>
	<button type="submit" class="btn btn-success mb-2 d-${dModificar}">Modificar Video</button>
	<button type="submit" class="btn btn-danger mb-2 d-${dModificar}">Eliminar Video</button>
	<br>
</form>
<%@include file="../includes/footer.jsp"%>