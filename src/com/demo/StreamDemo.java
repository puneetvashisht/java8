package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		
		// Consider this a very very long list, with a lot of elements
	    List<Integer> list = Arrays.asList(1, 2, 3, 4);
// 1 + 4 + 9 + 16
	    int initialCount = 0;// starting from 0
	    // with reduce is used to have complex logic
	    int sumOfSquare1 = list.stream().reduce(initialCount, 
	    		(accumulator, element) -> {
//	    			System.out.println(accumulator+" : "+element);
	    			return accumulator + element*element;
	    		}).intValue();
//	    System.out.println(sumOfSquare1);
	    
	    // mapToInt will return Integer Stream
	    int sumOfSquare2 = list.stream()
	    		.mapToInt(element -> element*element)
	    		.sum();// add all the ints in the stream
//	    System.out.println(sumOfSquare2);
	    
	    // map returns Object Stream
	    list.stream()
	    	.map(element -> element*element)
	    	.forEach(e->System.out.println(e));
	    // can not have sum or add here without any logic
	    	    
//	    System.out.println(sumOfSquare1 + " " + sumOfSquare2);

		String[] names = {
				"Blue Whale", 
				"Elephant", 
				"Giraffe", 
				"Polar Bear", 
				"Crocodile", 
				"Green Anaconda", 
				"The Ostrich"
			};
		Stream<String> myStream = Arrays.stream(names);
		// can work on each element
		Stream<String> myNewStream = myStream.map(s -> s.toUpperCase());
		// use new String to initialize new String object
		String[] uppercaseNames =myNewStream.toArray(String[]::new);
		for(String name: uppercaseNames){
			System.out.println(name);
		}

//	    List<Integer> list = Arrays.asList(1, 2, 3, 4);
	    Stream<Integer> myListStream = list.stream();
	    Stream<Integer> myNewListStream = myListStream.map(num->num*num);
	    
	    // same example with new Integer :: contructor
	    Integer[] squareList = myNewListStream.toArray(Integer[]::new);
	    for(int square: squareList){
	    	System.out.println(square);
	    }    
		
	}
	
	
}
