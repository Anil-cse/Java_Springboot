package com.java;

public class UniqueChar {

	public static void main(String[] args)
	{
		String str = "fddfcccrrrrdiic";
		char[] a = str.toCharArray();
		int i;
		int l = a.length;
		//int count = 0;
		for(i=0;i<l;i++)
		{
			int count=1;
			
			//int f=0;
			while (i + 1 < l && a[i] == a[i+1])
			{
					//f=1;
					i++;
					count++;
					
				
			}
			System.out.print(a[i]+ "" + count + " ");
			
			
//			if(a[i]!=1)
//			{
//				System.out.println(a[i]+" : "+count);
//			}
			
			
//			//if(f==0)
//			if(a[i]!=1)
//			{
//				count++;
//				System.out.println(a[i]);
//			}
		}
	//	System.out.println(count);
		
		
		
	}
	
}
