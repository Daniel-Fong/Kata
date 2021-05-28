package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> MatrixIsland.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Island Matrix
 * 
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. 
 * A 1 represents land and 0 represents water, so an island is a group of 1s that are 
 * neighboring (horizontal or vertical or both.  Diagonal only does not count) whose 
 * perimeter is surrounded by water.  Land (1s) on the outside of the matrix are 
 * considered surrounded by water on those edges.  In other words, the matrix is 
 * surrounded by water. The smallest island has 1 node
 * 
 * For example, the largest island in this matrix is 4
 * 
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 * 
 * Use whatever classes you want for this
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 1, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class MatrixIsland {
	// Members
	protected int[][] matrix;
	protected boolean hasIslands = false;
	protected int numberIslands = 0;
	protected int nodesInLargestIsland = 0;
	
	/**
	 * Assigns the matrix
	 */
	public MatrixIsland(int[][] matrix) throws NullPointerException {
		super();
		this.matrix = matrix;
		findLargest();
	}
	
	/**
	 * Finds the largest island and returns the number of nodes in that island
	 * @return Number of nodes in the largest island
	 */
	protected void findLargest() {
		if ( matrix.length < 1 || matrix == null ) throw new NullPointerException();
		/** Do something here **/
		List<Integer[]> arr = new ArrayList<>();
		List<Integer> islands = new ArrayList<>();
		for (int j = 0; j < matrix.length; j++) {
			int size = 0;
			for (int i = 0; i < matrix[j].length; i++) {
				if (matrix[j][i] != 0) {
					size++;
				}
			}
			int counter = 0;
			Integer[] js = new Integer[size];
			for (int x = 0; x< matrix[j].length; x++) {
				if (size > 0 && matrix[j][x] != 0) {
					js[counter] = x;
					counter++;
				}		
					
			}
			arr.add(js);
			System.out.println("arr = " + Arrays.toString(js));
		}
		
		int islandCount = 0;
		int islandSize = 0;
		for (int y = 0; y<arr.size() - 1; y++) {
			for (int z = 0; z<arr.get(y).length; z++) {
				if (Arrays.asList(arr.get(y+1)).contains(arr.get(y)[z])){
					islandSize += arr.get(y).length;
				} else {
					islandCount++;
					islands.add(islandSize);
					islandSize = 0;
				}
				
			}
		}
		nodesInLargestIsland = Collections.max(islands);
		hasIslands = islandCount > 0;
		numberIslands = islandCount;
		
	}
	
	/**
	 * Calculates if there are any islands and how many.  Updates the member 
	 * variables when complete
	 */
	protected void countIslands() {
		/** Do something here **/
	}


    /**
     * @return the hasIslands
     */
    public boolean hasIslands() {
        return this.numberIslands > 0;
    }

    /**
     * @return the numberIslands
     */
    public int getNumberIslands() {
        return numberIslands;
    }

    /**
     * @return the nodesInLargestIsland
     */
    public int getNodesInLargestIsland() {
        return nodesInLargestIsland;
    }

}