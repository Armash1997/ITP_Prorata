package controller.pack;

import java.io.IOException;

import java.sql.SQLException;


import Dao.pack.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteUserServlet
 */
@jakarta.servlet.annotation.WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private UserDao userDAO;
	
	public void init() {
		userDAO = new UserDao();
	} 
    
    public DeleteUserServlet() {
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
			
			case "/DeleteUserServlet":
				deleteUser(request, response);
				break;
	
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
		
		
	}
	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("ListUserServlet");

	}

}
