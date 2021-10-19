package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MaximumXOR.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Maximum XOR Kata
 * 
 * Given an array of integers, find the maximum XOR of any two elements.
 * 
 * Example:
 * Input: 1,2,3,4,5
 * Ouput: 7
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 14, 2021
 * @updates:
 ****************************************************************************/
public class MaximumXOR {

	/**
	 * Calculates the XOR against all of any 2 elements in the array
	 * @param numbers Numbers to calculate.
	 * @return Largest XOR value.  0 if invalid data (empty array, null, 
	 * array < 2 elements ...)
	 */
	public int calculate(int[] numbers) {
		if (numbers == null || numbers.length <= 1) return 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length -1; i++) {
			for (int j=i+1; j < numbers.length; j++) {
				list.add(numbers[i]^numbers[j]);
			}
		}
		Collections.sort(list);
		Collections.reverse(list);
		return list.get(0);
	}
}
