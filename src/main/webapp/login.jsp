<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<h1>Login</h1>
<hr>
<%@include file="../includes/alert.jsp"%>
<form action="login" method="post">
	<input type="text" name="user" placeholder="Usuario">
	<br>
	<br>
	<input type="password" name="pass" placeholder="Contrase�a">
	<br>
	<br>
	<button type="submit" class="btn btn-primary">Iniciar Sesion</button>
</form>
<%@include file="../includes/footer.jsp"%>