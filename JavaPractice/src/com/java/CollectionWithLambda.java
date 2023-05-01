package com.java;

import java.util.*;
import java.util.stream.Collectors;

class Student
{
	int id;
	String name;
	int age;
	
	public Student(int id, String name, int age)
	{
		super();
		this.id=id;
		this.name=name;
		this.age=age;
	}
}


public class CollectionWithLambda {

	public static void main(String[] args)
	{
		Student s1 = new Student(2,"rajesh",35);
		Student s2 = new Student(8,"rakesh",28);
		Student s3 = new Student(3,"misses",23);
		Student s4 = new Student(5,"deep",19);
		
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		System.out.println("Java Lambda Expression Example: Comparator");
		
		Collections.sort(list,(x,y)->{
			
		return x.name.compareTo(y.name);
		});
		
		for(Student st:list)
		{
			System.out.println(st.id+" "+st.name+" "+st.age);
		}
		
		System.out.println("Java Lambda Expression Example: filter collection data");
		
		list.stream().filter(x->x.age>25).forEach(n-> System.out.println(n.id+" "+n.name+" "+n.age));
		
		
		
	}
	
}
