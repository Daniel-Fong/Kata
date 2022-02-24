package com.smt.kata.data;

import java.util.Arrays;

/****************************************************************************
 * <b>Title</b>: PairsDivisibleByK.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Check If Array Pairs Are Divisible by k
 * 
 * Given an array of integers arr of even length n and an integer k.
 * 
 * We want to divide the array into exactly n / 2 pairs such that the sum of each 
 * pair is divisible by k.
 * 
 * Return true If you can find a way to do that or false otherwise.
 * 
 * Example 1:
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output: 5
 * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * 
 * Example 2:
 * 
 * Input: arr = [1,2,3,4,5,6], k = 7
 * Output: 3
 * Explanation: Pairs are (1,6),(2,5) and(3,4).
 * 
 * Example 3:
 * Input: arr = [1,2,3,4,5,6], k = 10
 * Output: 0
 * Explanation: You can try all possible pairs to see that there is no way to 
 * divide arr into 3 pairs each with sum divisible by 10.
 * 
 * Constraints:
 * arr.length == n
 * 1 <= n <= 105
 * n is even.
 * -109 <= arr[i] <= 109
 * 1 <= k <= 105
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2022
 * @updates:
 ****************************************************************************/
public class PairsDivisibleByK {

	/**
	 * Calculates the number of matched pairs
	 * @param values Int values to pair and evaluate
	 * @param k Divisible value to be evaluated
	 * @return Number of matching pairs
	 */
	public int calculate(int[] values, int k) {
		if ( values == null || values.length < 1 || values.length % 2 != 0 || k < 0 || k > 109) return 0;
		Arrays.sort(values);
		int pairs = 0;
		for (int i = 0; i < values.length - 1; i++) {
			int first = values[i];
			if (first == 0) continue;
			for (int j = values.length - 1; j > i; j--) {
				int second = values[j];
				if (second == 0) continue;
				if ((first + second) % k == 0) {
					System.out.println("first " + first + " | second " + second);
					values[i] = 0;
					values[j] = 0;
					++pairs;
					break;
				}
			}
		}
		return pairs;
	}
}
