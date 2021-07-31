package restaurant_app;

import java.sql.*;

public class DataBase {
	
	public static void base_connect() {
	
	try {
		//Establishing connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
		System.out.println("Connected with the database successfully");
		
	} catch (SQLException e) {
		System.out.println("Error while connecting to the database");
	}

	}
}