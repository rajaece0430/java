package com.raj.core;

public class TestBlockRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = """
				Line 1
				   "Double Quota"
				   Line 2
				Line 3""";
		System.out.print(str);
		
		String textBlock = """
				Line 1:%s
				Line 2
				Line 3
				""".formatted("SomeText");
		System.out.print(textBlock);
	}

}
