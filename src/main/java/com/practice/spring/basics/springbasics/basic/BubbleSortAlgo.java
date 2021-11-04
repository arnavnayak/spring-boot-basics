package com.practice.spring.basics.springbasics.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSortAlgo implements SortAlgo{

	public int[] sort(int[] numbersToBeSorted) {
		
		//some logic to sort
		int[] sortedNumbeer = new int[] {1,2,3};
		return sortedNumbeer ;
	}
}
