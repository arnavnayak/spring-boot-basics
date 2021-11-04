package com.practice.spring.basics.springbasics.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImprovedAgain {

	@Autowired
	@Qualifier("bubble")
	private SortAlgo sortAlgo;// instead of sortAlgo we can use the quickSortAlgo implmentation class name ahere so as to specify which 
								// implemntation to inject between quick sort and bubble sort doing this we can avoid using
								// @Primary

	
	/*
	 * public BinarySearchImprovedAgain(SortAlgo sortAlgo) { // constructor // by
	 * default if we remove it will take as setter injection injection super();
	 * this.sortAlgo = sortAlgo; }
	 */
	 

	public int binarySearch(int[] numbers, int numberToSearchFor) {

		int[] sortedNumbers = sortAlgo.sort(numbers);
		System.out.println(sortAlgo);
		return 3;

	}
}
