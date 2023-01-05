<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
  	
	<title>SIGN IN</title>
	
	<style>
	<%@include file="css/style4.css" %>
	<%@include file="css/style1.css" %>
	
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
    <form  id="form" method="post" action="LoginServlet"  onsubmit="return validate(this);" >
        <h1>USER LOGIN</h1><br>
     
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
      
		 <button type="submit" >LOGIN</button>
			
             
<footer>
<br><br>
            <div id="example2" align="center">
          
  
				 <a href="https://www.facebook.com/" class="fa fa-facebook"></a>
         		 <a href="https://twitter.com/i/flow/login" class="fa fa-twitter"></a>
          		 <a href="https://accounts.google.com/Login" class="fa fa-google"></a>
          		   
</div>
</footer>
				<h4 align="center">Are you an ADMIN?<a href="AdminLogin.jsp" style="text-decoration: none;">ADMIN</a></h4>
				<h4 align="center">Need an Account?<a href="SignUp.jsp" style="text-decoration: none;">SIGN UP</a></h4>				
</form>




</div><br><br>
<div class="banner">
  <!-- Copyright -->
 			 <h2 >Copyright © 2022.All rights reserved.</h2>
  <!-- Copyright -->
</div>
         

</body>
</html>
