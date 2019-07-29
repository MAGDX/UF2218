<%@page import="com.ipartek.formacion.controller.CalculadoraController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>Calculadora</h1>
<hr>
<%@include file="../includes/alert.jsp"%>
<form action="calcular" method="get">
	<input type="text" name="n1" placeholder="Número 1" value="${n1}">
	<br>
	<br>
	<input type="text" name="n2" placeholder="Número 2" value="${n2}">
	<br>
	<br>
	<select class="w-25" id="operacion" name="op">
		<option value="o">Elija una opcion...</option>
		<option ${(op==CalculadoraController.OP_SUMAR)?"selected":""} value="s">Sumar</option>
		<option ${(op==CalculadoraController.OP_RESTAR)?"selected":""} value="r">Restar</option>
		<option ${(op==CalculadoraController.OP_MULTIPLICAR)?"selected":""} value="m">Multiplicar</option>
		<option ${(op==CalculadoraController.OP_DIVIDIR)?"selected":""} value="d">Dividir</option>
	</select>
	<br>
	<br>
	<button type="submit" class="btn btn-primary">Calcular</button>
	<br>
	<br>
	<label class="${(res==null)?'':'border border-success text-success'} p-1" for="resultado">Resultado: <fmt:formatNumber type="number" maxFractionDigits="2" value="${res}"/></label>
</form>
<%@include file="../includes/footer.jsp"%>