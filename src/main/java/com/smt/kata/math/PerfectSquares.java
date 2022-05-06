package com.smt.kata.math;

import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.connect.Connector.IntegerArgument;

/****************************************************************************
 * <b>Title</b>: PerfectSquares.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Write a program that determines the smallest number of 
 * perfect squares that sum up to N.
 * 
 * Here are a few examples:
 * 
 * Given N = 4, return 1 (4)
 * Given N = 17, return 2 (16 + 1)
 * Given N = 18, return 2 (9 + 9)
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 15, 2022
 * @updates:
 ****************************************************************************/
public class PerfectSquares {
	
	public List<List<Integer>> results = new ArrayList<>();
	public int overflow;

	/**
	 * Finds the smallest number of squares that add to the total "n"
	 * @param n Number to match the squares
	 * @return Number of squares to solve the matches
	 */
	public int findSmallestNumber(int n) {
		overflow = Integer.MAX_VALUE;
		List<Integer> perfectSquares = getPerfectSquares(n);
		if (perfectSquares.contains(n)) return 1;
		getCombos(perfectSquares, new ArrayList<>(), 0, n);
		System.out.println(results);
		int smallest = results.get(0).size();
		for (List<Integer> list : results) {
			if (list.size() < smallest) {
				smallest = list.size();
			}
		}
		return smallest;
	}
	
	public List<Integer> getPerfectSquares(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (Math.sqrt(i) % 1 == 0) result.add(i); 
		}
		return result;
	}
	
	public void getCombos(List<Integer> perfectSquares, List<Integer> result, int total, int target) {		
		if (total == target) {
			results.add(result);
			return;
		} 
		if (result.size() > 4) return;
		for (int num : perfectSquares) {
			List<Integer>  newList = new ArrayList<>(result);
			if (total + num <= target) {
				newList.add(num);
				getCombos(perfectSquares, newList, total + num, target);
			}
		}
	}
}
