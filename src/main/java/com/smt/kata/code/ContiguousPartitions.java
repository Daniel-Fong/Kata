package com.smt.kata.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: ContiguousPartitions.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Contiguous Partitions Kata
 * 
 * Given a list of strictly positive integers, partition the list into 3 contiguous 
 * partitions which each sum up to the same value. If not possible, return empty int[][].
 * 
 * For example, given the following list:
 * 
 * [3, 5, 8, 1, 7]
 * Return the following 3 partitions:
 * 
 * [[3, 5],
 *  [8],
 *  [1, 7]]
 *  
 * Which each add up to 8.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2022
 * @updates:
 ****************************************************************************/
public class ContiguousPartitions {
	
	List<int[][]> list = new ArrayList<>();

	/**
	 * partitions the array into 3 sub arrays where the sun of each array is equal
	 * @param values Array to partition
	 * @return 3 partitions of equal values.  Empty array if none found
	 */
	public int[][] find(int[] values) {
		if (values == null || values.length < 3) return new int[0][];
		getCombos(values, 1, 1);
		for (int[][] matrix : list) {
			if (equalSums(matrix)) return matrix;
		}
		return new int[0][];
	}
	
	public void getCombos(int[] values, int firstLength, int secondLength) {
		if (firstLength + secondLength >= values.length) return;
		int[] firstArr = Arrays.copyOfRange(values, 0, firstLength);
		int[] secondArr = Arrays.copyOfRange(values, firstLength, firstLength + secondLength);
		int[] thirdArr = Arrays.copyOfRange(values, firstLength + secondLength, values.length);
		int[][] matrix = {firstArr, secondArr, thirdArr};
		list.add(matrix);
		getCombos(values, firstLength + 1, secondLength);
		getCombos(values, firstLength, secondLength + 1);
	}
	
	public boolean equalSums(int[][] matrix) {
		boolean first = true;
		int count = 0;
		for (int[] arr : matrix) {
			int sum = 0;
			for (int num : arr) {
				sum += num;
			}
			if (first) {
				count = sum;
			} else {
				if (sum != count) {
					return false;
				}
			}
			first = false;
		}
		return true;
	}
}
