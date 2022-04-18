package com.smt.kata.number;

/****************************************************************************
 * <b>Title</b>: PerfectNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Perfect Number Kata
 * 
 * A number is considered perfect if its digits sum up to exactly 10.
 * 
 * Given a positive integer n, return the n-th perfect number.
 * 
 * For example, given 1, you should return 19. Given 2, you should return 28.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 16, 2022
 * @updates:
 ****************************************************************************/
public class PerfectNumber {

	/**
	 * Finds the nth perfect number
	 * @param nth nth value to locate
	 * @return Value of the nth perfect number
	 */
	public int find(int nth) {
		int count = 0;
		int curNum = 0;
		while (count < nth) {
			++curNum;
			if (isPerfect(curNum)) {
				++count;
			}
		}
		return curNum;
	}
	
	private boolean isPerfect(int num) {
        String str = num + "";
        int total = 0;
        for (char c : str.toCharArray()) {
            total += Character.getNumericValue(c);
        }
        return 10 == total;
    }

}
