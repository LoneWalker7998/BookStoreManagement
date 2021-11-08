package BookStore;

import java.util.*;
import java.sql.*;
public class login{
	Scanner in = new Scanner(System.in);
	conn c = new conn();
	public void logIntoSystem() throws Exception {
		c.connection();
		//Statement st = c.c.createStatement();
		
		//String sql;
		System.out.println("\n|------------------------------------------|");
		System.out.println("  ******** Enter details to login ********");
		System.out.println("|------------------------------------------|\n");
		
		System.out.print("Enter Username: ");
		String uname = in.next();
		
		System.out.print("Enter password: ");
		String pass = in.next();
		
		System.out.println();
		
		try {
			String sql="select username,password from admin where username=? and  password=?";
			PreparedStatement st1 = c.c.prepareStatement(sql);
			
			st1.setString(1, uname);
			st1.setString(2, pass);
			
			ResultSet result = st1.executeQuery();
			result.next();
			
			String user = result.getString("username");
			String passd = result.getString("password");
			
			if(passd.equals(pass) && user.equals(uname)) {
				System.out.println("\n|=========================================================================================================================|");
				System.out.println("                                               ******* Welcome Admin *******"                                                 );
				System.out.println("|=========================================================================================================================|\n\n");
				admin a = new admin();
				a.admin_function(uname);
			}
			
			else {
				System.out.println("You are not an admin.");
			}
		}
		catch(Exception e1) {
			try {
				// shopkeeper login
				try {
					String sql="select username,password from shopkeeper where username=? and  password=?";
					PreparedStatement st1 = c.c.prepareStatement(sql);
					
					st1.setString(1, uname);
					st1.setString(2, pass);
					
					ResultSet result = st1.executeQuery();
					result.next();
					
					String user = result.getString("username");
					String passd = result.getString("password");
					
					if(passd.equals(pass) && user.equals(uname)) {
						System.out.println("\n|=========================================================================================================================|");
						System.out.println("                                            ******* Welcome Shopkeeper *******"                                               );
						System.out.println("|=========================================================================================================================|\n\n");
						shopkeeper s = new shopkeeper();
						s.shopkeeper_function(uname);
					}
					
					else {
						System.out.println("You are not an shopkeeper.");
					}
				}
				catch(Exception e4) {
					String sql="select username,password from users where username=? and  password=?";
					PreparedStatement st1 = c.c.prepareStatement(sql);
					
					st1.setString(1, uname);
					st1.setString(2, pass);
					
					ResultSet result = st1.executeQuery();
					result.next();
					
					String user = result.getString("username");
					String passd = result.getString("password");
					
					//String name = result.getString("firstname");
					
					if(passd.equals(pass) && user.equals(uname)) {
						System.out.println("\n|=========================================================================================================================|");
						System.out.println("                                         ******** Welcome " + " " + user + " ********"                                        );
						System.out.println("|=========================================================================================================================|\n\n");
						//System.out.println("Welcome " + " " + user);
						user u = new user();
						u.user_function(uname);
					}
					
					else {
						System.out.println("Please SignUp first to login ");
					}
				}
				
				
				// user login 
				String sql="select username,password from users where username=? and  password=?";
				PreparedStatement st1 = c.c.prepareStatement(sql);
				
				st1.setString(1, uname);
				st1.setString(2, pass);
				
				ResultSet result = st1.executeQuery();
				result.next();
				
				String user = result.getString("username");
				String passd = result.getString("password");
				
				//String name = result.getString("firstname");
				
				if(passd.equals(pass) && user.equals(uname)) {
					System.out.println("\n|=========================================|");
					System.out.println("    ******** Welcome " + " " + user + " ********" );
					System.out.println("|=========================================|\n\n");
					//System.out.println("Welcome " + " " + user);
					user u = new user();
					u.user_function(uname);
				}
				
				else {
					System.out.println("Please SignUp first to login ");
				}
			}
			
			catch(SQLException e2) {
				System.out.println("Username or Password didn't match");
				System.out.println("Please Login with correct username or Signup first.\n");
				System.out.println("\n|====================================================|");
				//System.out.println("-----------------------------");
				System.out.println("************ Book Shop Management System ************");
				System.out.println("|====================================================|\n");
				
				System.out.println("\n***************** Options *****************");
				System.out.println("------------------------------------------");
				System.out.println("1.	Login");
				System.out.println("2.	SignUp");
				System.out.println("3.	Exit");
				System.out.println("------------------------------------------\n");
				System.out.print("Enter your choice: ");
				int choice =in.nextInt();
				in.nextLine();
				if(choice == 1)
				{
					logIntoSystem();
				}
				if(choice == 2) 
				{
					signup su= new signup();
					su.inputDetails();
				}
				if(choice == 3) {
					System.exit(0);
				}
			}
			catch(Exception e3) {
				System.out.println(e3);
			}
		}
	}
}