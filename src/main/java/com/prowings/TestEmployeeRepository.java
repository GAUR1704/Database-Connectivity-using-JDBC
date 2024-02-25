package com.prowings;

import java.util.List;

public class TestEmployeeRepository {

	public static void main(String[] args) {
		
		EmployeeRepository repo = new EmployeeRepository();
		
		System.out.println("<<<<<<<<<<<<<<<<<<<< Insert employee into table>>>>>>>>>>>>>>>>>>>>");

		Employee std = new Employee(140, "Peal", "Tester", 11000, "Nepal");


		if (repo.createEmployee(std) > 0) {

			System.out.println("Record inserted!!!");

		} else
			System.out.println("Record not inserted!!!");
		
		System.out.println();
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<Get employee from table by ID >>>>>>>>>>>>>>>>>>>>");

		Employee s1= repo.getEmployee(90);
		
		System.out.println(s1);
		
		System.out.println();
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<Get All employee from table >>>>>>>>>>>>>>>>>>>>>>");
		
        List<Employee> employee = repo.getAllEmployees();
        
        for (Employee student : employee) {
        	
            System.out.println(student);
            
            System.out.println();
            
        }
		
		System.out.println("<<<<<<<<<<<<<<<<<<<< Delete employee from table >>>>>>>>>>>>>>>>>>>>>>");
        
       int  studentIdToDelete = 120;
        boolean deletionResult = repo.deleteEmployee(studentIdToDelete);
        
        if(deletionResult) {
        	System.out.println("Student with ID " + studentIdToDelete + " was successfully deleted.");
        }
        else
        	System.out.println("Failed to delete student with ID " + studentIdToDelete);
        		
		System.out.println("<<<<<<<<<<<<<<<<<<<<Update employee from table >>>>>>>>>>>>>>>>>>>>>>");
		
		Employee updatedEmployee = new Employee(130, "John", "Tester", 50000, "India");
        
        boolean updateResult = repo.updateEmployee(updatedEmployee);

        if (updateResult) {
        	
            System.out.println("Student was successfully updated.");
        } else {
            System.out.println("Failed to update student.");
        }
   
        }
}
