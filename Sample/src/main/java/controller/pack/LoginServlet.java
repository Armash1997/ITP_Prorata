package controller.pack;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.pack.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.pack.UserDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao loginDao = new UserDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		
		User login = new User();
		
		login.setName(username);
		login.setPassword(password);
		
		HttpSession session = request.getSession();
		ResultSet rs  =loginDao.validate(login);
		
			try {
				if(rs.next()) {
					session.setAttribute("id",rs.getInt(1));
					session.setAttribute("uname",rs.getString(2));
					session.setAttribute("email",rs.getString(3));
					session.setAttribute("password",rs.getString(4));
					response.sendRedirect("Homepage.jsp");
				}
				 else{
	                    request.setAttribute("errorMessage", "Invalid user or password");
	                    jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp");
	                    rd.forward(request, response);          
	                }		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}

}
