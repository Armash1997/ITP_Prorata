package controller.pack;

import jakarta.servlet.ServletException;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.pack.User;

import java.io.IOException;

import Dao.pack.UserDao;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 UserDao memberDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	
		
		User member = new User();
		
		member.setName(username);
		member.setEmail(email);
		member.setPassword(password);
		
		
		
		 String result= memberDao.insert(member);
	
		 
		 
		 if(result.equals("Executed")) {
			 response.sendRedirect("SignIn.jsp");
		 }else {
			 request.setAttribute("errorMessage", "Username Taken");
             jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
             rd.forward(request, response);   
			
		 }
	}

}
