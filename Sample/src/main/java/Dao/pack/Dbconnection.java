package Dao.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Dbconnection {
	
	public static String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
	public static String jdbcUsername = "root";
	public static String jdbcPassword = "armash123";
	public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static Connection connection;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		if (connection == null || connection.isClosed()) {

			try {
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException|ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	}
		return connection;
	
}
}

