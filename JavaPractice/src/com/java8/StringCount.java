package com.java8;

import java.util.*;

interface abc
{
	void Scount(String str);
}


public class StringCount {

	public static void main(String[] args) {

		//3 time a four time d 2 times c one time b
		
		abc x = (str -> {
			
			char[] a = str.toCharArray();
			int l = a.length;
			int i,j;
			for(i=0;i<l;i++)
			{
				int count =1;
				for(j=0;j<l;j++)
				{
					if(a[i]==a[j] && i!=j)
					{
						a[j]=1;
						count++;
					}
				}
				
				if(a[i]!=1)
				System.out.println(a[i]+""+count);
			}
			
			
		});
		
		x.Scount("aaddaddcbc");

		System.out.println("first method java 8 feature");
		String str = "aaddaddcbc";
	    Map<Character, Integer> charCount = new HashMap<>();
	    for (char c : str.toCharArray()) {
	        charCount.merge(c,			 // key = char
	        		1,					// value to merge
	        		Integer::sum);     // counting                  
	    }
	    System.out.println("Char Counts:\n" + charCount);
		
	    System.out.println("second method java 8 feature");
	    String word = "aaddaddcbc";
	    Map<String, Integer> charCount1 = new HashMap();
	    for(String charr: word.split("")){
	        Integer added = charCount1.putIfAbsent(charr, 1);
	        if(added != null)
	            charCount1.computeIfPresent(charr,(k,v) -> v+1);
	    }

	    System.out.println(charCount);
	    
	}

}
