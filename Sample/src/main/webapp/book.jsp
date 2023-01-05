<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Register Here</title>
<link rel="stylesheet" href="css1/bootstrap.css">
<style type="text/css">

body{
	background: url("img/n1.png");
	}


  
</style>
</head>
<body class="container-fluid card" style="width:40rem;">

<marquee><h2 class="text-primary">Register Here</h2></marquee>
<form action="register" method="post" class="form card" >

<h2 class="bg-danger text-white card-header">Book Registration Form</h2>
    <table class="table table-hover">
    
       <tr>
        <td>Book Id:</td>
        <td><input type="number" name="bookNum" required></td>
       </tr>
       <tr>
        <td>Book Name:</td>
        <td><input type="text" name="bookName" required></td>
       </tr>
       <tr>
        <td>Book Edition:</td>
        <td><input type="text" name="bookEdition" required></td>
       </tr>
       <tr>
        <td>Author:</td>
        <td><input type="text" name="author" required></td>
       </tr>
       <tr>
        <td>Category:</td>
        <td><input type="text" name="category" required></td>
       </tr>
       <tr>
        <td>Number of page:</td>
        <td><input type="number" name="numberOfPage" required></td>
       </tr>
       <tr>
        <td>Publish Date:</td>
        <td><input type="date" name="publishDate" required></td>
       </tr>
       <tr class="card-footer">
        <td><button type="submit" class="btn btn-outline-success">Register</button></td>
        <td><button type="reset" class="btn btn-outline-danger">cancel</button></td>
 
        <td><button class='btn btn-outline-success'><a href='HomepageAdmin.jsp'>Home</a></button></td>
       </tr>
    </table>
    <button class="btn btn-outline-success d-block"><a href='bookList'>Book List</a></button>
</form>

</body>
</html>