package com.prowings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {

	public static void main(String[] args) {

//		Code to fetch the data from emp table from employee database

		Connection con = null;

		try {
			// Step 1 : Register the driver class (Optional)

			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Database register sucessfully");

			// Step 2 : Create connection

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			System.out.println("Connection created sucessfully !!!");

			// Step 3 : Create statement

			Statement stm = con.createStatement();

			System.out.println("Statment created succesfully !!! ");

			// Step 4 : Execute query

			ResultSet rs = stm.executeQuery("select * from emp ");

			while (rs.next()) {

				System.out.println("ID : " + rs.getInt(1));
				System.out.println("Name : " + rs.getString(2));
				System.out.println("ROle : " + rs.getString(3));
				System.out.println("Salary : " + rs.getInt(4));
				System.out.println("Country : " + rs.getString(5));
			}

		} catch (ClassNotFoundException e) {
			
			System.out.println("Unable to load the Driver because driver class not found!!");

			e.printStackTrace();

		} catch (SQLException e) {
			
			System.out.println("Some exception occurred while connecting to the database!!");

			e.printStackTrace();
		}
		
		finally {
			
			try {
				System.out.println("Connection closed successfully!!!");
				
				con.close();
				
			} catch (SQLException e) {
				
				System.out.println("Error while closing the connection!!");	
				
				e.printStackTrace();
			}
		}

	}
}
