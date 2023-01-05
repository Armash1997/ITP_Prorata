<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
  	
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  		
<title>Edit Account</title>


	<style>
	
	body{
		background-image:url(<%=request.getContextPath()%>/images/12345.jpg);

		}
	
	<%@include file="css/style3.css" %></style>
	
	<script>
	<%@include file="Js/User.js" %></script>

</head>
<body>
 
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		
		if(session.getAttribute("uname")==null){
			response.sendRedirect("SignIn.jsp");
		}
		%>	

<header style="width:1365.5px;">	
		<nav class="navbar navbar-dark bg-dark" >
				<a href="Homepage.jsp" class="navbar-brand"> Home </a>
			
		</nav>
	
	</header>
	
<div class="img">
	<img src="<%=request.getContextPath()%>/images/undraw_building_blocks_re_5ahy.svg">
	</div>

		<form id="form"  method="post" action="UpdateUserServlet" onsubmit="return validate(this);" >

		<h1>
					Edit User
              <div class="pic">
            <img alt="Girl in a jacke" src="<%=request.getContextPath()%>/images/Avatar2.svg" >
            </div>  
            	
			</h1>
					<input type="hidden" name="id" value='${id}'>
	
            
                <div class="input-control" style="width:290px;">
                <input id="name" name="name" value='${uname}' 
                			type="text" required placeholder="Enter StudentId" readonly>
               </div>
                
            <div class="input-control" style="width:290px;">
                <label for="email">Email</label>
                <input id="email" name="email" type="text" value='${email}'
                		 placeholder="Enter StudentMail">
               
            </div>
          <div class="input-control" style="width:290px;">
                <label for="password">Password</label>
                <input id="password" name="password" type="text" value='${password}'
                		 placeholder="Enter password">
                </div>
                

			 <button type="submit" >Update User</button>
             </form>
               
</body>
</html>