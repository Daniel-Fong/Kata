package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MaximalRectangle.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Maximal Rectangle
 * 
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg
 * 
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * Example 2:
 * Input: matrix = []
 * Output: 0

 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * Example 4:
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * Example 5:
 * Input: matrix = [["0","0"]]
 * Output: 0
 * 
 * Constraints:
 * rows == matrix.length
 * cols == matrix[i].length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 28, 2021
 * @updates:
 ****************************************************************************/
public class MaximalRectangle {
	List<Integer> list = new ArrayList<>();

	/**
	 * Calculates the largest rectangle of all ones
	 * @param matrix Matrix to calculate against
	 * @return Count of all of the "1"s in the rectangle
	 */
	public int calculate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[0].length; x++) {
				findRectangles(matrix, x, y, x, y, 0);
			}
		}
		Collections.sort(list);
		Collections.reverse(list);
		return list.isEmpty() ? 0 : list.get(0);
	}
	
	public void findRectangles(int[][] matrix, int startX, int startY, int endX, int endY, int count) {
		if (matrix[startY][startX] == 0) return;
		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				if (matrix[y][x] < 1) {
					list.add(count);
					return;
				}
			}
		}
		int area = (endX - startX + 1) * (endY - startY + 1);
		if (endY + 1 < matrix.length) findRectangles(matrix, startX, startY, endX, endY+1, area);
		if (endX + 1 < matrix[0].length) findRectangles(matrix, startX, startY, endX + 1, endY, area);
		if (endY + 1 >= matrix.length && endX + 1 >= matrix[0].length) list.add(area);
		return;
	}
}
