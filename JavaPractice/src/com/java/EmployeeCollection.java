package com.java;

import java.util.*;

import java.util.stream.Collectors;



public class EmployeeCollection {

	public static void main(String[] args) {

       List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8);
		
		List<String> list = new ArrayList<>();
		list.add("anil");
		list.add("mohan");
		list.add("babu");
		list.add("rakesh");
		list.add("rajesh");
		list.add("cut");
		list.add("zell");
		list.add("kil");
		
		System.out.println("iterating a list");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("sorting a list using stream");
		list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("change list string to uppercase");
		list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("count list string");
		long count = list.stream().filter(x -> x.length()>3).count();
		System.out.println(count);
		
		System.out.println("distinc square of number");
		number.stream().map(x -> x*x).collect(Collectors.toList()).forEach(System.out::println);
		
		list.stream().filter(x->x.length()>3).forEach(System.out::println);
		
	}

}
