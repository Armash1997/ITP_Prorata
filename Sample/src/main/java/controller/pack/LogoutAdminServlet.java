package controller.pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutAdminServlet")
public class LogoutAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String action = request.getServletPath();
		
		switch(action) {
		case "/LogoutAdminServlet":
			Logout(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
			 
	}
	
	
	private void Logout(HttpServletRequest request, HttpServletResponse response) {
				
				System.out.println("Session before invalidate: "+ request.getSession(false));
				  
		        // Invalidate the session.
				request.getSession(false).invalidate();
		  
		        // Print the session object in the console after invalidating the session.
		        System.out.println("Session after invalidate: "+ request.getSession(false));
		        
		        try {
					response.sendRedirect("AdminLogin.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
}
