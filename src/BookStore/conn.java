package BookStore;
import java.sql.*;


public class conn {
	
	//Class.forName("com.mysql.jdbc.Driver");
		public java.sql.Connection c;
		
		public void connection() {
		try {
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","Snowden7998");
		
		 //System.out.println("Successful..");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
	
