package Dao.pack;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener()
public class Cleanup implements ServletContextListener {
	
	 @Override
	    public void contextInitialized(final ServletContextEvent servletContextEvent) {
	    }

	    @Override
	    public void contextDestroyed(final ServletContextEvent servletContextEvent) {
	        final Enumeration<Driver> drivers = DriverManager.getDrivers();
	        while (drivers.hasMoreElements()) {
	            try {
	                final Driver driver = drivers.nextElement();
	                DriverManager.deregisterDriver(driver);
	            } catch (final SQLException e) {
	               
	            }
	        }

	        // See http://docs.oracle.com/cd/E17952_01/connector-j-relnotes-en/news-5-1-23.html
	        try {
	            Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread");
	            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
	        } catch (final ClassNotFoundException ignored) {
	            // MySQL driver not used
	        }

	        // See https://mariadb.atlassian.net/browse/CONJ-61
	        
	    }

}
