package restaurant_app;

/**
*
* @author vujicdejann
* github - https://github.com/vujicdejann
*/

import java.sql.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		//Establishing connection
		DataBase databaseConnect = new DataBase();
		databaseConnect.base_connect();
		
		
		System.out.println("Welcome to the Restaurant Application.");
		
		// Options
		Scanner choice = new Scanner(System.in);
		System.out.println("Please select option 1 if you are a guest, or 2 if you are a restaurant worker: ");
		String choice_way = choice.nextLine();
		
		if (choice_way.equals("1")) {
			// Login
			login login = new login();
			login.login_guest();
			
			
			
			// Menu
			System.out.println("View menu: ");
			Menu menu = new Menu();
			menu.menu_guest();
			
			// Ordering
			Scanner ordering = new Scanner(System.in);
			System.out.println("Do you want to order? Y/n");
			String question_order = ordering.nextLine();
			
			if (question_order.equals("Y")) {
				Order order = new Order();
				order.order_guest();
			} else if (question_order.equals("n")) {
				System.out.println("Good bye!");
			} else {
				System.out.println("Error!");
			}
		} else if (choice_way.equals("2")) {
			// Login
			login login = new login();
			login.login_worker();
			
			
			
			Scanner add_see = new Scanner(System.in);
			System.out.println("If you want to see orders, select option 1 or if you want to add a new menu, select option 2");
			String menu_orders = add_see.nextLine();
			
			if (menu_orders.equals("1")) {
				// See orders
				Worker see_orders = new Worker();
				see_orders.orders();
			} else if (menu_orders.equals("2")) {
				// Add menu
				AddMenu new_menu = new AddMenu();
				new_menu.adding();
			} else {
				System.out.println("Error!");
			}
			
		}
		
	}

}


