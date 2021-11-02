package com.smt.kata.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

/****************************************************************************
 * <b>Title</b>: KaprekarsConstant.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Kaprekar's Constant Kata
 * 
 * The number 6174 is known as Kaprekar's constant, after the mathematician who 
 * discovered an associated property: for all four-digit numbers with at least 
 * two distinct digits, repeatedly applying a simple procedure eventually results 
 * in this value. The procedure is as follows:
 * 
 * For a given input x, create two new numbers that consist of the digits in x in 
 * ascending and descending order.
 * 
 * Subtract the smaller number from the larger number.
 * For example, this algorithm terminates in three steps when starting from 1234:
 * 
 * 4321 - 1234 = 3087
 * 8730 - 0378 = 8352
 * 8532 - 2358 = 6174
 * 
 * Write a function that returns how many steps this will take for a given input N.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
public class KaprekarsConstant {

	/**
	 * Calculates the number of steps until Kaprekar's Constant is achieved
	 * @param num Number to evaluate
	 * @return the number of steps to acheive the number
	 */
	public int calculateSteps(int num) {
		if (num < 1000 || num > 9998) return 0;
		int x = num;
		String str = x + "";
		char first = str.charAt(0);
		boolean dupe = true;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != first) dupe = false;
		}
		if (dupe == true) return 0;
		int count = 0;
		
		while (x != 6174) {
			String str1 = x + "";
			List<String> ascending = Arrays.asList(str1.split(""));
			Collections.sort(ascending);
			List<String> descending = Arrays.asList(str1.split(""));
			Collections.sort(descending);
			Collections.reverse(descending);
			int d = Integer.parseInt(String.join("", descending));
			int a = Integer.parseInt(String.join("", ascending));
			x = d - a;
			++count;
		}
		return count;
	}
}
