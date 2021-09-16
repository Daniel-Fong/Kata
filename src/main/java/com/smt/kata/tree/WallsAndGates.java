package com.smt.kata.tree;

import java.util.ArrayList;
import java.util.Collections;

/****************************************************************************
 * <b>Title</b>: WallsAndGates.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Walls and Gates Kata
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to r
 *       epresent INF as you may assume that the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible 
 * to reach a gate, it should be filled with INF.
 * 
 * Example: 
 * 
 * Given the 2D grid:
 * 
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *   
 *   After running your function, the 2D grid should be:
 * 
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *   
 *  **** Hint: Try using a depth first search algorithm
 *   
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 29, 2021
 * @updates:
 ****************************************************************************/
public class WallsAndGates {
	
	private final int INF = 99999999;
	private ArrayList<Integer> distances;
	
	/**
	 * Assigns the distance from each room to a gate
	 * @param rooms Matrix of rooms, gates and walls
	 */
	public int[][] assign(int[][] rooms) {
		
		if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return new int[0][0];
		
		for (int y = 0; y < rooms.length; y++) {
			for (int x = 0; x < rooms[0].length; x++) {
				if (rooms[y][x] == INF) {
					this.distances = new ArrayList<Integer>();
					this.distances.add(INF);
					findGate(rooms, x, y, 0, new ArrayList<Integer[]>());
					Collections.sort(distances);
					System.out.println(distances);
					rooms[y][x] = distances.get(0);
				}
			}
		}
		for (int y = 0; y < rooms.length; y++) {
			for (int x = 0; x < rooms[0].length; x++) {
				System.out.println(rooms[y][x]);
			}
		}
		
		return rooms;
	}
	
	public void findGate(int[][] rooms, int x, int y, int distance, ArrayList<Integer[]> visited) {
		Integer[] up = new Integer[2];
		up[0] = x;
		up[1] = y - 1;
		Integer[] down = new Integer[2];
		up[0] = x;
		up[1] = y + 1;
		Integer[] left = new Integer[2];
		up[0] = x - 1;
		up[1] = y;
		Integer[] right = new Integer[2];
		up[0] = x + 1;
		up[1] = y;
		if (y - 1 >= 0 && visited.size() > 0 && !visited.contains(up)) {
			visited.add(up);
			if (rooms[x][y - 1] == 0) {
				++distance;
				System.out.println("adding");
				distances.add(distance);
			} else if (rooms[x][y -1] == -1) {
				return;
			} else {
				findGate(rooms, x, y - 1, ++distance, visited);
			}
		}
		if (y + 1 < rooms.length && visited.size() > 0 && !visited.contains(down)) {
			visited.add(down);
			if (rooms[x][y + 1] == 0) {
				++distance;
				System.out.println("adding");
				distances.add(distance);
			} else if (rooms[x][y + 1] == -1) {
				return;
			} else {
				findGate(rooms, x, y + 1, ++distance, visited);
			}
		}
		if (x - 1 >= 0 && visited.size() > 0 && !visited.contains(left)) {
			visited.add(left);
			if (rooms[x-1][y] == 0) {
				++distance;
				System.out.println("adding");
				distances.add(distance);
			} else if (rooms[x-1][y] == -1) {
				return;
			} else {
				findGate(rooms, x-1, y, ++distance, visited);
			}
		}
		if (x + 1 < rooms[0].length && visited.size() > 0 && !visited.contains(right)) {
			visited.add(right);
			if (rooms[x+1][y] == 0) {
				++distance;
				System.out.println("adding");
				distances.add(distance);
			} else if (rooms[x+1][y] == -1) {
				return;
			} else {
				findGate(rooms, x+1, y, ++distance, visited);
			}
		}
		return;
	}
}
