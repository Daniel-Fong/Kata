package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MaxKSumPairs.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Number of K-Sum Pairs
 * 
 * You are given an integer array nums and an integer k.
 * 
 * In one operation, you can pick two numbers from the array whose sum equals k 
 * and remove them from the array.
 * 
 * Return the maximum number of operations you can perform on the array.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
public class MaxKSumPairs {
	private int count = 0;
	/**
	 * In one operation, you can pick two numbers from the array whose sum equals k 
 	 * and remove them from the array.
	 * @param source Source array of numbers
	 * @param target Target number to calculate against
	 * @return Number of operations
	 */
	public int calculate(int[] source, int target) {
		// Validate the data
		if (source == null || source.length == 0 || target == 0) return 0;
		List<Integer> list = new ArrayList<>();
		for (int num : source) list.add(num);
		Collections.sort(list);
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > target) continue;
			else if (list.get(i) == target) {
				++count;
				list.remove(i);
			}
		}
		return count;
	}
}
