<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

	<title>SIGN In ADMIN</title>
	
	<style>  
	<%@include file="css/style4.css" %>
	</style>
	<script type="text/javascript">
	<%@include file="Js/Login.js" %>
	</script>

</head>
<body>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
		%>

<div class="container">
		<div class="img">
	<img src="<%=request.getContextPath()%>/images/undraw_in_the_office_re_jtgc.svg">
	</div>
    <form  id="form" method="post" action="AdminLogin"  onsubmit="return validate(this);" >
        <h1>LOGIN ADMIN</h1><br>
     
        <div class="input-control">
            <label for="username">UserName</label>
            <input id="username" name="username" type="text" placeholder="Enter StudentId" >
           
        </div>
        <div class="input-control">
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Enter password">
            </div>
            
              <h2 style="color:red;font-size: 15px;text-align: center;">
<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%></h2>
      		<h4 align="center">Are you a User?<a href="SignIn.jsp" style="text-decoration: none;">LOGIN</a></h4>
      		
		 <button type="submit" >LOGIN</button>
			
             
<footer>
<br><br>
  
</footer>
				
</form>




</div><br><br><br><br> <br><br><br><br><br>
<div class="banner">
  <!-- Copyright -->
 			 <h2 >Copyright © 2022.All rights reserved.</h2>
  <!-- Copyright -->
</div>
         

</body>
</html>
