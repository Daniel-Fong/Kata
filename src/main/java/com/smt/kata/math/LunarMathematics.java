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
		String str1 = Integer.toString(Math.abs(firstNumber));
		String str2 = Integer.toString(Math.abs(secondNumber));
		int difference = Math.abs(str1.length()- str2.length());
		if (str2.length() > str1.length()) {
			str1 = addZeroes(str1, difference);
		} else {
			str2 = addZeroes(str2, difference);
		}
		String result = "";
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) > str2.charAt(i)) {
				result += str1.charAt(i) + "";
			} else {
				result += str2.charAt(i) + "";
			}
		}
		return Integer.parseInt(result);
	}
	
	public String addZeroes(String str, int difference) {
		int count = 0;
		while (count < difference) {
			str = "0" + str;
			++count;
		}
		return str;
	}

}
