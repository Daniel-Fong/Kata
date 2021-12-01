package com.smt.kata.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: HouseRobber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each house 
 * has a certain amount of money stashed, the only constraint stopping you from 
 * robbing each of them is that adjacent houses have security systems connected 
 * and it will automatically contact the police if two adjacent houses were broken 
 * into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house, return 
 * the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 17, 2021
 * @updates:
 ****************************************************************************/
public class HouseRobber {
	
	List<Integer> results = new ArrayList<>();
	
	/**
	 * Calculates the max amount a robber can make without getting arrested
	 * @param values
	 * @return
	 */
	public int calculate(int[] values) {
		if (values == null || values.length < 1) return 0;
		if (values.length == 1) return values[0];
		recurse(values, 0, 0);
		recurse(values, 1, 0);
		Collections.sort(results);
		Collections.reverse(results);
		return results.get(0);
	}
	
	public void recurse(int[] values, int index, int total) {
		int newTotal = total + values[index];
		if (index >= values.length - 2) results.add(newTotal);
		else {
			recurse(values, index + 2, newTotal);
			if (index < values.length -3) {
				recurse(values, index + 3, newTotal);
			}
		}
	}
}
