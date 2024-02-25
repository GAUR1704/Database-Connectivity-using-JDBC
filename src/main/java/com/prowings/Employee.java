package com.prowings;

public class Employee {
	
	private int id;
	private String name;
	private String role;
	private int salary;
	private String country;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String role, int salary, String country) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.salary = salary;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + ", country=" + country
				+ "]";
	}
	
	

}
