package com.smt.kata.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: UniqueIntegers.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Least Number of Unique Integers after K Removals
 * 
 * Given an array of integers arr and an integer k. Find the least number of unique 
 * integers after removing exactly k elements.  Order the results such that when there
 * are duplicate number of values, the smallest values are given precedence
 * 
 * Example 1:
 * Input: arr = [5,5,4], k = 1
 * Output: 1
 * Explanation: Remove the single 4, only 5 is left.
 * 
 * Example 2:
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * Output: 2
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 
 * Example 3:
 * Input: arr = [1, 2, 3, 4, 5], k = 3
 * Output: 2
 * Explanation: Remove 4, 5 as we want the smallest integers kept in case of them
 * being the same
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2022
 * @updates:
 ****************************************************************************/
public class UniqueIntegers {
	int skip;
	/**
	 * Calculates the least number of unique numbers after removing k elements
	 * @param values Values to process
	 * @param k Number of items to remove from the array
	 * @return Smallest unique list
	 */
	public List<Integer> calculate(int[] values, int k) {
		if (values == null || values.length <= 0 || k < 0) return new ArrayList<>();
		skip = k;
		List<Integer> results = new ArrayList<>();
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int num : values) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
		.sorted(Map.Entry.comparingByValue())
		.forEach(entry -> {
			for (int i = 0; i < entry.getValue(); i ++) {
				if (skip > 0) {
					--skip;
				} else {
					if (!results.contains(entry.getKey()))
					results.add(entry.getKey());
				}				
			}
		});
		return results;
	}
}
