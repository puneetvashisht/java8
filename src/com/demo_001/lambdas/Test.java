package com.demo_001.lambdas;

public class Test {
	public void greet(Greeting g){//SAM interface
		g.greet();
	}
	public static void main(String[] args) {
		// 1
		Greeting greet_1 = new Impl();
		greet_1.greet();
		
		
		//2
		Greeting greet_2 = new Greeting() {
			@Override
			public void greet() {
				System.out.println("Hello User");
			}
		};
		greet_2.greet();
		
		
		Test test = new Test();
		//3
		test.greet(new Impl());// passing that contains behaviour
		
//		()->{System.out.println("Hello user");}
		// passing behaviour only
		test.greet(()->System.out.println("Hello user"));
	}
}
