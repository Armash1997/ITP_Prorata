package controller.pack;

import java.io.IOException;


import java.sql.SQLException;

import Dao.pack.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.pack.User;



/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDAO;
	
	public void init() {
		userDAO = new UserDao();
	}
  
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getServletPath();

		try {
			switch (action) {
			
			case "/UpdateUserServlet":
				updateUser(request, response);
				break;

			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}

	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User book = new User(id, name, email, password);
		HttpSession session = request.getSession();
			if(userDAO.updateUser(book)) {
				
				session.setAttribute("id",id);
				session.setAttribute("uname",name);
				session.setAttribute("email",email);
				session.setAttribute("password",password);
				 response.sendRedirect("Homepage.jsp"); 
			}
		 
		
		
	}
}
