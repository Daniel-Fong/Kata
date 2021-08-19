package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: BaseBPalindrome.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Base-b Palindromic Numbers
 * 
 * Write a function that accepts an integer in decimal base and converts it to the 
 * provided base value.  Bases of 2, 8, 10, and 16 should be supported 
 * More Examples
 * 
 * In base 2, the number 5 is 101 in binary which is a palindrome
 * 
 * NOTES - No Collections, Strings, Arrays or most other classes are to be used.  You MAY
 * NOT use the Integer or other number classes to do the base conversions.  Arrays
 * and primitives only.  
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 17, 2021
 * @updates:
 ****************************************************************************/
public class BaseBPalindrome {
	
	/**
	 * Determines of the converted value is a palindrome
	 * @param value Value to be tested
	 * @param base Base to convert
	 * @return True if the converted number is a palindrome.  False otherwise
	 */
	public boolean isPalindrome(int value, int base) {
		System.out.println(value);
		int[] arr = getNewNumberArr(value, base);
		System.out.println(arr.length);
		for (int i = 0; i<Math.floor(arr.length/2); i++) {
			if (arr[i] != arr[arr.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	public int[] getNewNumberArr(int value, int base) {
		int i = 0;
		int v = value;
		while (base * i < value) {
			i++;
		}
		i -= 1;
		System.out.println(i);
		int[] arr = new int[i + 1];
		while (i >= 0) {
			if (v >= base * i) {
				v -= base * i;
				arr[arr.length - (i + 1)] = 1;
				i--;
			} else {
				arr[arr.length - (i+1)] = 0;
				i--;
			}
		}
		return arr;
		
	}
}
