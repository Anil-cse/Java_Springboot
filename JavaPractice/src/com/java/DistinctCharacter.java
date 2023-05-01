package com.java;

public class DistinctCharacter {

	public static void main(String[] args)
	{
	
		String str = "mynameisanil";
		char[] c = str.toCharArray();
		int l = c.length;
		int i,j;
		int count;
		for(i=0;i<l;i++)
		{
			int m=0;
			count=1;
			for(j=1;j<l-1;j++)
			{
				if(c[i]==c[j] && i!=j)
				{
					count++;
					c[j]=1;
					m=j;
				}
				
			}
			if(c[i]!=1)
			{
				System.out.println(c[i]+" at index "+i+":"+count+" "+m);
			}
			
			
		}
		
		
	}
	
}
