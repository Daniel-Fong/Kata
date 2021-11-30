package com.smt.kata.number;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: UglyNumber.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Ugly Number Kata
 * 
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * 
 * Given an integer n, return the nth ugly number.
 * 
 * Example 1:
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * 
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * 
 * Constraints:
 * 1 <= n <= 1690
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 17, 2021
 * @updates:
 ****************************************************************************/
public class UglyNumber {

	/**
	 * Finds the nth Ugly Number
	 * @param n Nth ugly number to find
	 * @return nth ugly number.  Return 0 if n < 1 or greater than 1690
	 */
	public int find(int n) {
		if (n <= 0) return 0;
		int count = 0;
		int number = 1;
		while (count < n) {
			if (isUgly(number)) {
				++count;
			}
			++number;
		}
		return number;
	}
	
	public boolean isUgly(int n) {
		List<Integer> factors = getFactors(n);
		List<Integer> primeFactors = new ArrayList<>();
		for (Integer num : factors) {
			if (num == 2 || num == 3 || num == 5 || !isPrime(num)) continue;
			else primeFactors.add(num);
		}
		return primeFactors.size() <= 0;
	}
	
	public List<Integer> getFactors(int n) {
		List<Integer> results = new ArrayList<>();
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				results.add(i);
			}
		}
		return results;
	}
	
	public boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

}
