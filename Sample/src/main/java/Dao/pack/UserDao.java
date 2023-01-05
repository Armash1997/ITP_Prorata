package Dao.pack;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.pack.User;




/**
 * 
 * 
 * 
 * @author Armash Ahamed
 *
 */
public class UserDao {


	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, password) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select memberid,name,email,password from users where memberid = ?;";
	private static final String SELECT_ALL_USERS = "select * from users;";
	private static final String DELETE_USERS_SQL = "delete from users where memberid = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, password =? where memberid = ?;";

	public UserDao() {
	}


	public String insert(User member) {
		// TODO Auto-generated method stub
		
		
		Connection con = null;
		try {
			con = Dbconnection.getConnection();
		} catch (SQLException|ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String result = "Executed";
		String INSERT_SQL = "INSERT INTO users" + "  (name, email, password) VALUES "
				+ " (?, ?, ?);";
		
		try {
			PreparedStatement statement = con.prepareStatement(INSERT_SQL);
			
			statement.setString(1,member.getName());
			statement.setString(2,member.getEmail());
			statement.setString(3,member.getPassword());
			

			
			statement.executeUpdate();
			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
			
			result = "Not Executed";
			
		
		 }
		return result;
		
	}
	
	public ResultSet validate1(User login) throws ClassNotFoundException, SQLException {
		ResultSet resultSet = null;
		
	
		Connection con = Dbconnection.getConnection();
		
		
		String SELECT_SQL = "select * from admin where name = ? and password = ?";
		
		try {
			PreparedStatement statement = con.prepareStatement(SELECT_SQL);
			
			statement.setString(1,login.getName());
			statement.setString(2,login.getPassword());
			
			ResultSet rs = statement.executeQuery();
			
			resultSet = rs;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return resultSet;
	}


	
	public ResultSet validate(User login) {
		ResultSet resultSet = null;
		Connection con = null;
		try {
			con = Dbconnection.getConnection();
		} catch (SQLException|ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	
		
		String SELECT_SQL = "select * from users where name=? and password=?";
		
		try {
			PreparedStatement statement = con.prepareStatement(SELECT_SQL);
			
			statement.setString(1,login.getName());
			statement.setString(2,login.getPassword());
			
			ResultSet rs = statement.executeQuery();
			
			 resultSet = rs;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return resultSet;
	}

	
	
	public void insertUser(User user) throws SQLException, ClassNotFoundException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = Dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public  User selectUser(int id) throws ClassNotFoundException {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = Dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User(id, name, email, password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() throws ClassNotFoundException {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = Dbconnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("memberid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				users.add(new User(id, name, email, password));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		try (Connection connection = Dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		try (Connection connection = Dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());
			System.out.println("updated USer:"+statement);
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private static void printSQLException(SQLException ex) {
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
