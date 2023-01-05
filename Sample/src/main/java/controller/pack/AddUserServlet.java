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
 * Servlet implementation class AddUserServlet
                                       @ auther Armash Ahamed
 */

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDAO;
	
	public void init() {
		userDAO = new UserDao();
	}
	
    public AddUserServlet() {
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
			
			case "/AddUserServlet":
				insertUser(request, response);
				break;
	
			}
		} catch (SQLException | ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}
		


		
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ClassNotFoundException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User newUser = new User(name, email, password);
		userDAO.insertUser(newUser);
		response.sendRedirect("ListUserServlet");
	}

}
