package com.practice.spring.basics.springbasics.basic;

import org.springframework.stereotype.Component;


public class BinarySearchImproved {

	private SortAlgo sortAlgo;
	
	public BinarySearchImproved(SortAlgo sortAlgo) {
		super();
		this.sortAlgo = sortAlgo;
	}

	public int binarySearch(int[] numbers,int numberToSearchFor) {

		int[] sortedNumbers = sortAlgo.sort(numbers);
		System.out.println(sortAlgo);
		return 3;
	
	}

}
