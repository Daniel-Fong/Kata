package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/****************************************************************************
 * <b>Title</b>: CoinCollector.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Coin Collector
 * 
 * You are given a 2-d matrix where each cell represents number of coins in that 
 * cell. Assuming we start at matrix[0][0], and can only move right or down, 
 * find the maximum number of coins you can collect by the bottom right corner.
 * 
 * For Example, in this matrix:
 * 0 3 1 1
 * 2 0 0 4
 * 1 5 3 1
 * 
 * The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 20, 2021
 * @updates:
 ****************************************************************************/
public class CoinCollector {

	List<Integer> totals = new ArrayList<Integer>();
	/**
	 * Following various paths,calculate the most coins that can be retrieved
	 * @param matrix Matrix of coins
	 * @return Total number of coins collected
	 */
	public int collect(int[][] matrix) {
		if (matrix == null|| matrix.length <1 || matrix[0].length <1)return 0;
		findPath(0, 0, matrix, 0);
		return Collections.max(totals);
	}
	
	public void findPath (int x, int y, int[][] matrix, int total) {
		total += matrix[y][x];
		if (x+1 < matrix[y].length) {
			findPath(x + 1, y, matrix, total);
		}
		
		if (y+1 < matrix.length && matrix[y+1].length > x) {
			findPath(x, y+1, matrix, total);
		}
		
		if (y + 1 == matrix.length && x + 1 == matrix[matrix.length - 1].length) {
			totals.add(total);
		}
	}
}
