package BookStore;

import java.util.*;

import BookStore.conn;
import java.sql.*;

public class signup {
	public static void main (String[] args) {
		signup su = new signup();
		su.inputDetails();
	}
	
	public void inputDetails() {
		Scanner in = new Scanner(System.in);
		
		conn c = new conn();
		
		try {
			c.connection();
			System.out.println("\n|------------------------------------------|");
			System.out.println(" ******* Enter details to register *******");
			System.out.println("|------------------------------------------|\n");
			
			System.out.print("Enter Username: ");
			String uname = in.nextLine();
			
			System.out.print("Enter password: ");
			String pass = in.nextLine();
			
			System.out.print("Enter first name: ");
			String fname = in.nextLine();
			
			System.out.print("Enter last name: ");
			String lname = in.nextLine();
			
			System.out.print("Enter address: ");
			String add = in.nextLine();
			
			System.out.print("Enter Mobile number: ");
			String mob = in.nextLine();
			
			System.out.print("Enter email id: ");
			String email = in.nextLine();
			
			System.out.println();
			
			String sql = "insert into users values(?,?,?,?,?,?,?)";
			
			PreparedStatement st1 = c.c.prepareStatement(sql);
			
			st1.setNString(1, uname);
			st1.setNString(2, pass);
			st1.setNString(3, fname);
			st1.setNString(4, lname);
			st1.setNString(5, add);
			st1.setNString(6, mob);
			st1.setNString(7, email);
			
			st1.execute();
			
			System.out.println("Successfully registered..\n");
			Main.logout();
			
		}
			
		catch(SQLIntegrityConstraintViolationException e1) {
			System.out.println("Sorry this username is taken by another user \nPlease try with different username\n");
				inputDetails();
			}
		catch(Exception e2) {
			System.out.println(e2);
				
		}
		
		
	}
}
