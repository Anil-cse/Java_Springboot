package com.java;

import java.util.*;


public class CollectionMap {

	public static void main(String[] args)
	{
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "anil");
		map.put(5, "raj");
		map.put(null, null);
		map.put(8, "null");
		map.put(4, "xyz");
		map.put(3,null);
		map.remove(3);
		
		System.out.println("for iteration using keyset");
		for(Integer key : map.keySet())
		{
			System.out.println(key+" "+map.get(key));
		}
		
		System.out.println("for iteration using entryset");
		for(Map.Entry<Integer, String> entry : map.entrySet())
		{
		System.out.println(entry.getKey()+" "+entry.getValue());	
//			if(entry.getKey()==5)
//			{
//				System.out.println(entry.getValue());
//			}
		}
		System.out.println("for iteration using value");
		for(String value : map.values())
		{
			System.out.println(value);
		}
		System.out.println("iteration with entryset");
		Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, String> entry =itr.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		System.out.println("using foreach and lambda expr");
		map.forEach((k,v)->System.out.println(k+" : "+v));
		
		System.out.println("using foreach, keyset and lambda expr");
		map.keySet().forEach(k -> System.out.println(k+" : "+map.get(k)));
		
		System.out.println("using foreach,entryset and lambda expr");
		map.entrySet().forEach(e -> System.out.println(e.getKey()+" : "+e.getValue()));
		
		System.out.println("using foreach,stream,entryset and lambda expr");
		map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" ; "+e.getValue()));
	}
}
