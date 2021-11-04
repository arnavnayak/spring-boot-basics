package com.practice.spring.basics.springbasics.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary // if removed will throw an error as same interface is implementing both bubble and quick sort.
@Component
@Qualifier("quick")
public class QuickSortAlgo implements SortAlgo{

	public int[] sort(int[] numbersToBeSorted) {
		
		//some logic to sort
		int[] sortedNumbeer = new int[] {1,2,3};
		return sortedNumbeer ;
	}
}
