package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: ClosestPoints.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Closest points Kata
 * 
 * Given a set of points (x, y) on a 2D cartesian plane, find the two closest points. 
 * For example, given the points [
 * 		(1, 1), 
 * 		(-1, -1), 
 * 		(3, 4), 
 * 		(6, 1), 
 * 		(-1, -6), 
 * 		(-4, -3)
 * ], 
 * 
 * return [(-1, -1), (1, 1)]
 * 
 * Constraints:
 * points length > 1
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 16, 2021
 * @updates:
 ****************************************************************************/
public class ClosestPoints {

	/**
	 * Finds the two closest points and returns them
	 * @param points Points to calculate distance against
	 * @return Closest points
	 */
	public Integer[][] calculateClosestPoints(Integer[][] points) {
		// Return the pairs with the min distance
		if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return new Integer[0][0];
		int point1 = 0;
		int point2 = 1;
		int distance = (Math.abs(points[0][0] - points[1][0]) + Math.abs(points[0][1] - points[1][1]));
		for (int i = 0; i < points.length - 1; i++) {
			Integer[] first = points[i];
			for(int j = i + 1; j < points.length; j++) {
				Integer[] second = points[j];
				int curDistance = (Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]));
				if (curDistance < distance) {
					distance = curDistance;
					point1 = i;
					point2 = j;
				}
			}
		}
		Integer[][] result = new Integer[2][];
		result[0] = points[point1];
		result[1] = points[point2];
		return result;
	}
}
