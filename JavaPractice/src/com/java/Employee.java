package com.java;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String address;
	private int age;
	private double salary;
	private String gender;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, String address, int age, double salary, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	
@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", salary=" + salary
				+ ", gender=" + gender + "]";
	}

	//	public int compareTo(Employee e1)
//	{
//		if(age==e1.age)
//		{
//			return 0;
//		}
//		else if(age>e1.age)
//		{
//			return 1;
//		}
//		else
//		{
//			return -1;
//		}
//	}
//	
	@Override
    public int compareTo(Employee o) {
         return this.getName().compareTo(o.getName());
//		return o.getName().compareTo(this.getName());
    }
	
}
