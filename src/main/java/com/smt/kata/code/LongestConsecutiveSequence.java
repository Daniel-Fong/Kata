package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: LongestConsecutiveSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * You may only use primitives and standard Java.  Collections, Arrays.class, etc .. are not permitted
 * There should be NO imports in your class
 * 
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
public class LongestConsecutiveSequence {
	
	/**
	 * Finds the longest sequence of numbers on the array
	 * @param items Items to be calculated against
	 * @return Largest sequence of numbers in the array
	 */
	public int calculate(int[] items) {
		if (items == null || items.length == 0) return 0;
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (items[j] > items[j+1]) {
					int temp = items[j];
					items[j] = items[j + 1];
					items[j+1] = temp;
				}
			}
		}
		int length = 0;
        int result = length;
        
        for (int i = 0; i < items.length - 1; ++i) {
            if (items[i] + 1 == items[i + 1]) {
                ++length;
                if (length > result) result = length;
            }
            else
                length = 0;
        }
		return result + 1;
	}
}
