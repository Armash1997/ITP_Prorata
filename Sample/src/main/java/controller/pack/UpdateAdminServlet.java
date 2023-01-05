package controller.pack;

import java.io.IOException;

import java.sql.SQLException;

import Dao.pack.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.pack.User;



/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDAO;
	
	public void init() {
		userDAO = new UserDao();
	}
  
    public UpdateAdminServlet() {
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
			
			case "/UpdateAdminServlet":
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
		userDAO.updateUser(book);
		response.sendRedirect("ListUserServlet");
		
	}
}
