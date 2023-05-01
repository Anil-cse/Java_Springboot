package com.java;

import java.util.*;


public class CollectionSearchNum {

	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(8);
		list.add(12);
		list.add(5);
		
		list.set(3, 24);
		//sort using stream
		System.out.println("sort using stream");
		list.stream().sorted().forEach(System.out::println);
		
		
		
		//retainAll using matching both list print common
		
//		List<Integer> list2 = new ArrayList<>();
//		list2.add(45);
//		list2.add(15);
//		list2.add(8);
//		
//		boolean retainAll = list.retainAll(list2);
//		
//		System.out.println(list+" "+retainAll);
		
		
		
		System.out.println("reverse order");
		ListIterator<Integer> itr = list.listIterator(list.size());
		while(itr.hasPrevious())
		{
			System.out.println(itr.previous());
		}
		
		System.out.println("iterate using foreach");
		list.forEach(a->{
		System.out.println(a);
		});
		
		System.out.println("sorting number");
		
		Collections.sort(list);//sorting
		
		for(Integer num:list)
		{
			System.out.println(num);
		}
 
//		System.out.println("remove one number");
//		list.remove(1);
//		for(Integer num:list)
//		{
//			System.out.println(num);
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number to search");
		int x = sc.nextInt();
		
		
//		for(int i=0;i<list.size();i++)
//		{
//			if(list.get(i)==5)
//			{
//				System.out.println("number found");
//			}
//		}
		
//		if(list.contains(12))
//		{
//			System.out.println("number found");
//		}
		
		
		Iterator<Integer> itr1 = list.iterator();
		while(itr1.hasNext())
		{
			if(itr1.next()==x)
			{
				System.out.println(" number found");
			}
			
			//System.out.println(itr.next());
		}
		
		
		for(Integer a:list)
		{
			if(a==x)
			{
				System.out.println("number found");	
			}
		}
	}
	
}
