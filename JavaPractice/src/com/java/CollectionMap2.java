package com.java;

import java.util.*;
import java.util.Map.Entry;

public class CollectionMap2 {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(4, "kkr");
		map.put(1, "rcb");
		map.put(3, "lsg");
		map.put(13, "rr");
		map.put(2, "tcp");
		
		
		System.out.println("automatically sorting order");
		System.out.println("using keyset");
		for(Integer key : map.keySet())
		{
			System.out.println(key+" : "+map.get(key));
		}
		System.out.println("using entryset");
		for(Map.Entry<Integer, String> entry : map.entrySet())
		{
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println("using iterator and entryset");
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, String> entry = itr.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		System.out.println("using stream filter out");
		map.entrySet().stream().filter(x -> x.getKey()>5).forEach(e -> System.out.println(e.getKey()+" : "+e.getValue()));
		
		System.out.println("using forech");
		map.keySet().forEach(k->System.out.println(k+" : "+map.get(k)));
		

	}

}
