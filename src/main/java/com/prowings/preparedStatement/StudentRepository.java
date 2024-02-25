package com.prowings.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepository {

//	------------------------Insert student data -----------------------------

	public int createStudent(Student s) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			String insertQuery = "insert into student (id, name, address) values (?,?,?)";

			pstmt = con.prepareStatement(insertQuery);

			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getAddress());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return result;

	}

//	------------------------Get student from id ---------------------------------------
	
	public Student getStudent(int id) {
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		Student student = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");
			
			 String query = "SELECT * FROM emp WHERE id = ?";
			 
			 pstmt = con.prepareStatement(query);
			 
			 pstmt.setInt(2, id);
			 
			 ResultSet rs = pstmt.executeQuery();
			 
			 if (rs.next()) {
	                 student = new Student();
	                student.setId(rs.getInt("id"));
	                student.setName(rs.getString("name"));
	                student.setAddress(rs.getString("address"));
			 } 
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			
			try {
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		return student;
		
	}

}
