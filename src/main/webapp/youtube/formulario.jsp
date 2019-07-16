<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<h1>Crear Video de YT</h1>

<form action="youtube/crearVideo" method="get">
	<label class="obligatorio" for="titulo">Título</label>
	<br>
	<input type="text" id="titulo" name="titulo" required pattern=.{2,150} placeholder="Entre 2 y 150 caracteres" title="Entre 2 y 150 caracteres">
	<br>
	<label class="obligatorio" for="codigo">Código</label>
	<br>
	<input type="text" id="codigo" name="codigo" required pattern=.{11,11} placeholder="Exactamente 11 caracteres" title="Exactamente 11 caracteres">
	<br>
	<br>
	<p class="text-danger">${mensaje}</p>
	<br> <input type="submit" value="Crear Video"> <br> <br>
	<input type="reset" value="Limpiar Formulario">
</form>
<%@include file="../includes/footer.jsp"%>