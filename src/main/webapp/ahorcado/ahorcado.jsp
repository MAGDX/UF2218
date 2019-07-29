<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<h1>Ahorcado</h1>
<hr>
<%@include file="../includes/alert.jsp"%>
<form action="ahorcar" method="get">
	<input type="text" name="letra" placeholder="Inserte un caracter" pattern="[A-Za-z]">
	<br>
	<br>
	<button type="submit" class="btn btn-primary" ${(vidasRestantes==0)?'disabled':''}>Apostar</button>
	<br>
	<br>
	<label class="p-1" for="resultado">Vidas restantes: ${(vidasRestantes==null)?'9':vidasRestantes}</label>
	<br>
	<br>
	<label class="${(exito==null)?'':'border border-success'} p-1" for="resultado">Palabra: ${palabra}</label>
</form>
<%@include file="../includes/footer.jsp"%>