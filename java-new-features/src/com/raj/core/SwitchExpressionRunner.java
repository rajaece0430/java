package com.raj.core;

public class SwitchExpressionRunner {
	
	public static String findDayOfTheWeek(int day) {
		String dayOfWeek = "";
		switch(day) {
		case 0: dayOfWeek = "Sunday"; break;
		case 1: dayOfWeek = "Monday"; break;
		case 2: dayOfWeek = "Tuesday"; break;
		case 3: dayOfWeek = "Wednesday"; break;
		default: throw new IllegalArgumentException("Invalid day "+day);
		
		}
		
		return dayOfWeek;
	}
	
	public static String findDayOfTheWeekSwitchExpression(int day) {
		String dayOfWeek = switch(day) {
		case 0 -> {
			System.out.println("Do some stuff");
			yield "Sunday";
			}
		case 1 -> "Monday";
		case 2 ->"Tuesday";
		case 3 -> "Wednesday";
		default -> throw new IllegalArgumentException("Invalid day "+day);
		
		};
		//this case there is no fallthrough
		
		return dayOfWeek;
	}
	
	public static void main(String[] args) {
		
	}
}
