<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body{
background-image: url(<%=request.getContextPath()%>/img/mainbg.jpg);
}
h1{
color: #000000;
text-align: left;
border-radius: 20px;
width: 1040px;
}

table{
background-color: white;
height: 100px;
width: 1050px;
background: #b3d7ffba;
}

a{
color: #df1024;
}

</style>
<title>Borrow List</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>
	<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("name")==null){
			response.sendRedirect("AdminLogin.jsp");
		}
		%>

<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #505096b0">
			<div>
				<a href="HomepageAdmin.jsp" class="navbar-brand"> HOME </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="borrowFormAdmin.jsp"
					class="nav-link">Borrow Book</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h1>Borrowed Books</h1>
			<hr>
			
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Member ID</th>
						<th>Book Id</th>
						<th>Current Date</th>
						<th>Return Date</th>
						<th>Note</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="borrowing" items="${listBorrowing}">

						<tr>
							<td>
								<c:out value="${borrowing.id}" />
							</td>
							<td>
								<c:out value="${borrowing.memberid}" />
							</td>
							<td>
								<c:out value="${borrowing.bookid}" />
							</td>
							<td>
								<c:out value="${borrowing.currentdate}" />
							</td>
							<td>
								<c:out value="${borrowing.returndate}" />
							</td>
							<td>
								<c:out value="${borrowing.note}" />
							</td>
							
							<td><a href="edit?id=<c:out value='${borrowing.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${borrowing.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>
			</table>
			
		</div>
	</div>

</body>
</html>