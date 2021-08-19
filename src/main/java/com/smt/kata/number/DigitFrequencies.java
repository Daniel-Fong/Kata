package com.smt.kata.number;

import java.math.BigDecimal;
import java.math.BigInteger;

/****************************************************************************
 * <b>Title</b>: DigitFrequencies.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Digit Frequencies
 * 
 * Given a positive integer n, find the frequencies of the digits from 0 to 9 of the number 2n.
 * 
 * Here is an example for n=10. The digits of 210=1024 are (1,0,2,4). The 
 * frequencies of the digits 0, 1, 2, …, 9 are 1, 1, 1, 0, 1, 0, 0, 0, 0, 0:
 * 
 * DigitFrequenciesInThePowersOfTwo[10]
 * {1, 1, 1, 0, 1, 0, 0, 0, 0, 0}
 * 
 * 2^100
 * 1267650600228229401496703205376
 * 
 * DigitFrequenciesInThePowersOfTwo[100]
 * {6, 2, 6, 2, 2, 2, 5, 3, 1, 2}
 * 
 * Note: If the calculates number is less than 0, still count the digits.  Skip 
 * any non-numeric characters (such as ".").  Keep any leading zeros
 * 
 * You may NOT use any collections for this exercise
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 13, 2021
 * @updates:
 ****************************************************************************/
public class DigitFrequencies {

	/**
	 * Calculates the number of characters from 0-9 in the response
	 * @param pow This is the power of 2 to be calculated
	 * @return int array with 10 elements containing a count of each digit
	 */
	public int[] calculate(int pow) {
		BigDecimal big = new BigDecimal(Math.pow(2, pow));
		String str = big.toString();
		System.out.println(str);
		int[] result = new int[10];
		for (int i = 0; i<str.length(); i++) {
			if (str.charAt(i) != '.') {
				int x = Integer.parseInt(str.charAt(i) + "");
				System.out.println(x);
				result[x] += 1;
			}
		}
		return result;
	}
}
