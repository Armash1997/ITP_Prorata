package Dao.pack;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.pack.Borrowing;





public class BorrowingDAO {
	

	
	private static final String INSERT_BORROWINGS_SQL = "INSERT INTO borrowing" + "  (memberid, bookid, currentdate, returndate, note) VALUES "
			+ " (?, ?, ?, ?, ? );";

	private static final String SELECT_BORROWING_BY_ID = "select id, memberid, bookid, currentdate, returndate, note from borrowing where id =?";
	private static final String SELECT_ALL_BORROWINGS = "select * from borrowing";
	private static final String DELETE_BORROWINGS_SQL = "delete from borrowing where id = ?;";
	private static final String UPDATE_BORROWINGS_SQL = "update borrowing set memberid = ?, bookid = ?,currentdate= ?, returndate =?, note= ? where id = ?;";
	

	


	public void insertBorrowing(Borrowing borrowing) throws SQLException {
		System.out.println(INSERT_BORROWINGS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = Dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROWINGS_SQL)) {
			preparedStatement.setString(1, borrowing.getMemberid());
			preparedStatement.setString(2, borrowing.getBookid());
			preparedStatement.setString(3, borrowing.getCurrentdate());
			preparedStatement.setString(4, borrowing.getReturndate());
			preparedStatement.setString(5, borrowing.getNote());
			
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	//select borrowing by id
	
		public Borrowing selectBorrowing(int id) {
			Borrowing borrowing = null;
			// Step 1: Establishing a Connection
			try (Connection connection = Dbconnection.getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROWING_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String memberid = rs.getString("memberid");
					String bookid = rs.getString("bookid");
					String currentdate = rs.getString("currentdate");
					String returndate = rs.getString("returndate");
					String note = rs.getString("note");
					borrowing = new Borrowing(id,memberid,bookid,currentdate,returndate,note);
				}
			} catch (SQLException|ClassNotFoundException e) {
				e.printStackTrace();
			}
			return borrowing;
		}
	
		
		
		
	//select All users
		
		public List<Borrowing> selectAllBorrowings() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			
			List<Borrowing> borrowing = new ArrayList<>();
			
			// Step 1: Establishing a Connection
			try (Connection connection = Dbconnection.getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BORROWINGS);) {
				System.out.println(preparedStatement);
				
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String memberid = rs.getString("memberid");
					String bookid = rs.getString("bookid");
					String currentdate = rs.getString("currentdate");
					String returndate = rs.getString("returndate");
					String note = rs.getString("note");
					borrowing.add(new Borrowing(id, memberid, bookid, currentdate, returndate, note));
				}
			}  catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				printSQLException(e1);
			}
			return borrowing;
		}

		
	

	//update borrowing

	public boolean updateBorrowing(Borrowing borrowing) throws SQLException{
		boolean rowUpdated = false;
		
		// Step 1: Establishing a Connection
		try (Connection connection = Dbconnection.getConnection();
				
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(UPDATE_BORROWINGS_SQL);) {
			System.out.println("updated BORROWING:" +statement);
			statement.setString(1, borrowing.getMemberid());
			statement.setString(2, borrowing.getBookid());
			statement.setString(3, borrowing.getCurrentdate());
			statement.setString(4, borrowing.getReturndate());
			statement.setString(5, borrowing.getNote());
			statement.setInt(6, borrowing.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return rowUpdated;
	}
	
	
	
	//delete borrowing

	public boolean deleteBorrowing(int id) throws SQLException {
		boolean rowDeleted = false;
		try (Connection connection = Dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BORROWINGS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	
	


}
