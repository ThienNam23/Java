package com.thiennam23.RESTdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	// JDBC driver name and DB URL
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/jpa_employee";

	// DB user's login information
	final String USER = "root";
	final String PASS = "";

	Connection conn = null; // Connection object
	Statement stmt = null; // SQL statement object
	PreparedStatement pstmt = null; // SQL prepare statement object
	
	public EmployeeDao() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Constructor: " + e);
		}
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * from EMPLOYEE";
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			conn.commit();
			
			while (rs.next()) {
				// Retrieve data
				Employee e = new Employee();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setDeg(rs.getString("deg"));
				e.setSalary(rs.getInt("salary"));
				
				employees.add(e);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return employees;
	}

	public Employee getEmployee(int eid) {
		
		String sql = "SELECT * from EMPLOYEE WHERE eid=" + eid;
		Employee employee = new Employee();
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			conn.commit();
			
			while (rs.next()) {
				// Retrieve data
				employee.setEid(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setDeg(rs.getString("deg"));
				employee.setSalary(rs.getInt("salary"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getEmployee: " + e);
		}
		System.out.println(employee);
		return employee;
	}

	public void create(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE(EID, ENAME, DEG, SALARY) VALUES (?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employee.getEid());
			pstmt.setString(2, employee.getEname());
			pstmt.setString(3, employee.getDeg());
			pstmt.setInt(4, employee.getSalary());
			
			int rows = pstmt.executeUpdate();
			conn.commit();
			System.out.println(rows + "(s) affected");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Create error: " + e);
		}
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		String sql = "UPDATE EMPLOYEE SET ENAME=?, DEG=?, SALARY=? WHERE EID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getEname());
			pstmt.setString(2, employee.getDeg());
			pstmt.setInt(3, employee.getSalary());
			pstmt.setInt(4, employee.getEid());
			
			int rows = pstmt.executeUpdate();
			conn.commit();
			System.out.println(rows + "(s) affected");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Update error: " + e);
		}
		
	}

	public void delete(int eid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM EMPLOYEE WHERE EID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			
			int rows = pstmt.executeUpdate();
			conn.commit();
			System.out.println(rows + "(s) affected");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Delete error: " + e);
		}
	}
}
