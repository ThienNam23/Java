import java.sql.*;

public class JDBCPrograming {
	// JDBC driver name and DB URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tn_test";
	
	// DB user's login information
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn = null; // Connection object
	static Statement stmt = null; // SQL statement object
	
	public static void getDataFromDB() {
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT id, name, city, salary FROM myTable"; // SQL statement
			
			// Get data and extract
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Statement executed!");
			
			System.out.println("\nTabel: myTable - before updated");
			System.out.println(String.format("%3s %20s %20s %8s", "ID", "NAME", "CITY", "SALARY"));
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				int salary = rs.getInt("salary");
				
				//Display values
				System.out.println(String.format("%3d %20s %20s %8d", id, name, city, salary));
			}
			
			// Clean-up environment
			rs.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Failed to get data from DB");
			System.out.println(e.getMessage());
		}
		
	}
	public static void updateData() {
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "UPDATE myTable " +
					     "SET name = 'Thien Nam', city = 'Ha Nam', salary = 0 " +
					     "WHERE id = 30"; // SQL statement
			
			int rows = stmt.executeUpdate(sql);
			System.out.println("Statement excecuted");
			
			System.out.println(rows + " row(s) affected!");
			
			// Get data and extract
			sql = "SELECT id, name, city, salary FROM myTable";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Statement executed!");
			
			System.out.println("\nTabel: myTable - after updated");
			System.out.println(String.format("%3s %20s %20s %8s", "ID", "NAME", "CITY", "SALARY"));
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				int salary = rs.getInt("salary");
				
				//Display values
				System.out.println(String.format("%3d %20s %20s %8d", id, name, city, salary));
			}
			
			// Recovery database
			sql = "UPDATE myTable " +
				     "SET name = '_______', city = '_______', salary = 0 " +
				     "WHERE id = 30"; // SQL statement
		
			stmt.executeUpdate(sql);
			// Clean-up environment
			rs.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Failed to get data from DB");
			System.out.println(e.getMessage());
		}
		
	}
	public static void createTable() {
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE temp_table ( " + 
						 "id int NOT NULL AUTO_INCREMENT, " + 
						 "name varchar(20), " + 
						 "age int, " + 
						 "gender tinyint DEFAULT 0, " + 
						 "PRIMARY KEY (id) " + 
						 ")"; // SQL statement
			
			stmt.execute(sql);
			
			// Insert data to new table: temp_table
			sql = "INSERT INTO temp_table (id, name, age, gender) " + 
					"VALUES (1,'Raven',41,0)," + 
					"		(2,'Ulysses',43,1)," + 
					"		(3,'Grady',21,1)," + 
					"		(4,'Avye',34,1)," + 
					"		(5,'Julian',20,0)," + 
					"		(6,'Mia',19,1)," + 
					"		(7,'Vera',21,0)," + 
					"		(8,'Rebecca',41,1)," + 
					"		(9,'Maile',41,1)," + 
					"		(10,'Grady',19,1)";
			int rows = stmt.executeUpdate(sql);
			System.out.println(rows + " row(s) affected!");
			
			// Get data and extract
			sql = "SELECT id, name, age, gender FROM temp_table";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Statement executed!");
			
			System.out.println("\nTable: temp_table");
			System.out.println(String.format("%3s %20s %3s %8s", "ID", "NAME", "AGE", "GENDER"));
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int gender = rs.getInt("gender");
				
				//Display values
				System.out.println(String.format("%3s %20s %3s %8d", id, name, age, gender));
			}
			
			// 
			sql = "DROP TABLE temp_table";
			stmt.executeUpdate(sql);
			// Clean-up environment
			rs.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Failed to get data from DB");
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			System.out.println("JDBC driver Registered!");
			
			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// STEP 3: Execute a query
			getDataFromDB();
			updateData();
			createTable();
			
			// Finally: Clean up environment
			conn.close();
		}
		// Handle Exception
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		finally {
			System.out.println("\nGoodbye!");
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e3) {
				// TODO: handle exception
			}
			
		}
	}
	
}