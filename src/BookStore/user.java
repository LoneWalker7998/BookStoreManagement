package BookStore;

import java.util.*;
import java.sql.*;

public class user {
	Scanner in = new Scanner(System.in);
	conn c = new conn();
	void user_function(String uname)throws Exception{
		c.connection();
		Statement st = c.c.createStatement();
		String sql;
		ResultSet rs;
		int back_to_menu = 0;
		while(true) {
			System.out.println("\n************* User Options **************");
			System.out.println("|=========================================|");
			System.out.println("1. View profile");
			System.out.println("2. Edit profile");
			System.out.println("3. Search & Buy Books");
			//System.out.println("4. Add Book to Cart");
			System.out.println("4. Logout");
			System.out.println("|=========================================|\n");
			
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			in.nextLine();
			
			switch(choice) {
				case 1: sql = "SELECT username, password, firstname, lastname, address, phone, mailid FROM users WHERE username='"+uname+"'";
						ResultSet rs1 = st.executeQuery(sql);
						while(rs1.next()) {
							System.out.println("\n************** User Profile **************");
							System.out.println("|-----------------------------------------|");
							System.out.println("Name = "+ rs1.getString(3)+" "+ rs1.getString(4));
							System.out.println("Address = "+ rs1.getString(5));
							System.out.println("Mobile no.  = "+ rs1.getString(6));
							System.out.println("Email Id = "+ rs1.getString(7));
							
							System.out.println("|-----------------------------------------|\n");
							break;
						}
						break;
						
				case 2: 
						while(true) {
							System.out.println("\n***************** Options *****************");
							System.out.println("|=========================================|");
							System.out.println("1. Update First Name");
							System.out.println("2. Update Last Name");
							System.out.println("3. Update Mobile no.");
							System.out.println("4. Update Address");
							System.out.println("5. Update password");
							System.out.println("6. Back to main menu");
							System.out.println("|=========================================|\n");
							
							System.out.print("Enter your choice: ");
							int option = in.nextInt();
							in.nextLine();
							
							switch(option) {
								case 1: System.out.print("Enter New First Name: ");
										String fname = in.nextLine();
										sql = "UPDATE users SET firstname='"+fname+"' WHERE username='"+uname+"'";
										st.executeUpdate(sql);
										System.out.println("Updated Successfully!");
										break;
										
								case 2: System.out.print("Enter New Last Name: ");
										String lname = in.nextLine();
										sql = "UPDATE users SET lastname='"+lname+"' WHERE username='"+uname+"'";
										st.executeUpdate(sql);
										System.out.println("Updated Successfully!");
										break;
										
								case 3: System.out.print("Enter New Mobile no.: ");
										String mob = in.nextLine();
										sql = "UPDATE users SET phone='"+mob+"' WHERE username='"+uname+"'";
										st.executeUpdate(sql);
										System.out.println("Updated Successfully!");
										break;
										
								case 4: System.out.print("Enter New Address: ");
										String  add= in.nextLine();
										sql = "UPDATE users SET address='"+add+"' WHERE username='"+uname+"'";
										st.executeUpdate(sql);
										System.out.println("Updated Successfully!");
										break;
										
								case 5: 
										System.out.print("Enter your current password: ");
										String old_p = in.nextLine();
										sql = "SELECT password FROM users WHERE username='"+uname+"'";
										ResultSet rs2 = st.executeQuery(sql);
										rs2.next();
										String pass = rs2.getString(1);
										if(old_p.equals(pass)) {
											System.out.print("Enter new password: ");
											String new_p = in.nextLine();
											if(old_p.equals(new_p)) {
												System.out.println("Warning: New password is same as old one");
												
											}
											else {
												sql = "UPDATE users SET password='"+new_p+"' WHERE username='"+uname+"'";
												st.executeUpdate(sql);
												System.out.println("Password Updated Successfully");
											}
										}
										else {
											System.out.println("Your entered current password is wrong, Please enter correct password!");
										}
								
										break;
										
								case 6: back_to_menu = 1;
										break;
								
								default: System.out.println("Enter a valid choice.");
								
							}
							
							if(back_to_menu == 1) {
								back_to_menu = 0;
								break;
							}
						}
						break;
					
				case 3: books_stock bs = new books_stock();
						bs.stock(uname);
						break;
						
				//case 4: break;
				
				case 4
				: System.out.println("\nLogout Successful..\n\n");
						Main.logout();
						
				default : System.out.println("Enter a valid choice.");
			}
		}
		
	}
}
