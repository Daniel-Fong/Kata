package com.smt.kata.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: WeakestRow.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> The K Weakest Rows in a Matrix Kata
 * 
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 
 * 0's (representing civilians). The soldiers are positioned in front of the 
 * civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * 
 * A row i is weaker than a row j if one of the following is true:
 * 
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * 
 * Example 1:
 * Input: mat = 
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]], 
 * k = 3
 * Output: [2,0,3]
 * Explanation: 
 * The number of soldiers in each row is: 
 * - Row 0: 2 
 * - Row 1: 4 
 * - Row 2: 1 
 * - Row 3: 2 
 * - Row 4: 5 
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * 
 * Example 2:
 * Input: mat = 
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]], 
 * k = 2
 * Output: [0,2]
 * Explanation: 
 * The number of soldiers in each row is: 
 * - Row 0: 1 
 * - Row 1: 4 
 * - Row 2: 1 
 * - Row 3: 1 
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * 
 * **** Note, rows that are similarly weak will be sorted by the row index
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 16, 2021
 * @updates:
 ****************************************************************************/
public class WeakestRow {

	/**
	 * Finds the weakest rows
	 * @param matrix Matrix to search for the weakest rows
	 * @param k Number of weakest elements to return
	 * @return int array with the row ids of the weakest rows
	 */
	public int[] find(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || k <= 0 || k > matrix.length) return new int[0];
		List<Integer> list = new ArrayList<>();
		
		int[] result = new int[k];
		for (int i = 0; i < matrix.length; i++) {
			int sum = 0;
			for (int num : matrix[i]) {
				sum += num;
			}
			list.add(sum);
		}
		List<Integer> used = new ArrayList<>();
		for (int j = 0; j < k; j++) {
			int weakest = 0;
			int index = 0;
			for (int l = 0; l < list.size(); l++) {
				if (used.contains(l)) continue;
				else if (list.get(l) == 0) {
					index = l;
					break;
				}
				else if (weakest == 0 || list.get(l) < weakest) {
					weakest = list.get(l);
					index = l;
				} 
			}
			used.add(index);
			result[j] = index;
			
		}
		return result;
	}
}
