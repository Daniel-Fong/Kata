package com.smt.kata.math;

import java.util.ArrayList;
// JDK 11.x
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.buf.StringUtils;

/****************************************************************************
 * <b>Title</b>: LargestNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Largest Number
 * 
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * 
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * 
 * Example 3:
 * Input: nums = [1]
 * Output: "1"
 * 
 * Example 4:
 * Input: nums = [10]
 * Output: "10"
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 17, 2021
 * @updates:
 ****************************************************************************/
public class LargestNumber {

	/**
	 * Finds the largest number from the array of integers supplied
	 * @param values int array of the values to calculate against
	 * @return Number in string format of the largest value.  0 if array is 
	 * empty or null
	 */
	public String find(int[] values) {
		if (values == null || values.length == 0) return "";
		List<String> list = new ArrayList<>();
		List<String> results = new ArrayList<>();
		for (int num : values) {
			list.add(Integer.toString(num));
		}
		if (list.size() == 1) return list.get(0);
		for (int i = 0; i < list.size(); i++) {
			String highest = list.get(0);
			int highestIndex = 0;
			for (int j = 1; j < list.size(); j++) {
				String cur = list.get(j);
				int index = 0;
				for (char c : cur.toCharArray()) {
					if (index >= highest.length()) {
						if (c > highest.charAt(0)) {
							highest = cur;
							highestIndex = j;	
						}
						break;
					}
					if (c > highest.charAt(index)) {
						highest = cur;
						highestIndex = j;
						++index;
					} else if (c < highest.charAt(index)) {
						break;
					} else {
						++index;
					}
				}
			}
			results.add(highest);
			list.set(highestIndex, "0");
		}
		return String.join("", results);
	}
}
