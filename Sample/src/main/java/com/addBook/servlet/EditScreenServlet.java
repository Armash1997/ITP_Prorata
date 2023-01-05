package com.addBook.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class EditScreenServlet
 */
@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String query = "SELECT BOOKNUM,BOOKNAME,BOOKEDITION,AUTHOR,CATEGORY,NUMBEROFPAGE,PUBLISHDATE FROM BOOKDATA1 where id=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get the id of record
		int id = Integer.parseInt(req.getParameter("id"));
		pw.println("<link rel='stylesheet' href='css1/bootstrap.css'>");
		pw.println("<marquee><h2 class='text-primary'>Edit Here</h2></marquee>");
		pw.println("<body style='background-image: url(img/p1.png);'>");
		//LOAD jdbc driver
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		//generate the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","armash123");
				PreparedStatement ps = con.prepareStatement(query);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
			pw.println("<form action='editurl?id="+id+"' method='post'>");
			pw.println("<table class='table table-hover table-striped'>");
			pw.println("<tr>");
			pw.println("<td>Book Id</td>");
			pw.println("<td><input type='number' name='bookNum' value='"+rs.getString(1)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Book Name</td>");
			pw.println("<td><input type='text' name='bookName' value='"+rs.getString(2)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Book Edition</td>");
			pw.println("<td><input type='text' name='bookEdition' value='"+rs.getString(3)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Author</td>");
			pw.println("<td><input type='text' name='author' value='"+rs.getString(4)+"'></td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td>Category");
			pw.println("<td><input type='text' name='category' value='"+rs.getString(5)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Number of page</td>");
			pw.println("<td><input type='number' name='numberOfPage' value='"+rs.getString(6)+"'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Publish Date</td>");
			pw.println("<td><input type='date' name='publishDate' value='"+rs.getString(7)+"'></td>");
			pw.println("</tr>");
			
			
			
			
			pw.println("<tr>");
			pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
			pw.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");
			pw.println("<td><a href='book.jsp'><button class='btn btn-outline-success'> Register</button></a></td>");
			pw.println("<td><a href='HomepageAdmin.jsp'><button class='btn btn-outline-success'>Home</button></a></td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h2>");
		}
		 pw.println("</div>");
	        //close the stream
	        
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
