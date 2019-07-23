<%@page import="com.ipartek.formacion.controller.listener.LogedUsersListener"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<meta http-equiv="refresh" content="3">

<h1>BackOffice</h1>
<hr>

<%=LogedUsersListener.nombre%>
<%@include file="../includes/alert.jsp"%>
<%@include file="../includes/footer.jsp"%>