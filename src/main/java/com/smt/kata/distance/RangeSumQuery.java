package com.smt.kata.distance;

// JDK 11.x
import java.util.List;

// Kata Libs
import com.smt.kata.distance.bean.Rectangle;

/****************************************************************************
 * <b>Title</b>: RangeSumQuery.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Range Sum Query Kata
 * 
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * 
 * Calculate the sum of the elements of matrix inside the rectangle defined by 
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Implement the NumMatrix class:
 * 
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the 
 * elements of matrix inside the rectangle defined by its upper 
 * left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Allow multiple rectangles to be used inside the matrix.  If the rectangles overlap, 
 * those coordinates may be utilized only once when summing the values
 * 
 * ******* Note: Modifications to the CoordinateVO and Rectangle Class may be appropriate
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 31, 2021
 * @updates:
 ****************************************************************************/
public class RangeSumQuery {

	// Members
	protected int[][] matrix;
	
	/**
	 * Initializes the class with a matrix to use to calculate against
	 * @param matrix Matrix to use for calculating sums
	 */
	public RangeSumQuery(int[][] matrix) {
		super();
		this.matrix = matrix;
	}
	
	/**
	 * Sums the values from the provided matrix that are inside the rectangle
	 * @param areas Rectangles to sum the areas
	 * @return Sum of all cells inside the rectangles
	 */
	public int sumRange(List<Rectangle> areas) {
		if ( areas.size() == 0 || this.matrix == null || this.matrix.length == 0 || this.matrix[0] == null || this.matrix[0].length == 0) return 0;
		if (areas.size() == 1) {
			return getSum(areas.get(0));
		} else {
			Rectangle box1 = areas.get(0);
			Rectangle box2 = areas.get(1);
			int sum = 0;
			int minus = 0;
			if (box1.bottomRight.getColumn() >= box2.topLeft.getColumn() && box1.bottomRight.getRow() >= box2.topLeft.getRow()) {
				Rectangle negative = new Rectangle(box2.topLeft, box1.bottomRight);
				minus = getSum(negative);
			}
			for (Rectangle rect : areas) {
				sum += getSum(rect);
			}
			return sum - minus;
		}
	}
	
	public int getSum(Rectangle box) {
		if (box.bottomRight.getColumn() > matrix[0].length -1) box.bottomRight.setColumn(matrix[0].length-1);
		if (box.bottomRight.getRow() > matrix.length-1) box.bottomRight.setRow(matrix.length-1);
		int sum = 0;
		for (int i = box.topLeft.getColumn(); i <= box.bottomRight.getColumn(); i++) {
			for (int j = box.topLeft.getRow(); j <= box.bottomRight.getRow(); j++) {
				System.out.println(this.matrix[j][i]);
				sum += this.matrix[j][i];
			}
		}
		return sum;
	}

}
