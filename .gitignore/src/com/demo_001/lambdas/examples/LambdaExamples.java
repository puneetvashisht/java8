package com.demo_001.lambdas.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExamples {
	String[] names = { "Blue Whale", "Elephant", "Giraffe", "Polar Bear", "Crocodile", "Green Anaconda", "The Ostrich" };
	List<String> animals = new ArrayList<>(Arrays.asList(names));
	
	public static void main(String[] args) {
		LambdaExamples demos = new LambdaExamples();
		
//		demos.anonymousToLambda();
//		demos.listHasForEachToIterate();
//		demos.PredicateExample();
//		demos.predicatesInLambda();
	}


	// the whole anonymous class is replaced by () -> {} code block.
	private void anonymousToLambda() {
		// Before Java 8:
		/*
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();
		*/
		
		// Java 8 way:
		new Thread(
			() -> System.out.println("In Java8, Lambda expression rocks !!")
		).start();
	}
	
	private void listHasForEachToIterate() {
		/*
		for (String animal : animals) { 
			System.out.println(animal); 
		}
		*/
		
		// Java 8 way:
		animals.forEach(animal->System.out.println(animal));
	}
	
	private void PredicateExample() {
		System.out.println("Animals which starts with G:"); 

		/*
		myFilter(animals, str->{
			String animal = (String) str;
			return animal.startsWith("G");
		});
		*/
		myFilter(animals, str->((String) str).startsWith("G"));

		
		System.out.println("Print animals whose length greater than 4:"); 
		myFilter(animals, (str)->((String) str).length() > 4);
	}
	
	private void myFilter(List<? extends String> names, Predicate logic) { 
		for(String name: names) { 
			if(logic.test(name)) { 
				System.out.println(name + " "); 
				} 
			} 
		}
	
	private void predicatesInLambda() {
		 Predicate<String> startsWithG = (n) -> n.startsWith("G");
		 Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		 
		 animals.stream()
		      .filter(startsWithG.and(fourLetterLong))
		      .forEach((n) -> System.out.print("\nAnimals, which starts with 'G' and four letter long is : " + n));
	}

}