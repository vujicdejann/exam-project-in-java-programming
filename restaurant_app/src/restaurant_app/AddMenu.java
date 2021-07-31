package restaurant_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AddMenu {
	public static void adding() {

		try {
			//Establishing connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
			Statement statement = connection.createStatement();
			
			// Input for new menu
			Scanner adding = new Scanner(System.in);
			System.out.println("Please enter name of new menu: ");
			String add_name = adding.nextLine();
			System.out.println("Please enter number of calories:  ");
			String add_calories = adding.nextLine();
			System.out.println("Please enter the price: ");
			String add_price = adding.nextLine();
			
			// Query for adding data in database
			PreparedStatement pst = connection.prepareStatement("INSERT INTO menu(name, calories, price) VALUES (?, ?, ?)");
			
			pst.setString(1, add_name);
			pst.setString(2, add_calories);
			pst.setString(3, add_price);
			pst.executeUpdate();
			
			System.out.println("You are added a new menu item.");

		
		
		} catch (Exception e) {
			System.err.println("Error - " + e.getMessage());  }
	}
}