package com.prowings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
	static Connection con = null;

//	------------------------------Insert Employee data ------------------------------------------------

	public int createEmployee(Employee s) {

		int res = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			Statement stm = con.createStatement();

			int id = s.getId();
			String name = s.getName();
			String role = s.getRole();
			int salary = s.getSalary();
			String country = s.getCountry();

			String insertQuery = "insert into emp values(" + id + "," + "'" + name + "'" + "," + "'" + role + "'" + ","
					+ salary + "," + "'" + country + "'" + ")";

			res = stm.executeUpdate(insertQuery);

			if (res > 0) {
				System.out.println("Employee record inserted successfully.. afftected rows are : " + res);

			} else
				System.out.println("Record not inserted!!");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

				System.out.println("Connection closed successfully!!!");

			} catch (SQLException e) {

				System.out.println("Error while closing the connection!!");

				e.printStackTrace();
			}
		}
		return res;
	}

//--------------------------Get employee from id --------------------------------------

	public Employee getEmployee(int id) {

		Employee s = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("select * from emp ");

			while (rs.next()) {

				if (rs.getInt(1) == id)
					;

				s = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				con.close();

				System.out.println("Connection closed successfully!!!");

			} catch (SQLException e) {

				System.out.println("Error while closing the connection!!");

				e.printStackTrace();
			}
		}

		return s;

	}

//	---------------------------Get All employee from Table -------------------------------------------------

	public List<Employee> getAllEmployees() {

		List<Employee> students = new ArrayList<>();

		Employee s = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("select * from emp ");

			while (rs.next()) {

				s = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

				students.add(s);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				con.close();

				System.out.println("Connection closed successfully!!!");

			} catch (SQLException e) {

				System.out.println("Error while closing the connection!!");

				e.printStackTrace();
			}
		}

		return students;

	}

//	------------------------------ Delete employee from table -------------------------------------------

	public boolean deleteEmployee(int id) {

		Statement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			stmt = con.createStatement();

			int rowsAffected = stmt.executeUpdate("DELETE FROM emp WHERE id = " + id);

			if (rowsAffected > 0) {

				System.out.println("Student with ID " + id + " deleted successfully.");
				return true;

			} else {
				System.out.println("No student found with ID " + id + ". Nothing was deleted.");
				return false;
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				con.close();

				System.out.println("Connection closed successfully!!!");

			} catch (SQLException e) {

				System.out.println("Error while closing the connection!!");

				e.printStackTrace();
			}
		}
		return false;

	}

//	-------------------------------Update employee from table -------------------------------------------

	public boolean updateEmployee(Employee updatedEmployee) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Gaurav@2001");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM emp WHERE id = " + updatedEmployee.getId());

			if (rs.next()) {
				
				System.out.println("Employee with ID " + updatedEmployee.getId() + " updated successfully.");

				return true;
			} else {

				System.out.println("Failed to update employee with ID " + updatedEmployee.getId());
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

		return false;
	}

}
