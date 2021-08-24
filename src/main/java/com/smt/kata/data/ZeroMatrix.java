package com.smt.kata.data;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: ZeroMatrix.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Zero Matrix
 * 
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row 
 * and column to 0's, and return the matrix.
 * 
 * You must do it in place.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * Example 2:
 * https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *  
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class ZeroMatrix {

	/**
	 * Assigns the columns and rows to all zeros when a cell is 0
	 * @param matrix Matrix to assign
	 * @return Matrix with the rows and columns updated
	 */
	public int[][] assign(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return new int[0][0];
		if (matrix[0] == null) return new int[0][0];
		// Return the updated matrix
		List<Integer> columns = new ArrayList<>();
		List<Integer> rows = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (columns.contains(j) || rows.contains(i)) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
}
