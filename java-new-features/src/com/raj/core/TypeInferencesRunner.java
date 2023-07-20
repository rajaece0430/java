package com.raj.core;

import java.util.List;
import java.util.stream.Stream;

public class TypeInferencesRunner {
	
	public static void main(String[] args) {
		List<String> names1 = List.of("Raj","Rajesh");
		
		List<String> names2 = List.of("Naresh","Sai");
		
		//List<List<String>> names = List.of(names1,names2);
		var names = List.of(names1,names2);
		//java complier infers the type of variable at compile time
		//added in java 10
		
		names.stream().forEach(System.out::println);
		
		System.out.println("========================");
		for(var i=0;i<names1.size();i++) {
			System.out.println(names1.get(i));
		}
		System.out.println("========================");
		for(String name : names2) {
			System.out.println(name);
		}
		System.out.println("========================");
		for(var name : names2) {
			System.out.println(name);
		}
		System.out.println("========================");
		final var namesFinal = List.of(names1,names2);
		var var = ""; // can not assign numm to var
		
		//List.of("Naresh","Sai").stream().filter(s -> s.length()<5).forEach(System.out::println);
		
		var filter = List.of("Naresh","Sai").stream().filter(s -> s.length()<5);
		filter.forEach(System.out::println);
	}
}
