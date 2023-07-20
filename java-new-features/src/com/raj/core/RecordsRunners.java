package com.raj.core;

public class RecordsRunners {
	
	record Person(String name, String email, String phoneNumber) {
		//can create custom costructor if you want
		Person(String name, String email, String phoneNumber){
			if(name == null)
				throw new IllegalArgumentException("name is null");
			this.name=name;
			this.email=email;
			this.phoneNumber=phoneNumber;
		}
		
		//below one is compact constructor, allowed in Records only
		/*
		Person {
			if(name == null)
				throw new IllegalArgumentException("name is null");
			
		}
		*/
		//static variables are allowed, instance method are allowed
		//BUT you CANNOT add instance variables
		
		static int age;
		
		boolean validateAge(int age) {
			return false; //do some logic
		}
		
	}

	//to eliminte verbosity in creating java bean
	//public accessor methods, constructor, equals, 
	//hashcode and toString are automatically created.
	//can create custom implementations if you want
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person = new Person("Raj","abc@xyz.com","1234567897");
		Person person1 = new Person("Raja","abc1@xyz.com","2234567897");
		Person person2 = new Person("Raj","abc@xyz.com","1234567897");
		
		System.out.println(person.equals(person1));
		System.out.println(person.equals(person2));
		
		System.out.println(person.name());// public accessor method is provided by default
		
		
	}

}
