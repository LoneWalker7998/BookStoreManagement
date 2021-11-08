package BookStore;

import java.util.*;

import BookStore.conn;
import java.sql.*;

public class books_stock {
	Scanner in = new Scanner(System.in);
	conn c = new conn();
	int add = 0;
	public void stock(String user) {
		try {
			c.connection();
			PreparedStatement pst = c.c.prepareStatement("insert into customer(username) values (?)");
			pst.setNString(1, user);
			pst.execute();
			pst = c.c.prepareStatement("select last_insert_id() as current");
			ResultSet rset = pst.executeQuery();
			rset.next();
			
			int custom_id = rset.getInt("current");
			//pst.setString(1,u);
			//pst.execute();
			
			//while(true) {
				System.out.println("\n************ Search Options ************");
				System.out.println("|=========================================|");
				System.out.println("1. View all Books");
				System.out.println("2. View by book category");
				System.out.println("3. Search by Title ");
				System.out.println("4. Search by author");
				//System.out.println("5. Add to Cart");
				System.out.println("7. LogOut");
				System.out.println("|=========================================|\n");
				while(true) {
				System.out.print("Enter your choice: ");
				int option = in.nextInt();
				in.nextLine();
				switch(option){
					case 1: Statement st1 = c.c.createStatement();
							ResultSet set = st1.executeQuery("select * from books");
							System.out.println("============================================================== All Books =====================================================================");
							
							System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
							System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
							System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
							while(set.next()) {
								String isbn = set.getString(1);
								String title = set.getString(2);
								String author = set.getNString(3);
								int price = set.getInt(4);
								int quant = set.getInt(5);
								String cat = set.getString(6);
								
								String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
								System.out.println(book_details);
								
								
							}
							System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
							
							if(add > 0) {
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add More items to Cart");
								System.out.println("6. For Payment");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							}
							
							else {
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add to Cart");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							}
							break;
							
							
					case 2:	System.out.println("\n************ Search Options ************");
							System.out.println("|=========================================|");
							System.out.println("Select category type: ");
							System.out.println("---------------------------");
							System.out.println("1. Novels");
							System.out.println("2. Science Fiction" );
							System.out.println("3. History" );
							System.out.println("4. Computer Science" );
							System.out.println("5. Literature" );
							System.out.println("|=========================================|\n");
							
							System.out.print("Enter your choice: ");
							int choice = in.nextInt();
							in.nextLine();
							switch(choice) {
								case 1: Statement st2 = c.c.createStatement();
										ResultSet set2 = st2.executeQuery("select * from books where category='Novels'");
										System.out.println("================================================================= Novels =====================================================================");
										
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										while(set2.next()) {
											String isbn = set2.getString(1);
											String title = set2.getString(2);
											String author = set2.getNString(3);
											int price = set2.getInt(4);
											int quant = set2.getInt(5);
											String cat = set2.getString(6);
											
											String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
											System.out.println(book_details);
									
										}
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										if(add > 0) {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add More items to Cart");
											System.out.println("6. For Payment");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										else {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add to Cart");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										break;
										
								case 2: Statement st3 = c.c.createStatement();
										ResultSet set3 = st3.executeQuery("select * from books where category='Science Fiction'");
										
										System.out.println("============================================================ Science Fictions ================================================================");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										while(set3.next()) {
											String isbn = set3.getString(1);
											String title = set3.getString(2);
											String author = set3.getNString(3);
											int price = set3.getInt(4);
											int quant = set3.getInt(5);
											String cat = set3.getString(6);
											
											String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
											System.out.println(book_details);
										}
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										
										if(add > 0) {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add More items to Cart");
											System.out.println("6. For Payment");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										else {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add to Cart");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										break;	
										
								case 3: Statement st4 = c.c.createStatement();
										ResultSet set4 = st4.executeQuery("select * from books where category='History'");
										System.out.println("================================================================= History =====================================================================");
										
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										while(set4.next()) {
											String isbn = set4.getString(1);
											String title = set4.getString(2);
											String author = set4.getNString(3);
											int price = set4.getInt(4);
											int quant = set4.getInt(5);
											String cat = set4.getString(6);
											
											String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
											System.out.println(book_details);
									
										}
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										
										if(add > 0) {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add More items to Cart");
											System.out.println("6. For Payment");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										else {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add to Cart");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										break;		
										
								case 4: Statement st5 = c.c.createStatement();
										ResultSet set5 = st5.executeQuery("select * from books where category='Computer Science'");
										System.out.println("============================================================ Computer Science ================================================================");
										
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										while(set5.next()) {
											String isbn = set5.getString(1);
											String title = set5.getString(2);
											String author = set5.getNString(3);
											int price = set5.getInt(4);
											int quant = set5.getInt(5);
											String cat = set5.getString(6);
											
											String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
											System.out.println(book_details);
									
										}
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										
										if(add > 0) {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add More items to Cart");
											System.out.println("6. For Payment");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										else {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add to Cart");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										break;
										
										
								case 5: Statement st6 = c.c.createStatement();
										ResultSet set6 = st6.executeQuery("select * from books where category='Literature'");
										System.out.println("=============================================================== Literature ===================================================================");
										
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										while(set6.next()) {
											String isbn = set6.getString(1);
											String title = set6.getString(2);
											String author = set6.getNString(3);
											int price = set6.getInt(4);
											int quant = set6.getInt(5);
											String cat = set6.getString(6);
											
											String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
											System.out.println(book_details);
										}
										System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
										
										if(add > 0) {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add More items to Cart");
											System.out.println("6. For Payment");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										else {
											System.out.println("\n************ Search Options ************");
											System.out.println("|=========================================|");
											System.out.println("1. View all Books");
											System.out.println("2. View by book category");
											System.out.println("3. Search by Title ");
											System.out.println("4. Search by author");
											System.out.println("5. Add to Cart");
											System.out.println("7. LogOut");
											System.out.println("|=========================================|\n");
										}
										
										break;
								
							}
						break;	
						
					case 3:
							System.out.println();
							System.out.print("Enter book title: ");
							String b_title = in.nextLine();
							
							Statement st7 = c.c.createStatement();
							ResultSet check1 = st7.executeQuery("select title from books");
							int count = 0;
							while(check1.next()) {
								if(b_title.equals(check1.getString(1))) {
									count = 0;
									ResultSet set7 = st7.executeQuery("select * from books where title = '"+b_title+"' ");
									System.out.println("============================================================= Book by Title ==================================================================");
									
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
									while(set7.next()) {
										String isbn = set7.getString(1);
										String title = set7.getString(2);
										String author = set7.getNString(3);
										int price = set7.getInt(4);
										int quant = set7.getInt(5);
										String cat = set7.getString(6);
										
										String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
										System.out.println(book_details);
										
									}
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
									break;
								}
								else {
									count++;
								}
							}
							if(count > 0) {
								System.out.println("\nBook Not found!!!\n");
							}
							
							if(add > 0) {
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add More items to Cart");
								System.out.println("6. For Payment");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							}
							
							else {
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add to Cart");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							}
							
							break;
							
							
					case 4: System.out.println();
							System.out.print("Enter author's name : ");
							String b_author = in.nextLine();
							
							Statement st8 = c.c.createStatement();
							ResultSet check2 = st8.executeQuery("select author from books");
							int count2 = 0;
							
							while(check2.next()) {
								if(b_author.equals(check2.getString(1))) {
									count2 = 0;
							
									ResultSet set8 = st8.executeQuery("select * from books where author = '"+b_author+"' ");
									System.out.println("=========================================================== Book by Category =================================================================");
									
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("ISBN no.               Title                              Author                       Price          Quantity               Category");
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
									while(set8.next()) {
										String isbn = set8.getString(1);
										String title = set8.getString(2);
										String author = set8.getNString(3);
										int price = set8.getInt(4);
										int quant = set8.getInt(5);
										String cat = set8.getString(6);
										
										String book_details = isbn+"               "+title+"                         "+author+"                    "+price+"              "+quant+"                    "+cat;
										System.out.println(book_details);
								
									}
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
									
									break;
								}
								else {
									count2++;
								}
							}
							if(count2 > 0) {
								System.out.println("\nBook Not found!!!\n");
							}
							
							if(add > 0) {
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add More items to Cart");
								System.out.println("6. Generate Bill for Payment");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							}
							
							else {
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add to Cart");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							}
							
							break;
					
					case 5: System.out.println("\n|===================== ADD TO CART ======================|");
							System.out.println("Enter ISBN no. and quantity for adding books to cart");
							System.out.println("--------------------------------------------------------\n");
							System.out.print("Enter ISBN no. of the book: ");
							String isbn = in.nextLine();
							System.out.print("Enter Quantity: ");
							int quant = in.nextInt();
							in.nextLine();
							PreparedStatement pst2 = c.c.prepareStatement("select quantity from books where isbn ='"+isbn+"'");
							ResultSet rset2 = pst2.executeQuery();
							rset2.next();
							
							int quantity = rset2.getInt("quantity");
							
							if(quant > quantity) {
								System.out.println("Sorry there are only "+quantity+" available!");
								System.out.println("\n************ Search Options ************");
								
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add to Cart");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
							
							}
							
							else {
								String sql = "insert into cart values(?,?,?,?,curdate())";
								PreparedStatement pst3 = c.c.prepareStatement(sql);
								
								pst3.setString(1, user);
								pst3.setString(2, isbn);
								pst3.setInt(3, quant);
								pst3.setInt(4, custom_id);
								pst3.execute();
								
								pst3 = c.c.prepareStatement("UPDATE books SET quantity = quantity-"+quant+" WHERE isbn ='"+isbn+"'");
								
								
								pst3.execute();
								System.out.println("\nBook added to cart successfully.\n");
								
								if(quantity - quant == 0) {
									PreparedStatement pst4 = c.c.prepareStatement("delete from books where isbn = '"+isbn+"'");
									pst4.executeUpdate();
									
								}
								
								add++;
								
								System.out.println("\n************ Search Options ************");
								System.out.println("|=========================================|");
								System.out.println("1. View all Books");
								System.out.println("2. View by book category");
								System.out.println("3. Search by Title ");
								System.out.println("4. Search by author");
								System.out.println("5. Add More items to Cart");
								System.out.println("6. Generate Bill for Payment");
								System.out.println("7. LogOut");
								System.out.println("|=========================================|\n");
								
							}
							break;
							
							
					case 6: 
							PreparedStatement pset3 = c.c.prepareStatement("select distinct b.title,b.author,b.price,c.quantity,b.price*c.quantity as total_amount, c.purchase_date from cart c,books b where c.customer_id=? and c.isbn=b.isbn " );
							pset3.setInt(1, custom_id);
							ResultSet rset3 = pset3.executeQuery();
							//System.out.println("\n Customer Bill: "+user);
							int tot = 0;
							System.out.println("\n|======================================================= Customer Bill ============================================================|");
							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
							System.out.println("Title                         Author                    Price                  Quantity                    Total Amount");
							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
							
							
							while(rset3.next()) {
								String b_t = rset3.getString("b.title");
								String b_a = rset3.getString("b.author");
								int b_p = rset3.getInt("b.price");
								int c_quant = rset3.getInt("c.quantity");
								String total = rset3.getString("total_amount");
								
								tot = tot + b_p * c_quant;
								
								System.out.println(b_t + "                 "+ b_a + "                 "+ b_p+ "                     "+ c_quant+"                           "+total);
							}
							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
							System.out.print("\n                                                                                        Total Amount to be paid = "+tot);
							rset3.close();
							System.out.println("\n\n|==================================================================================================================================|\n");
			
							
							System.out.println("\n\n\n|========================================= Payment Option ===============================================|");
							System.out.print("Do you want to do the payment for the generated bill (Y/N) =  ");
							String ans = in.nextLine();
							if(ans.equalsIgnoreCase("y")) {
								
								System.out.println("\n|---------------------------------------------|");
								System.out.println("1. Online");
								System.out.println("2. Cash-On-Delivery");
								System.out.println("|---------------------------------------------|\n");
								
								System.out.print("Enter your choice: ");
								int opt = in.nextInt();
								in.nextLine();
								String sql;
								
								if(opt == 1) {
									sql = "insert into transaction(username,payment_method,total,transaction_date,transaction_time) VALUES('"+user+"','Online',"+tot+",curdate(),now())";
								}
								else {
									sql = "insert into transaction(username,payment_method,total,transaction_date,transaction_time) VALUES('"+user+"','COD',"+tot+",curdate(),now())";
								}
								
								PreparedStatement pst4 = c.c.prepareStatement(sql);
								pst4.execute();
								
								System.out.println("\nYour Book Purchase is Successful...");
								System.out.println("\n|---------------------------------|");
								System.out.println("1. Search for books again to purchase");
								System.out.println("2. LogOut");
								System.out.println("|---------------------------------|\n");
								System.out.print("Enter your choice: ");
								int ch2 = in.nextInt();
								in.nextLine();
								switch(ch2) {
									case 1: books_stock bs = new books_stock();
											bs.stock(user);
											break;
											
									case 2:  System.out.println("\nLogout Successful..\n\n");
											Main.logout();
								}
							}
							
							else {
								System.out.println("\n\n|---------------------------------|");
								System.out.println("1. Search for books again to purchase");
								System.out.println("2. LogOut");
								System.out.println("|---------------------------------|\n");
								
								System.out.print("Enter your choice: ");
								int ch3 = in.nextInt();
								in.nextLine();
								switch(ch3) {
									case 1: books_stock bs = new books_stock();
											bs.stock(user);
											break;
											
									case 2:  System.out.println("\nLogout Successful..\n\n");
											Main.logout();
								}
							}
							break;
					case 7: System.out.println("\nLogout Successful..\n\n");
							Main.logout();
							break;
							
					default: System.out.println("Please ! Enter a valid choice.\n");
					
				}
			}
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
