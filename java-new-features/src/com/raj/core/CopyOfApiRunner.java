package com.raj.core;

import java.util.ArrayList;
import java.util.List;

public class CopyOfApiRunner {
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("Raj");
		names.add("Rajesh");
		names.add("Rakesh");
		
		List<String> copyOfNames = List.copyOf(names);
		//copyOf introduced in Java 10
		//immutable list then will use List.copyOf method.
		//This method copyOf method will present in Set and Map
		
		//List.of("Raj","Raja","Rakesh"); added List.of in Java 9, 
		//it will create unmodifiable List
		
		
		doNotChange(copyOfNames);
		
		System.out.println(copyOfNames);
	}

	private static void doNotChange(List<String> names) {
		names.add("New Name");
	}
}
