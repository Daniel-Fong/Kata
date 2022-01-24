package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: CommonOneBits.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Common One Bits
 * 
 * Given an integer n, find the next biggest integer with the same number of 
 * 1-bits on. For example, given the number 6 (0110 in binary), return 9 (1001).
 * 
 * Constraints
 * 0 >= start <= 1024
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 14, 2021
 * @updates:
 ****************************************************************************/
public class CommonOneBits {

	/**
	 * Finds the next number with the same number of '1s'
	 * @param start Starting value to calculate against
	 * @return Next number to match
	 */
	public int find(int start) {
		if (1024 < start || start < 0) return 0;
		String binary = Integer.toBinaryString(start);
		int count = countOnes(binary);
		int otherCount = 0;
		int next = start;
		while (otherCount != count) {
			++next;
			otherCount = countOnes(Integer.toBinaryString(next));
		}
		// Return the value
		return next;
	}
	
	public int countOnes(String str) {
		int count = 0;
		for (char c : str.toCharArray()) {
			if (c == '1') {
				++count;
			}
		}
		return count;
	}
}
