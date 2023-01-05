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
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String query = "SELECT ID,BOOKNUM,BOOKNAME,BOOKEDITION,AUTHOR,CATEGORY,NUMBEROFPAGE,PUBLISHDATE FROM BOOKDATA1";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		pw.println("<link rel='stylesheet' href='css1/bootstrap.css'>");
        pw.println("<marquee><h2 class='text-primary'>Books List</h2></marquee>");
        pw.println("<body style='background-image: url(img/niff2.png);'>");
		
		//LOAD jdbc driver
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		//generate the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","armash123");
				PreparedStatement ps = con.prepareStatement(query);){
			ResultSet rs = ps.executeQuery();
			
			pw.println("<div style='margin:auto;width:900px;margin-top:100px; '>");
			pw.println("<table class='table table-hover table-striped'>");
			pw.println("<tr>");
			pw.println("<th>Id</th>");
			pw.println("<th>Book Id</th>");
			pw.println("<th>Book Name</th>");
			pw.println("<th>Book Edition</th>");
			pw.println("<th>Author</th>");
			pw.println("<th>Category</th>");
			pw.println("<th>Number of Page</th>");
			pw.println("<th>Publish Data</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(4)+"</td>");
				pw.println("<td>"+rs.getString(5)+"</td>");
				pw.println("<td>"+rs.getString(6)+"</td>");
				pw.println("<td>"+rs.getString(7)+"</td>");
				pw.println("<td>"+rs.getString(7)+"</td>");
				
				
				pw.println("<td><a href='editScreen?id="+rs.getInt(1)+"'>Edit</a></td>");
				pw.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'>Delete</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1>"+e.getMessage()+"</h2>");
		}
		pw.println("<button class='btn btn-outline-success d-block'><a href='book.jsp'>book Register</a></button>");
		pw.println("<button class='btn btn-outline-success d-block'><a href='HomepageAdmin.jsp'>Home</a>");
		pw.println("</div>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
