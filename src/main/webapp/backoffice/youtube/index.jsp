<%@page import="com.ipartek.formacion.model.pojo.Video"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<h1>Listado de Videos de YT</h1>
<hr>
<a class="btn btn-primary mb-2" href="backoffice/videos?op=2">+ Nuevo Video</a>
<%@include file="../../includes/alert.jsp"%>
<ul class="list-group">
	<%
		ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
		for (Video video : videos) {
	%>
		<li class="list-group-item">
			<a href="backoffice/videos?op=3&id=<%=video.getId()%>"><%=video.getNombre()%></a>
		</li>
	<%
		}
	%>
</ul>
<%@include file="../../includes/footer.jsp"%>