package restaurant_app;

import java.sql.*;
import java.util.*;

public class login {
	
	public static void login_guest() {
		
		try {
			//Establishing connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
			Statement statement = connection.createStatement();
			String query = "SELECT username, password FROM guest";
			ResultSet result = statement.executeQuery(query);
			
			// Hashset for storage usernames and passwords
			Set<String> hash_username_guest = new HashSet<String>();
			Set<String> hash_password_guest = new HashSet<String>();
			
			// Collecting data from the database for Hashset
			while(result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				
				hash_username_guest.add(username);
				hash_password_guest.add(password);
			}
				Scanner user_pass = new Scanner(System.in);
				System.out.println("Please enter your username: ");
				String user = user_pass.nextLine();
				System.out.println("Please eneter your password");
	            String pass = user_pass.nextLine(); 
	            
	            // Check that the data matches the data in the database
	            if(hash_username_guest.contains(user) && hash_password_guest.contains(pass)){
	            	System.out.println("Enjoy in our services.");
	            } else {
	            	System.out.println("Wrong username or password");
	            }
	            
	            
			 
		} catch (Exception e) {
            System.err.println("Error - " + e.getMessage());
		
	}
	
	
	
	

	}  
	

	public static void login_worker() {
		try {
			//Establishing connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/restaurant", "root", "root");
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM worker";
			ResultSet result = statement.executeQuery(query);
			
			// Hashset for storage usernames and passwords
			Set<String> hash_username_worker = new HashSet<String>();
			Set<String> hash_password_worker = new HashSet<String>();
			
			// Collecting data from the database for Hashset
			while(result.next()) {
				String username = result.getString("username");
				String password = result.getString("password");
				
				hash_username_worker.add(username);
				hash_password_worker.add(password);
			}
				Scanner user_pass = new Scanner(System.in);
				System.out.println("Please enter your username: ");
				String user = user_pass.nextLine();
				System.out.println("Please eneter your password");
	            String pass = user_pass.nextLine(); 
	            
	            // Check that the data matches the data in the database
	            if(hash_username_worker.contains(user) && hash_password_worker.contains(pass)){
	            	System.out.println("Hello worker!");
	            } else {
	            	System.out.println("Wrong username or password");
	            }
	            
	            
			 
		} catch (Exception e) {
            System.err.println("Error - " + e.getMessage());
		
	}
	}
}
