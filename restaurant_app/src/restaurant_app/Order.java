package restaurant_app;

import java.sql.*;
import java.util.*;

public class Order {

	public static void order_guest() {
		
		try {
			//Establishing connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
			Statement statement = connection.createStatement();
			
			// Input for new order
			Scanner ordering = new Scanner(System.in);
			System.out.println("Please enter your username to start ordering: ");
			String guest_username = ordering.nextLine();
			System.out.println("Please enter food:  ");
			String guest_food = ordering.nextLine();
			System.out.println("Please enter number of portion: ");
			String guest_portion = ordering.nextLine();
			
			// Query for adding data in database
			PreparedStatement pst = connection.prepareStatement("INSERT INTO order(guest_username, name_menu, portion_number) VALUES (?, ?, ?)");
			
			pst.setString(1, guest_username);
			pst.setString(2, guest_food);
			pst.setString(3, guest_portion);
			pst.executeUpdate();

		
		
		} catch (Exception e) {
			System.err.println("Error - " + e.getMessage());  }
			
		
	}
}
