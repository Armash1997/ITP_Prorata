<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrow Your Book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
body{
	background-image: url(<%=request.getContextPath()%>/img/3.jpg);
	margin: 0;
	
	padding: 0;
	background-size: cover;
	font-family: sans-serif;
	color: white;
	}
	
	h2{
	color: #3ed3e7;
	}
	
	.bookform
{
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	width: 800px;
	height: 530px;
	padding: 25px 30px;
	box-sizing: border-box;
	background: rgba(0,0,0,.5);
	border-radius: 30px;
}

.bookform p{
{
	margin: 0;
	padding: 0;
	font-weight: bold;
	color: #fff;
}

.bookform input
{
	width: 100%;
	margin-bottom: 20px;
}

.bookform input[type="submit"]
{
	border: none;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
	background: #ff267e;
	cursor: pointer;
	border-radius: 20px;
}
.bookform input[type="submit"]:hover
{
	background: #efed40;
	color: #262626;
}

.active{
	background-color: red;
}


</style>
		
</head>
<body>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("name")==null){
			response.sendRedirect("AdminLogin.jsp");
		}
		%>
<header>
		<div class="wrapper">
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #505096b0">
			<div>
				<a href="HomepageAdmin.jsp" class="navbar-brand"> HOME </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Borrow List</a></li>
			</ul>
		</nav>
		</div>
	</header>
<div >

		<div>
			<div>
			<div class="bookform">
			
				<c:if test="${borrowing != null}">
					<form action="update" method="post">
					
				</c:if>
				
				<c:if test="${borrowing == null}">
					<form action="insert" method="post">
				
				</c:if>
				
				<caption>
					<h2 style="	text-align: center;">
						<c:if test="${borrowing != null}">
            				Edit Borrow Details	
            		</c:if>
            		
						<c:if test="${borrowing == null}">
            			Borrow Your Book
            		</c:if>
					</h2>
				</caption>
				

				<c:if test="${borrowing != null}">
					<input type="hidden" name="id" value="<c:out value='${borrowing.id}' />" />
				</c:if>
					
					<p>Member ID: <br>
					<input type="text"
						value="<c:out value='${borrowing.memberid}' />" class="form-control" name="memberid" title="Must contain IT number" required
></p>
						
						
					<p>Book ID: <br>
					<input type="text"
						value="<c:out value='${borrowing.bookid}' />" class="form-control" name="bookid"></p>
						
						
					<p>Current Date: <br>
					<input type="date"
						value="<c:out value='${borrowing.currentdate}' />" class="form-control"
						name="currentdate"></p>
				
				
					<p>Return Date:<br>
					 <input type="date"
						value="<c:out value='${borrowing.returndate}' />" class="form-control"
						name="returndate" ></p>
				
				
				
					<p>Note: <br>
					<input type="text"
						value="<c:out value='${borrowing.note}' />" class="form-control"
						name="note"></p>
			
						
						<br>
						
						<table>
			<tr>
			<td><button type="submit" class="btn btn-success">BORROW</button></td>
			<td></td>
<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>
			</table>
				
			</div>
		</div>
	</div>
	</div>
	
</body>
</html>