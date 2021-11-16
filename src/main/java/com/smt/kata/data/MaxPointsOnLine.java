package com.smt.kata.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MaxPointsOnLine.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Points on a Line Kata
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on the 
 * X-Y plane, return the maximum number of points that lie on the same straight line.
 * this check assumes vertical/horizontal and diagonal (45 degrees) as the lines
 * to evaluate
 * 
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * https://assets.leetcode.com/uploads/2021/02/25/plane1.jpg
 * Output: 3
 * 
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * https://assets.leetcode.com/uploads/2021/02/25/plane2.jpg
 * Output: 4
 * 
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * Each point is processed only once, even if it is duplicated
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 12, 2021
 * @updates:
 ****************************************************************************/
public class MaxPointsOnLine {
    
    /**
     * Calculates the number of points on a straight line
     * @param points Points on the graph
     * @return Max points in any straight line (vertical, horizontal and diagonal)
     */
    public int findMax(int[][] points) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;
        List<Integer> counts = new ArrayList<>();
        for(int[] point : points) {
            if (point != null) {
                counts.add(horizontal(points, point));
                counts.add(vertical(points, point));
                counts.add(diagonal1(points, point));
                counts.add(diagonal2(points, point));
            }
        }
        Collections.sort(counts);
        Collections.reverse(counts);
        return counts.get(0);
    }
    
    public int horizontal(int[][] points, int[] start) {
        int count = 1;
        List<int[]> list = new ArrayList<>();
        list.add(start);
        for(int[] point : points) {
            if (point != null && !!containsPoint(list, point)) {
                list.add(point);
                if (point[0] == start[0]) {
                    ++count;
                }
            } 
        }
        return count;
    }
    
    public int vertical(int[][] points, int[] start) {
        int count = 1;
        List<int[]> list = new ArrayList<>();
        list.add(start);
        for(int[] point : points) {
            if (point != null && !containsPoint(list, point)) {
                System.out.println(point);
                list.add(point);
                if (point[1] == start[1]) {
                    ++count;
                }
            } 
        }
        return count;
    }
    
    public int diagonal1(int[][] points, int[] start) {
        int count = 1;
        List<int[]> list = new ArrayList<>();
        list.add(start);
        for(int[] point : points) {
            if (point == null || !containsPoint(list, point)) {
                continue;
            } else {
                list.add(point);
                if (point[1] - start[1] == point[0] - start[0]) {
                    ++count;
                }
            }
        }
        return count;
    }
    
    public int diagonal2(int[][] points, int[] start) {
        int count = 1;
        List<int[]> list = new ArrayList<>();
        list.add(start);
        for(int[] point : points) {
            if (point == null || !containsPoint(list, point)) {
                continue;
            } else {
                list.add(point);
                if (start[1] - point[1] == -(start[0] - point[0])) {
                    ++count;
                }
            }
        }
        return count;
    }
    
    public boolean containsPoint(List<int[]> list, int[] point) {
        for (int[] arr : list) {
            if (arr[0] == point[0] && arr[1] == point[1]) {
                return true;
            }
        }
        return false;
    }
}