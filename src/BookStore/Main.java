package BookStore;

import BookStore.conn;
import java.util.*;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		try {
		while(true) {
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
		
		int option = in.nextInt();
		in.nextLine();
		switch(option) {
			case 1: login l = new login();
					l.logIntoSystem();
					break;
							  
			
			case 2: signup su = new signup();
					su.inputDetails();
					break;
			
			case 3: System.exit(0);
			
			default: System.out.println("Please ! Enter a valid choice.\n");
					
		}
		}
		}
		catch(Exception e) {
			System.out.println(e);
			main(null);
		}

	}
	public static void logout() throws Exception{
		main(null);
	}

}
