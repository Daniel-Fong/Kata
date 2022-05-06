package com.smt.kata.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: SumDivisibleByP.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Make Sum Divisible by P
 * 
 * Given an array of positive integers nums, remove the smallest subarray (possibly 
 * empty) such that the sum of the remaining elements is divisible by p. It is 
 * not allowed to remove the whole array.
 * 
 * Return the length of the smallest subarray that you need to remove, or -1 if 
 * it's impossible.
 * 
 * A subarray is defined as a contiguous block of elements in the array.
 * 
 * Example 1:
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible by 6. 
 * We can remove the subarray [4], and the sum of the remaining elements is 6, 
 * which is divisible by 6.
 * 
 * Example 2:
 * Input: nums = [6,3,5,2], p = 9
 * Output: 2
 * Explanation: We cannot remove a single element to get a sum divisible by 9. 
 * The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
 * 
 * Example 3:
 * Input: nums = [1,2,3], p = 3
 * Output: 0
 * Explanation: Here the sum is 6. which is already divisible by 3. Thus we do 
 * not need to remove anything.
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 28, 2022
 * @updates:
 ****************************************************************************/
public class SumDivisibleByP {

	/**
	 * Calculates the smallest sum divisible by p
	 * @param nums Array of values
	 * @param p Value to be divisible
	 * @return Smallest number of removed items.  -1 if not possible
	 */
 	public int calculate(int[] nums, int p) {
 		if(nums == null || nums.length < 1) return -1;
 		int min = nums.length;
 		boolean isAnswer = false;
 		List<List<Integer>> subsets = getSubsets(nums);
 		for (List<Integer> arr : subsets) {
 			if (isDivisible(arr, p)) {
 				if (nums.length - arr.size() < min) {
 					min = nums.length - arr.size();
 					isAnswer = true;
 				}
 			}
 		}
 		if (!isAnswer) return -1;
 		return min;
 	}
 	
 	public List<List<Integer>> getSubsets(int[] nums) {
 		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
 		List<List<Integer>> list = new ArrayList<>();
 		for (int i = 0; i < nums.length; i++) {
 			for (int j = i; j <= nums.length; j++) {
 				List<Integer> temp = new ArrayList<>(numsList);
 				temp.subList(i, j).clear();
 				list.add(temp);
 			}
 		}
 		return list;
 	}
 	
 	public boolean isDivisible(List<Integer> nums, int p) {
 		int sum = 0;
 		for(int num: nums) {
 			sum += num;
 		}
 		if (sum % p == 0) {
 			return true;
 		} else {
 			return false;
 		}
 	}
}
