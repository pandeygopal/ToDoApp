<% 
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
	%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add todo</title>
<%@include file="component/allcss.jsp"%>

</head>
<body style="background-color: #f0f1f2;">
	<%@include file="component/Navbar.jsp"%>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
	%>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">

					<div class="card-body">
						<h3 class="text-center text-success">ToDo</h3>

						<form action="AddServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="username">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">TODO</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="todo">

							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">
									<option selected>--Select--</option>
									<option value="Pending">Pending</option>
									<option value="Complete">Complete</option>
								</select>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
						</form>


					</div>


				</div>

			</div>

		</div>



	</div>


</body>
</html>