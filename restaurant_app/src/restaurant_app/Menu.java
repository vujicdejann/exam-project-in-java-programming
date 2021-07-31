package restaurant_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu {
	public static void menu_guest() {
		
		try {
			//Establishing connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM menu";
			ResultSet result = statement.executeQuery(query);
			
			// Collecting data from database
			while (result.next()) {
				String name = result.getString("name");
				int calories = result.getInt("calories");
				int price = result.getInt("price");
				
				// Output data in the console
				System.out.println( "Name: " + " " + name + "   " + "Calories (KCal): " + " " + calories + "   " +  "Price: " + price); 
				
			} 
			
		} catch (Exception e) {
			System.err.println("Error - " + e.getMessage());  }
	}}
