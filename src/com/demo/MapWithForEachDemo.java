package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MapWithForEachDemo {
	public static void main(String[] args) {
		String[] names = {
				"Blue Whale", 
				"Elephant", 
				"Giraffe", 
				"Polar Bear", 
				"Crocodile", 
				"Green Anaconda", 
				"The Ostrich"
			};

		Map<Integer, String> animals = new HashMap();
		
		// fill map from array
		IntStream.range(0, names.length)
			.forEach(index -> animals.put(index, names[index]));
		
		// print every key and value
		animals.forEach((key, value)->{
			System.out.println("\nAnimals key "+key);
//			System.out.println("Animals value is "+animals.get(key));
			System.out.println("Animals value is "+value);
		});
	}
}
