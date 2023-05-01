package com.java.exception;

import java.util.*;

public class DivideException {

	
	static void validate(int age) throws InvalidException
	{
		if(age<18)
		{
			throw new InvalidException("age is not valid to vote");
		}
		else
		{
			System.out.println("applicable to vote");
		}
	}
	
	
	public static void main(String[] args) throws InvalidException {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("using try catch exception");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		try
		{
			int c = a/b;
			System.out.println(c);
		}
//		finally {
//			System.out.println("coding..");
//		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("using custome exception");
		if(b!=0 && b>0)
		{
			int c = a/b;
			System.out.println(c);
		}
		else
		{
			throw new InvalidException("denominator not be zero");
		}

		System.out.println("using custome exception which one give vote");
		
		int age = sc.nextInt();
		
		try
		{
			validate(age);
		}
		catch(Exception e)
		{
			System.out.println("exception caught");
			System.out.println("exception occured :"+e);
		}
		
		System.out.println("rest of the code");
	}

}
