package com.practice.spring.basics.springbasics.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImprovedAgainSetterInjection {

	@Autowired
	@Qualifier("quick")
	SortAlgo sortAlgo; // instead of sortAlgo we can use the implmentation class name "bubbleSortAlgo" ahere so as to specify which 
						// implemntation to inject between quick sort and bubble sort doing this we can avoid using
							// @Primary

	/*
	 * public void setSortAlgo(SortAlgo sortAlgo) { // setter injection  // not even required to create it will take it automatically
	 * this.sortAlgo = sortAlgo; }
	 */
	
	public int binarySearch(int[] numbers,int numberToSearch) {
		int[] sortedNumbers = sortAlgo.sort(numbers);
		System.out.println(sortAlgo);
		return 3;
	}
	
}
