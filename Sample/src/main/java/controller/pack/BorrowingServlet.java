package controller.pack;

import jakarta.servlet.RequestDispatcher;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.pack.Borrowing;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Dao.pack.BorrowingDAO;



@WebServlet("/")
/**
 * Servlet implementation class BorrowingServlet
 */
public class BorrowingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BorrowingDAO BorrowingDAo;
	
	public void init() throws ServletException{
		BorrowingDAo = new BorrowingDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) 
			{
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBorrowing(request, response);
				break;
			case "/delete":
				deleteBorrowing(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBorrowing(request, response);
				break;
			case "/list":
				listBorrowing(request, response);
				break;
			}
}
		catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
//Show New Form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("borrowForm.jsp");
		dispatcher.forward(request, response);
	}
	
	
//Insert Book
		private void insertBorrowing(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String memberid = request.getParameter("memberid");
			String bookid = request.getParameter("bookid");
			String currentdate = request.getParameter("currentdate");
			String returndate = request.getParameter("returndate");
			String note = request.getParameter("note");
			Borrowing newBorrowing = new Borrowing(memberid, bookid, currentdate, returndate, note);
			BorrowingDAo.insertBorrowing(newBorrowing);
			response.sendRedirect("new");
		}
		
		

//delete book
		private void deleteBorrowing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			try {
			BorrowingDAo.deleteBorrowing(id);
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list");
		}

	
//edit book
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Borrowing existingBorrowing;
		try {
			existingBorrowing = BorrowingDAo.selectBorrowing(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("borrowFormAdmin.jsp");
			request.setAttribute("borrowing", existingBorrowing);
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

//update book
	private void updateBorrowing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String memberid = request.getParameter("memberid");
		String bookid = request.getParameter("bookid");
		String currentdate = request.getParameter("currentdate");
		String returndate = request.getParameter("returndate");
		String note = request.getParameter("note");

		Borrowing borrowing = new Borrowing(id, memberid, bookid, currentdate, returndate, note);
		BorrowingDAo.updateBorrowing(borrowing);
		response.sendRedirect("list");
	}
	
	
//default
		private void listBorrowing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
		{
			try{
				List<Borrowing> listBorrowing = BorrowingDAo.selectAllBorrowings();
				request.setAttribute("listBorrowing", listBorrowing);
				RequestDispatcher dispatcher = request.getRequestDispatcher("borrowListAdmin.jsp");
				dispatcher.forward(request, response);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	

}