<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Online Library Management System</title>
	<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
	
    <style>
    
        * {
	margin: 0;
	padding: 0;
}

.wrapper {
	width: 1170px;
	margin: 0 auto;
}
header {
	height: 60px;
	background: #368BC1;

}
.logo {
	width: 0%;
	float: left;
	color: #fff;
	font-weight: bold;
	line-height: 60px;
	font-size: 25px;
}
nav {
	width: 68%;
	float: right;
}
nav ul {
	list-style: none;
	float: right;
}
nav ul li {
	display: inline-block
}
nav ul li a {
	text-decoration: none;
	color: #fff;
	font-weight: bold;
	margin: 0 10px;
	line-height: 60px
}
.banner {
	color: #fff;
	display: grid;
	place-items: center;
	height: 95vh;
	width:1350px;
	background-image: url("img/mainbg.jpg");
	background-size: cover;
	background-position: center center;
	
}
.banner h1 {
	font-size: 70px;
	font-family: alfa slab one;
}
.banner a {
	text-decoration: none;
	background: orangered;
	display: inline-block;
	color: #fff;
	padding: 10px 20px;
	font-size: 18px;
	margin-top: 25px;
	border-radius: 50px;
	text-transform: uppercase;
}
.content {
	padding: 1% 0;
}
.img-area {
	display: flex;
	width: 95%;
	margin: auto;
	margin-left: 10px;
}
.img-area img {
	width: 96%;
	margin: 20px 0px;
}
div.gallery {
  margin: 6px;
  border: 1px solid #ccc;
  float: left;
  width: 265px;
}
div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
  text-align: center;
}
.content p {
	font-size: 18px;
	line-height: 1.7;
	font-family: sans-serif;
	margin-bottom: 20px;
}
footer {
	background: #368BC1;
	color: #fff;
	padding: 15px 50px;
	text-align: center;
}
/* responsive css */

@media only screen and (min-width: 768px) and (max-width: 991px) {
	header {
		padding: 0 30px;
	}
	.wrapper {
		width: 100%;
	}
	.logo {
		width: 100%;
		text-align: center;
	}
	nav {
		width: 100%;
		float: none;
		text-align: center;
	}
	nav ul {
		float: none;
	}
	nav ul li a {
		margin: 0 5px;
		line-height: 18px;
	}
	.banner .wrapper {
		text-align: center;
	}
}
@media (max-width:767px) {
	header {
		padding: 0 30px;
	}
	.wrapper {
		width: 100%;
	}
	.logo {
		width: 100%;
		text-align: center;
	}
	nav {
		width: 100%;
		float: none;
		text-align: center;
	}
	nav ul {
		float: none;
	}
	nav ul li a {
		margin: 0 5px;
		line-height: 20px;
		font-size: 10px;
	}
	.banner {
		width: 100vw;
	}
	.banner .wrapper {
		text-align: center;
	}
	.banner {
		height: 45vh;
	}
	.banner h1 {
		font-size: 30px;
	}
	.content p {
		text-align: center;
	}
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
			<div class="logo">
				<img src="<%=request.getContextPath()%>/img/logo.png" alt="Online Library" width="60" height="60">
			</div>
			<nav >
				<ul>
					<li>
						<a href="borrowFormAdmin.jsp">Borrow Book</a>
					</li>
					<li>
						<a href="book.jsp">Add Book</a>
					</li>
					
					<li>
						<a href="User_formAdmin.jsp">User Account</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/LogoutAdminServlet">Logout</a>
					</li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="banner">
		<div class="wrapper">
			<h2>Welcome to Our,</h2>
			<h1>Library</h1>
			<a href="#">Learn More</a>
		</div>
	</div>
	<div><h1 style = "text-align: center; padding : 15px; font-size: 50px;">Trendings</h1></div>
	
	<footer>
		<p>All Right Reserved by @our Library</p>
	</footer>
</body>
</html>