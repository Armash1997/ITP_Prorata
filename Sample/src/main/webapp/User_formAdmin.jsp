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
	 
  	
<title>Add User</title>

<style>
		
body{
		background-image:url(<%=request.getContextPath()%>/images/12345.jpg);

		}

		<%@include file="css/style2.css" %>
</style>

<script type="text/javascript">
	<%@include file="Js/Admin.js" %>
	</script>

</head>
<body>

	<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("name")==null){
		response.sendRedirect("AdminLogin.jsp");
	}
	
	%>

<header style="width:1365.5px;">	
		<nav class="navbar navbar-dark bg-dark" >
				<a href="HomepageAdmin.jsp" class="navbar-brand"> Home </a>
			<div class="navbar-nav">
				<a href="<%=request.getContextPath()%>/ListUserServlet"
					class="navbar-brand">Users</a>
			</div>
		</nav>
	
	</header>
	
		
				<form id="form" method="post" action="AddUserServlet"   onsubmit="return validate(this);">
					
	<h1>	Add User
        	<div class="pic">
            <img alt="Girl in a jacke" src="<%=request.getContextPath()%>/images/Avatar2.svg" >
            </div>   </h1>
		

            
            
            <div class="input-control" style="width:290px;">
                <label for="name">UserName</label>
                <input id="name" name="name" 
                			type="text"  placeholder="Enter StudentId">
               
            </div>  
                
            <div class="input-control" style="width:290px;">
                <label for="email">Email</label>
                <input id="email" name="email" type="text" 
                		 placeholder="Enter StudentMail">
               
            </div>
          <div class="input-control" style="width:290px;">
                <label for="password">Password</label>
                <input id="password" name="password" type="text" 
                		 placeholder="Enter password">
                </div>
                
						 <button type="submit" >Add User</button>
			
             </form>
           
             
   
           
             
</body>
</html>