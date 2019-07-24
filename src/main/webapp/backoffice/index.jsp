<%@page import="com.ipartek.formacion.controller.listener.LogedUsersListener"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<meta http-equiv="refresh" content="3">

<h1>BackOffice</h1>
<hr>

<h4>Usuarios Conectados</h4>
<ul>
	<c:forEach items="${LogedUsersListener.logedUsers}" var="u">
		<li class="list-group-item">${u}</li>
	</c:forEach>
</ul>

<%@include file="../includes/alert.jsp"%>
<%@include file="../includes/footer.jsp"%>