package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: HarmoniousSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Harmonious Sequence Kata
 * 
 * We define a harmonious array as an array where the difference between its 
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious 
 * subsequence among all its possible subsequences.
 * 
 * A subsequence of array is a sequence that can be derived from the array by 
 * deleting some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 * 
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
public class HarmoniousSequence {

	/**
	 * Calculates the Longest Harmonious Sequence
	 * @param sequence Numbers to use to calculate
	 * @return total items in the harmonious sequence
	 */
	public int getLongest(int[] sequence) {
		int length = 0;
		if (sequence == null || sequence.length <= 1) return length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : sequence) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		for (int key : map.keySet()) {
			if (map.containsKey(key + 1)) {
				int sum = map.get(key) + map.get(key + 1);
				if (sum > length) {
					length = sum;
				}
			}
			if (map.containsKey(key - 1)) {
				int sum = map.get(key) + map.get(key - 1);
				if (sum > length) {
					length = sum;
				}
			}
		}
		return length;
	}
}