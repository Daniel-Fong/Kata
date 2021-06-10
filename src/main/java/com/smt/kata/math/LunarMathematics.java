package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: LunarMathematics.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Lunar Mathematics 
 * 
 * Lunar Mathematics, otherwise known as 'Dismal Mathematics'
 * (a play on 'decimal mathematics'), was created as an alternate way to view
 * mathematics interacts with numbers. Here, we will create the addition
 * function.
 * 
 * On the moon, there is no need to carry over numbers into the next column.
 * Instead, we take the largest value of each column, and set that as our total.
 * 
 * Examples:
 * 
 * 8 + 7 ---- 8 <- Since 8 is the larger number of the two, it is the one used.
 * 
 * 234 + 180 ----- 284 <- the larger values of each number are used for each portion.
 * 
 * 50 +59 ------ 59 <- If a number in two columns match, either one of the
 * numbers can be used.
 * 
 * 465 + 72 ----- 475 <- You must handle situations where numbers are not of
 * equal length Assume all numbers given are valid, nonnegative integers (as
 * there are no negative numbers on the moon). 
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class LunarMathematics {
	
	/**
	 * Performs Lunar Math on the 2 provided numbers
	 * @param firstNumber First number to add
	 * @param secondNumber Second Number to add
	 * @return Total of the lunar math addition of the provided 2 numbers
	 */
	public int add(int firstNumber, int secondNumber) {
		String first = Integer.toString(Math.abs(firstNumber));
		String second = Integer.toString(Math.abs(secondNumber));
		int firstLength = first.length();
		int secondLength = second.length();
		int length = 0;
		String result = "";
		if (first.length() > second.length()) {
			length = first.length();
		} else {
			length = second.length();
		}
		for (int i = 0; i < length; i++) {
			String f = "";
			String s = "";
			if (firstLength == length || firstLength - i >= 1) {
				f = first.charAt(firstLength - i -1)+"";
			}
			if (secondLength == length || secondLength - i >= 1) {
				s = second.charAt(secondLength - i - 1)+"";
			}
			if (f.length() > 0 && s.length() > 0) {
				if (Integer.parseInt(f) > Integer.parseInt(s)) {
					result = f+result;
				} else {
					result = s+result;
				}
			} else if (f.length() > 0) {
				result = f+result;
			} else {
				result = s+result;
			}
		}
		return Integer.parseInt(result);
	}

}
