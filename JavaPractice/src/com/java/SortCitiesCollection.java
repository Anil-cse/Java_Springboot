package com.java;

import java.util.*;
import java.util.stream.Collectors;


public class SortCitiesCollection {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Employee emp1 = new Employee(2, "ajay", "varanasi", 25, 50000.0,"male");
		Employee emp2 = new Employee(6, "ram", "mysore", 32, 25000.0,"female");
		Employee emp3 = new Employee(1, "raj", "jaunpur", 23, 45000.0,"male");
		Employee emp4 = new Employee(9, "karan", "patna", 40, 28000.0,"male");
		Employee emp5 = new Employee(7, "dev", "delhi", 18, 15000.0,"female");

		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		list.remove(emp5);
		
		System.out.println("lambda with foreach");
		list.forEach(n -> System.out.println(n));
		
//		list.stream().sorted(Comparator.comparing(Employee::getAddress)).forEach(System.out::println);
//		
//		list.stream().sorted((p1,p2) -> p1.getId()- (p2.getId())).forEach(System.out::println);
//		
//		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);

		System.out.println("sort name by comparable and sort method");
		Collections.sort(list);
		list.forEach(a -> {
		System.out.println(a);});
		
		
		long count = list.stream().filter(x -> x.getGender().equals("male")).count();
		System.out.println("count of female employee : "+count);
		
		System.out.println("detail of employee whose address is varanasi");
		list.stream().filter(x -> x.getAddress().equals("varanasi")).collect(Collectors.toList()).forEach(System.out::println);
		
		
		System.out.println("get detail by city ");
		String str = sc.next();
		
		for(Employee list1:list)
		{
			if(list1.getAddress().contains(str))
			{
				System.out.println(list1.getName());
			}
			
		}
		
		
}
}