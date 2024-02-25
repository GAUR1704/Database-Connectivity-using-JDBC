package com.prowings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection5 {

	public static void main(String[] args) {

		Connection con = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");
			
			Statement stmt = con.createStatement();
			
			long res = stmt.executeUpdate("delete from emp where id = 80");
			
			if(res > 0)
				
				System.out.println("DB Operation executed successfully.. afftected rows are : "+res);
			

		} catch (ClassNotFoundException e) {

			System.out.println("Unable to load the Driver because driver class not found!!");

			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println("Some exception occurred while connecting to the database!!");

			e.printStackTrace();
		}
		
		finally {
			
			try {
				
				con.close();
				
				System.out.println("COnnection closed successfully!!!");
				
			} catch (SQLException e) {
				
				System.out.println("Error while closing the connection!!!");
				
				e.printStackTrace();
			}
		}

	}
}
