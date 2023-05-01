package com.java8;

@FunctionalInterface
//functional interface is take only one abstract method thats why it is also call SAM(single abstract method) and it take any number of default method and static method.
interface hello
{
	void say(String str1);
	default void speak(String str2)
	{
		System.out.println("anil");
	}
	default int sum(int a, int b)
	{
		return a+b;
	}
	
	static void multiply(int a, int b)
	{
		System.out.println("multiplication of System.otwo number is :");
		
	}	
}

//If not applyig implement interface on class then no need to apply public on method of interface(abstract method).
//If applying implement interface on class then need to apply public on method of interface(abstract method).
public class FunctionalInterfaceDemo implements hello{

	public void say(String smg)
	{
		System.out.println(smg);
	}
	
	public void speak(String str2)
	{
		System.out.println("anil gupta");
		System.out.println(str2);
	}
	
	 public int sum(int a, int b)
	{
		System.out.println("sum of two number is :");
		return a+b;
	}
	
	public static void multiply(int a, int b)
	{
		System.out.println("multiplication of System.otwo number is :");
		System.out.println(a*b);
	}
	
	public static void main(String[] args) {
		
		FunctionalInterfaceDemo obj = new FunctionalInterfaceDemo();
		obj.say("java programming");
		obj.speak("weolcome");
		
		int sum = obj.sum(25, 17);
		System.out.println(sum);

		FunctionalInterfaceDemo.multiply(7, 2);
	}

	

}
