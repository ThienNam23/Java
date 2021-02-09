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
	static PreparedStatement pstmt = null; // SQL prepare statement object
	
	public static void getDataFromDB() {
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT id, name, city, salary FROM myTable"; // SQL statement
			
			// Get data and extract
			ResultSet rs = stmt.executeQuery(sql);
			conn.commit();
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
			
			String sql = "UPDATE myTable SET name = ?, city = ?, salary = ? WHERE id = ?"; // SQL statement
			// Prepare Statement object
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Thien Nam");
			pstmt.setString(2, "Ha Nam");
			pstmt.setInt(3, 23);
			pstmt.setInt(4, 30);
			int rows = pstmt.executeUpdate();
			conn.commit();
			System.out.println("here");
			System.out.println("Statement executed");
			System.out.println(rows + " row(s) affected!");
			
			// Get data and extract
			stmt = conn.createStatement();
			sql = "SELECT id, name, city, salary FROM myTable";
			
			ResultSet rs = stmt.executeQuery(sql);
			conn.commit();
			System.out.println("SELECT Statement executed!");
			
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
				  "SET name = ?, city = ?, salary = ? " +
			      "WHERE id = ?"; // SQL statement
			// Prepare Statement object
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "-------");
			pstmt.setString(2, "-------");
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 30);
			rows = pstmt.executeUpdate();
			conn.commit();
			
			// Clean-up environment
			//rs.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
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
						 ") AUTO_INCREMENT = 1"; // SQL statement
			
			stmt.execute(sql);
			System.out.println("Table created!");
			
			// Insert data to new table: temp_table
			sql = "INSERT INTO temp_table (name, age, gender) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			Object dataSet[][] = new Object[][]{
				{"Raven", "Ulysses", "Grady", "Avye", "Julian", "Mia", "Vera", "Rebecca", "Maile", "Grady"},
				{40, 43, 21, 24, 20, 19, 21, 45, 30, 35},
				{0, 1, 1, 1, 0, 1, 0, 1, 1, 1}
			};
			
			for (int i = 1; i < 11; i++) {
				pstmt.setString(1, (String)dataSet[0][i - 1]);
				pstmt.setInt(2, (int)dataSet[1][i - 1]);
				pstmt.setInt(3, (int)dataSet[2][i - 1]);
				pstmt.addBatch();
			}
			int count[] = pstmt.executeBatch();
			conn.commit();
			
			// Get data and extract
			sql = "SELECT id, name, age, gender FROM temp_table";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("SELECT Statement executed!");
			
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
			pstmt.close();
			stmt.close();
			conn.setAutoCommit(true);
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
			conn.setAutoCommit(false);
			// STEP 3: Execute a query
			//getDataFromDB();
			updateData();
			//createTable();
			
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
				if (pstmt != null) {
					pstmt.close();
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