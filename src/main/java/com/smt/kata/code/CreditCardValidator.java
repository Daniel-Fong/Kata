package com.smt.kata.code;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: CreditCardValidator.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Validate Credit Card Number
 * Create a function that takes a number as an argument and returns true if the number 
 * is a valid credit card number, false otherwise.
 * 
 * Credit card numbers must valid, and pass the Luhn test, described below:
 * 
 * Remove the last digit (this is the "check digit").
 * Reverse the number.
 * Double the value of each digit in odd-numbered positions. If the doubled 
 * value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
 * Add all digits.
 * Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
 * 
 * Examples
 * validateCard(1234567890123456) ➞ false
 * 
 * // Step 1: check digit = 6, num = 123456789012345
 * // Step 2: num reversed = 543210987654321
 * // Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
 * // Step 4: sum = 58
 * // Step 5: 10 - 8 = 2 (not equal to 6) ➞ false
 * 
 * isValid(1234567890123452) ➞ true
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 8, 2021
 * @updates:
 ****************************************************************************/
public class CreditCardValidator {
	
	/**
	 * Validates the provided CC number
	 * @param ccn
	 * @return
	 */
	public boolean isValid(String ccn) {
		if (ccn == "" || ccn == null) {
			return false;
		}
		if (!ccn.matches("\\d+")) {
			return false;
		}
		int check = Integer.parseInt(Character.toString(ccn.charAt(ccn.length()-1)));
		String nums = ccn.substring(0, ccn.length()-1);
		System.out.println(ccn);
		StringBuilder reverse = new StringBuilder();
		reverse.append(nums);
		reverse.reverse();
		int[] arr = new int[reverse.length()];
		for (int i = 0; i<reverse.length(); i++) {
			if (i % 2 == 0) {
				int twice = Integer.parseInt(Character.toString(reverse.charAt(i))) * 2;
				if (twice >= 10) {
					String str = Integer.toString(twice);
					arr[i] = Integer.parseInt(Character.toString(str.charAt(0))) + Integer.parseInt(Character.toString(str.charAt(1)));
				}
				arr[i] = Integer.parseInt(Character.toString(reverse.charAt(i)));
			}
		}
		int sum = 0;
		for (int j = 0; j<arr.length; j++) {
			sum += arr[j];
		}
		String lastStr = Integer.toString(sum);
		int last = Integer.parseInt(Character.toString(lastStr.charAt(lastStr.length()-1)));
		if (10 - last == check) {
			return true;
		} else {
			return false;
		}
	}
}
