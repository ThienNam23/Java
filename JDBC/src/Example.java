//STEP 1: import required packages
import java.sql.*;

public class Example {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tn_test";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered");
			
			//Step 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, city, salary FROM myTable";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("Statement execute successfully!");
			
			//STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				int salary = rs.getInt("salary");
				
				//Display values
				System.out.println("--------------------------");
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("City: " + city);
				System.out.println("Salary: " +salary);
			}
			
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}
		
		// Catch all exceptions
		catch (ClassNotFoundException e) {
			System.out.println("Class not found!");
			e.getStackTrace();
		}
		catch (Exception e) {
			System.out.println("Class not found!");
			e.printStackTrace();
		}
		System.out.println("\nGoodbye!");
	}
}