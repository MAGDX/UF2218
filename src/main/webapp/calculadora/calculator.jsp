<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<h1>Calculadora</h1>
<hr>
<%@include file="../includes/alert.jsp"%>
<form action="calcular" method="get">
	<input type="number" name="n1" placeholder="Numero 1" min="-999999" max="999999">
	<br>
	<br>
	<input type="number" name="n2" placeholder="Numero 2" min="-999999" max="999999">
	<br>
	<br>
	<select id="operacion" name="op">
		<option value="s">Sumar</option>
		<option value="r">Restar</option>
		<option value="m">Multiplicar</option>
		<option value="d">Dividir</option>
	</select>
	<br>
	<br>
	<button type="submit" class="btn btn-primary">Calcular</button>
	<br>
	<br>
	<label for="resultado">${res}</label>
</form>
<%@include file="../includes/footer.jsp"%>