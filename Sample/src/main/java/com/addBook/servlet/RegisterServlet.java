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
import java.sql.SQLException;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String query = "INSERT INTO BOOKDATA1(BOOKNUM,BOOKNAME,BOOKEDITION,AUTHOR,CATEGORY,NUMBEROFPAGE,PUBLISHDATE) VALUES(?,?,?,?,?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		pw.println("<link rel='stylesheet' href='css1/bootstrap.css'>");
		pw.println("<body style='background-image: url(img/34.jpg);'>");
		
		//GET THE book info
		String bookNum = req.getParameter("bookNum");
		String bookName = req.getParameter("bookName");
		String bookEdition = req.getParameter("bookEdition");
		String author = req.getParameter("author");
		String category = req.getParameter("category");
		String numberOfPage = req.getParameter("numberOfPage");
		String publishDate = req.getParameter("publishDate");
		//LOAD jdbc driver
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		//generate the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","armash123");
				PreparedStatement ps = con.prepareStatement(query);){
			ps.setString(1, bookNum);
			ps.setString(2, bookName);
			ps.setString(3, bookEdition);
			ps.setString(4, author);
			ps.setString(5, category);
			ps.setString(6, numberOfPage);
			ps.setString(7, publishDate);
			int count = ps.executeUpdate();
			
			pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
			
			if(count==1) {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Is Registered Sucessfully</h2>");
			}else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record not Registered Sucessfully</h2>");
			}
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 class='bg-danger text-light text-center'>"+e.getMessage()+"</h2>");
		}
		pw.println("<a href='book.jsp'><button class='btn btn-outline-success d-block'>Book Register</button></a>");
		
		pw.println("<a href='bookList'><button class='btn btn-outline-success d-block'>Book List</button></a>");
		
		pw.println("<a href='HomepageAdmin.jsp'><button class='btn btn-outline-success d-block'>Home</button></a>");
		pw.println("</div>");
		
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
