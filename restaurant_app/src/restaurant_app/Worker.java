package restaurant_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Worker {
	
	public static void orders() {
		
		try {
			//Establishing connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
			Statement statement = connection.createStatement();
			String query = "SELECT guest_username, name_menu, portion_number FROM order";
			ResultSet result = statement.executeQuery(query);
			
			// Collectung data from database
			while (result.next()) {
				String guest_name = result.getString("guest_username");
				String menu_name = result.getString("name_menu");
				String portion = result.getString("portion_number");
				
				// Output data in the console
				System.out.println( "Guest: " + " " + guest_name + "   " + "Menu: " + " " + menu_name + "   " +  "Number of portion: " + portion); 
				
			}
			

		} catch (Exception e) {
			System.err.println("Error - " + e.getMessage());  }
	}
}
