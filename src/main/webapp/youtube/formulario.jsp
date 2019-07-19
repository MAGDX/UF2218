<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<h2 class="mt-2">Crear Video de YT</h2>
<hr>

<form action="videos" method="post">
	<input type="hidden" name="op" value="4">
	<label class="obligatorio" for="id">ID:</label>
	<input
		style="width: 25px" type="text"
		id="id" name="id" class="text-center"
		value="${video.id}" readonly>
	<br>
	<label class="obligatorio" for="nombre">Nombre:</label> <br>
	<input
		type="text" id="nombre" name="nombre" required pattern=.{2,150}
		placeholder="Entre 2 y 150 caracteres" class="w-25"
		title="Entre 2 y 150 caracteres"
		value="${video.nombre}">
	<br>
	<label class="obligatorio" for="codigo">Código:</label> <br>
	<input
		type="text" id="codigo" name="codigo" required pattern=.{11,11}
		placeholder="Exactamente 11 caracteres" class="w-25"
		title="Exactamente 11 caracteres"
		value="${video.codigo}">
	<br>
	<p class="text-danger">${mensaje}</p>
	<br>
	<button type="submit" class="btn btn-primary mb-2 w-25 d-${dCrear}">Crear Video</button>
	<button type="submit" class="btn btn-success mb-2 w-25 d-${dModificar}">Modificar Video</button>
	<a href="videos?op=5&id=${video.id}" class="btn btn-danger mb-2 w-25 d-${dModificar}">Eliminar Video</a>
	<br>
</form>
<%@include file="../includes/footer.jsp"%>