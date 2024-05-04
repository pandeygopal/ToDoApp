
<%@page import="java.util.List"%>
<%@page import="com.entity.TodoDtls"%>
<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
 %>
	<% 
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<%@include file="component/allcss.jsp"%>

</head>
<body>
	<%@include file="component/Navbar.jsp"%>
	<%
	String sucMSG = (String) session.getAttribute("sucMSG");
	if (sucMSG != null) {
	%>
	<div class="alert alert-success" role="alert">
		<%=sucMSG%>
	</div>
	<%
	}
	session.removeAttribute("sucMSG");
	%>
	<%
	String failedMSG = (String) session.getAttribute("failedMSG");
	if (failedMSG != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=failedMSG%>
	</div>
	<%
	}
	session.removeAttribute("failedMSG");
	%>
	<h1 class="text-center text-success">TODO-APP</h1>
	<div class="container">
		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Todo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%
				TodoDAO dao = new TodoDAO(DBConnect.getConn());
				List<TodoDtls> todo = dao.getTodo();
				for (TodoDtls t : todo) {
				%>
				<tr>
					<th scope="row"><%=t.getId()%></th>
					<th scope="col"><%=t.getName()%></th>
					<td><%=t.getTodo()%></td>
					<td><%=t.getStatus()%></td>
					<td><a href="edit.jsp?id=<%=t.getId()%>"
						class="btn btn-sm btn-success">Edit</a> <a
						href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a>
					</td>
					<%
					}
					%>
				</tr>

			</tbody>
		</table>
	</div>
</body>
</html>