package BookStore;


import java.util.*;
import java.sql.*;


public class shopkeeper {
	Scanner in = new Scanner(System.in);
	conn c = new conn();
	
	void shopkeeper_function(String uname)throws Exception{
		c.connection();
		Statement st = c.c.createStatement();
		String sql;
		ResultSet rs;
		int back_to_menu = 0;
		
		while(true) {
			System.out.println("\n********** Shopkeeper Options **********");
			System.out.println("|=========================================|");
			System.out.println("1. Book Section");
			System.out.println("2. User Section");
			System.out.println("3. View your profile");
			System.out.println("4. Change Password");
			System.out.println("5. LogOut");
			System.out.println("|=========================================|\n");
			
			System.out.print("Enter your choice: ");
			int choice = in.nextInt();
			in.nextLine();
			
			switch(choice) {
				case 1:	int c1 = 0;
						while(true) {
							System.out.println("\n***************** Options *****************");
							System.out.println("|=========================================|");
							System.out.println("1. Add Book");
							System.out.println("2. View all Books");
							System.out.println("3. Modify book details");
							System.out.println("4. Go back");
							System.out.println("|=========================================|\n");
							
							//int c2 = 0;
							
							System.out.print("Enter your choice: ");
							int option1 = in.nextInt();
							in.nextLine();
							
							switch(option1) {
							 	case 1: System.out.println("***************** Enter Book Details *****************\n");
								
										try {
											System.out.print("Enter ISBN no. : ");
											String isbn = in.nextLine();
											System.out.print("Enter Book Title : ");
											String title = in.nextLine();
											System.out.print("Enter author's name : ");
											String author = in.nextLine();
											System.out.print("Enter Price : ");
											int price = in.nextInt();
											in.nextLine();
											System.out.print("Enter Quantity. : ");
											int quant = in.nextInt();
											in.nextLine();
											System.out.print("Enter Book Category : ");
											String cat = in.nextLine();
											
											sql = "INSERT INTO books VALUES('"+isbn+"', '"+title+"', '"+author+"', "+price+", "+quant+", '"+cat+"')";
											st.executeUpdate(sql);
											
											System.out.println("Book added successfully.");
										}
										catch(Exception e1) {
											System.out.println(e1);
										}
										break;
								
							 	case 2:	System.out.println("============================================================== All Books =====================================================================");
								
										sql = "SELECT * FROM books";
										ResultSet rs1 = st.executeQuery(sql);
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										while(rs1.next()) {
											String book_details = rs1.getString(1)+"               "+rs1.getString(2)+"                         "+rs1.getString(3)+"                    "+rs1.getInt(4)+"              "+rs1.getInt(5)+"                    "+rs1.getString(6);
											System.out.println(book_details);
										}
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										break; 
							 		
							 	case 3: int flag1 = 0;
							             while(true) {
							            	 System.out.println("\n******* Choose a option to Modify ********");
							            	 System.out.println("|=========================================|");
							            	 System.out.println("1. Update Book details\n2. Delete book\n3. Go Back");
							            	 System.out.println("|=========================================|\n");
							            	 System.out.print("Enter your choice: ");
							            	 int option = in.nextInt();
							            	 in.nextLine();
							            	 switch(option) {
							            	 	case 1: 
							            	 			int flag2 = 0;
							            	 			while(true) {
							            	 				System.out.println("\n************ Update Options ***********");
							            	 				System.out.println("|=========================================|");
								            	 			System.out.println("1. To edit Book Price only");
								            	 			System.out.println("2. To edit Book Quantity only");
								            	 			System.out.println("3. To edit both price & quantity of book");
								            	 			System.out.println("4. Go back");
								            	 			System.out.println("|=========================================|\n");
								            	 			
								            	 			System.out.print("Enter your choice: ");
								            	 			int ch = in.nextInt();
								            	 			in.nextLine();
								            	 			switch(ch) {
								            	 				case 1: System.out.print("\nEnter ISBN number of book to update its price: ");
								            	 						String isbn = in.nextLine();
								            	 						System.out.print("Enter new price for the book: ");
								            	 						int price = in.nextInt();
								            	 						in.nextLine();
								            	 						PreparedStatement pst1 = c.c.prepareStatement("UPDATE books SET price="+price+" where isbn='"+isbn+"'");
								            	 						pst1.execute();
								            	 						System.out.println("Update successful.\n\n");
								            	 						break;
								            	 				
								            	 				case 2: System.out.print("Enter ISBN number of book to update its quantity: ");
								            	 						isbn = in.nextLine();
								            	 						System.out.print("Enter new quantity for the book: ");
								            	 						int quant = in.nextInt();
								            	 						in.nextLine();
								            	 						pst1 = c.c.prepareStatement("UPDATE books SET quantity="+quant+" where isbn='"+isbn+"'");
								            	 						pst1.execute();
								            	 						System.out.println("Update successful.\n\n");
								            	 						break;
								            	 						
								            	 				case 3: System.out.print("Enter ISBN number of book to update its price & quantity both: ");
								            	 						isbn = in.nextLine();
								            	 						System.out.print("Enter new price for the book: ");
								            	 	
								            	 						price = in.nextInt();
								            	 						System.out.print("Enter new quantity for the book: ");
								            	 						quant = in.nextInt();
								            	 						pst1 = c.c.prepareStatement("UPDATE books SET quantity="+quant+", price="+price+" where isbn='"+isbn+"'");
								            	 						pst1.execute();
								            	 						System.out.println("Update successful.\n\n");
								            	 						break;
								            	 				case 4: flag2++;
								            	 						break;
								            	 						
								            	 						
								            	 			}
								            	 			
								            	 			if(flag2 > 0) {
								            	 				flag2 = 0;
								            	 				break;
								            	 			}
							            	 			}
							            	 	break;
							            	 	
							            	 	
							            case 2: System.out.print("Entre ISBN no. to delete the book from system: ");
							            		String isbn = in.nextLine();
							       	 			PreparedStatement pst2 = c.c.prepareStatement("DELETE FROM books where isbn = '"+isbn+"'");
							      	 			pst2.executeUpdate();
							      	 			System.out.println("Book is deleted.");
					            	 			break;
							            	 	
					            	 			
					            	 	case 3: flag1++;
					            	 			break;
					            	 			
					            	 }
					            	 
					            	 if(flag1 > 0) {
					            		 flag1 = 0;
					            		 break;
					            	 }
					             }
					            break;
							          
					            
							case 4: c1++;
							 		break;
							 		
 							            		
							}
							
							if(c1 > 0) {
								c1 = 0;
								break;
							}
						}
						
						break;
						
				case 2: int c2 = 0;
						while(true) {
							System.out.println("\n***************** Options *****************");
							System.out.println("|=========================================|");
							System.out.println("1. View All Users");
							System.out.println("2. View Users Transaction Details");
							//System.out.println("3. Remove User");
							System.out.println("4. Go back");
							System.out.println("|=========================================|\n");
							
							System.out.print("Enter your choice: ");
							int option2 = in.nextInt();
							in.nextLine();
							
							switch(option2) {
								case 1:	System.out.println("============================================================== All Users  ============================================================");
										sql = "SELECT * FROM users";
										ResultSet rs2 = st.executeQuery(sql);
										System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("Username              Email ID                    First Name          Last Name          Address           Phone");
										System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
										while(rs2.next()) {
											String user_details = rs2.getString(1)+"             "+rs2.getString(7)+"           "+rs2.getString(3)+"            "+rs2.getString(4)+"             "+rs2.getString(5)+"            "+rs2.getString(6);
											System.out.println(user_details);
										}
										System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
										break;
										
								case 2: System.out.println("=============================================================================== Transaction details  ============================================================================");
										System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										ResultSet rset = st.executeQuery("select * from transaction");
										System.out.println("Tansaction ID              Customer                    Payment Method               Total transaction_amount              Transaction Date                   Transaction Time");
										System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										while(rset.next()) {
											int t_id = rset.getInt(1);
											String c_name = rset.getString(2);
											String t_method = rset.getString(3);
											int t_amount = rset.getInt(4);
											String t_date = rset.getString(5);
											String t_time = rset.getString(6);
											System.out.println(t_id+ "                          " + c_name+ "                    " +t_method+ "                             " + t_amount+ "                              " + t_date + "                            "+t_time);
											
										}
										System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										
										break;
										
								
							 			
								case 3: c2++;
										break;
								
							}
							if(c2 > 0) {
								c2 = 0;
								break;
							}
						}
						break;
							
				case 3: sql = "SELECT username, password, firstname, lastname, address, phone, mailid FROM shopkeeper WHERE username='"+uname+"'";
						ResultSet rs1 = st.executeQuery(sql);
						while(rs1.next()) {
							System.out.println("\n********** Shopkeeper Profile **********");
							System.out.println("|-----------------------------------------|");
							System.out.println("Name = "+ rs1.getString(3)+" "+ rs1.getString(4));
							System.out.println("Address = "+ rs1.getString(5));
							System.out.println("Mobile no.  = "+ rs1.getString(6));
							System.out.println("Email Id = "+ rs1.getString(7));
							
							System.out.println("|-----------------------------------------|\n");
							break;
						}
						break;
				
				case 4: System.out.print("Enter your current password: ");
						String old_p = in.nextLine();
						sql = "SELECT password FROM shopkeeper WHERE username='"+uname+"'";
						ResultSet rs3 = st.executeQuery(sql);
						rs3.next();
						String pass = rs3.getString(1);
						if(old_p.equals(pass)) {
							System.out.print("Enter new password: ");
							String new_p = in.nextLine();
							if(old_p.equals(new_p)) {
								System.out.println("Warning: New password is same as old one");
								
							}
							else {
								sql = "UPDATE shopkeeper SET password='"+new_p+"' WHERE username='"+uname+"'";
								st.executeUpdate(sql);
								System.out.println("Password Updated Successfully");
							}
						}
						else {
							System.out.println("Your entered current password is wrong, Please enter currect password.");
						}
				
						break;
						
								
				case 5: System.out.println("\nLogout Successful..\n\n");
						Main.logout();
						break;
						
				default: System.out.println("Enter a valid choice.");
						
				
			}
		}
	}
}