package com.java8;

import java.util.function.Supplier;

public class PredefinedFunctionalInterfaces {

	public static void main(String[] args) {

		Supplier<Double> obj = new Supplier<Double>() 
		{

			@Override
			public Double get() {
				
				return Math.random();
			}
			
		};
		System.out.println(obj.get());

	}

}
