package BD;


import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHandling{
		public Connection connection;
		
		public DataBaseHandling() {
			
		}
		
		public void initializeConnection() {
			 String url = "jdbc:mysql://192.168.11.199:3306/BDJava";
			 String username = "javaUser";
			 String password = "Java2024DataBase.passwd";
			 System.out.println("Connecting to database ...");

			 try {
				 setConnection(DriverManager.getConnection(url, username, password));
			     System.out.println("Connected to Database!");
			 } catch (SQLException e) {
			     throw new IllegalStateException("Cannot establish connection to the database!", e);
			 }
		}

		public Connection getConnection() {
			return connection;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}
	
	
	
}
