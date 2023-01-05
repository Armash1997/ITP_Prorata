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
 * Servlet implementation class AdminLogin   auther @ Armash Ahamed
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao loginDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		ResultSet rs = null;
		try {
			rs = loginDao.validate1(login);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			if(rs.next()) {
				session.setAttribute("name",rs.getString(1));
				session.setAttribute("password",rs.getString(2));
				response.sendRedirect("HomepageAdmin.jsp");
			}
			 else{
                    request.setAttribute("errorMessage", "Invalid user or password");
                    jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
                    rd.forward(request, response);          
                }		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
