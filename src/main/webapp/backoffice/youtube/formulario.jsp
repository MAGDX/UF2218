<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<h2 class="mt-2">Crear Video de YT</h2>
<hr>

<div class="row">
	<div class="col-12 col-sm-4">
		<form action="backoffice/videos" method="post">
			<input type="hidden" name="op" value="4"> <label
				class="obligatorio" for="id">ID:</label> <input style="width: 25px"
				type="text" id="id" name="id" class="text-center"
				value="${video.id}" readonly> <br> <label
				class="obligatorio" for="nombre">Nombre:</label> <br> <input
				type="text" id="nombre" name="nombre" required pattern=.{2,150}
				placeholder="Entre 2 y 150 caracteres" class="w-100"
				title="Entre 2 y 150 caracteres" value="${video.nombre}"> <br>
			<label class="obligatorio" for="codigo">Código:</label> <br> <input
				type="text" id="codigo" name="codigo" required pattern=.{11,11}
				placeholder="Exactamente 11 caracteres" class="w-100"
				title="Exactamente 11 caracteres" value="${video.codigo}"> <br>
			<p class="text-danger">${mensaje}</p>
			<br>
			<button type="submit" class="btn btn-primary mb-2 w-50 d-${dCrear}">Crear
				Video</button>
			<button type="submit"
				class="btn btn-success mb-2 w-50 d-${dModificar}">Modificar
				Video</button>
			<button type="button"
				class="btn btn-danger mb-2 w-50 d-${dModificar}" data-toggle="modal"
				data-target="#confirmacionEliminar">Eliminar Video</button>
			<br>
		</form>
	</div>
	<div
		class="col-12 col-sm-8 embed-responsive embed-responsive-16by9 d-${(video.id!=-1)?'block':'none'}">
		<iframe class="embed-responsive-item"
			src="https://www.youtube.com/embed/${video.codigo}" frameborder="0"
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>
	</div>
</div>
<!-- Modal confirmacion eliminar -->
<div class="modal" tabindex="-1" role="dialog" id="confirmacionEliminar">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Eliminar Video</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>¿Estas seguro que quieres eliminar este video?</p>
			</div>
			<div class="modal-footer">
				<a href="backoffice/videos?op=5&id=${video.id}" class="btn btn-danger">Eliminar</a>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			</div>
		</div>
	</div>
</div> <!-- End Modal -->
<%@include file="../../includes/footer.jsp"%>