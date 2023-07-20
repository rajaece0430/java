package com.raj.core;


public class StringNewApiRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("".isBlank());// added in java 11
		System.out.println(" L R ".strip().replace(" ", "@"));
		System.out.println(" L R ".stripLeading().replace(" ", "@"));
		System.out.println(" L R ".stripTrailing().replace(" ", "@"));
		
		"Line1\nLine2\nLine3".lines().forEach(System.out::println);
		
		System.out.println("UPPER".transform(s -> s.substring(2)));
		
		System.out.println("My name is %s, My age is %d".formatted("Raj", 30));
		
		//Helpfull nullPointer message is added java 14
		
		String str = null;
		System.out.println(str.isBlank());
			
		//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.isBlank()" because "str" is null
		//at com.raj.core.StringNewApiRunner.main(StringNewApiRunner.java:21)

	}

}
