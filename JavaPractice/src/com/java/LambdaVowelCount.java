package com.java;

public class LambdaVowelCount {

	public static void main(String[] args)
	{
		String str = "mynameisanil";
		str.toLowerCase();
		int countVowel=0;
		int countConstraint = 0;
		int i;
		
		for(i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u')
			{
				countVowel++;
			}
			else
			{
				countConstraint++;
			}
		}
		System.out.println("vowel is:"+countVowel+" :constraint is :"+countConstraint);
	}
	
}
