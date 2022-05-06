package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: CountMatrixPaths.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Count Matrix Paths Kata
 * 
 * There is an N by M matrix of zeroes. Given N and M, write a function to count 
 * the number of ways of starting at the top-left corner and getting to the 
 * bottom-right corner. You can only move right or down.
 * 
 * For example, given a 2 by 2 matrix, you should return 2, since there are 
 * two ways to get to the bottom-right:
 * 
 * Right, then down
 * Down, then right
 * 
 * Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 18, 2022
 * @updates:
 ****************************************************************************/
public class CountMatrixPaths {
	public int count;
	
	/**
	 * Counts the number of pathways through the matrix
	 * @param rows Number of rows in the matrix
	 * @param cols Number of columns in the matrix
	 * @return Number of pathways through the matrix
	 */
	public int count(int rows, int cols) {
		findPaths(1, 1, rows, cols);
		return count;
	}
	
	public void findPaths(int x, int y, int rows, int cols) {
		if (x == cols && y == rows) {
			++count;
			return;
		} 
		if (x < cols) {
			findPaths(x+1, y, rows, cols);
		}
		if (y < rows) {
			findPaths(x, y+1, rows, cols);
		}
	}	
}
