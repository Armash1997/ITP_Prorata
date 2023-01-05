<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>User Management Application</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style4.css"/>

	
</head>
<body>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("name")==null){
			response.sendRedirect("AdminLogin.jsp");
		}
		%>

	<header>
		<nav class="navbar navbar-dark bg-dark">
			<div>
		<a href="HomepageAdmin.jsp" class="navbar-brand">HOME </a>
			</div>
		</nav>
	</header>
	
	
	<div class="p-3 mb-2 bg-light text-dark" style="height:600px;">
	<br>
	

		                   
	<div class="row" >
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
	

		<div class="container">
		
			<div class="text-center"><h3 class="navbar-text" >List of Users</h3></div><hr>
			<br><div class="navbar-brand"> 
			<a href="<%=request.getContextPath()%>/GetUserServlet" class="btn btn-success">Add New User</a></div>
			<br><br>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}" >
				
						<tr>
							<td  style="font-family:Courier New;"><c:out value="${user.id}" /></td>
							<td  style="font-family:Courier New;"><c:out value="${user.name}" /></td>
							<td  style="font-family:Courier New;"><c:out value="${user.email}" /></td>
							<td  style="font-family:Courier New;"><c:out value="${user.password}" /></td>
	
							<td>&nbsp;&nbsp;&nbsp;
								<a href="<%=request.getContextPath()%>/ListUserServlet" class="btn btn-success">View User</a>
								&nbsp;&nbsp;&nbsp;
								<a href="EditUserServlet?id=<c:out value='${user.id}' />" class="btn btn-primary updateitem">Update</a> 
								&nbsp;&nbsp;&nbsp;
								<a href="DeleteUserServlet?id=<c:out value='${user.id}' />" class="btn btn-danger deleteitem">Delete</a>
								 </td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
	
	
	</div>
</body>
</html>