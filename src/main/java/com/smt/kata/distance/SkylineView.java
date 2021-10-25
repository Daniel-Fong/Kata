package com.smt.kata.distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/****************************************************************************
 * <b>Title</b>: SkylineView.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Skyline View Kata
 * 
 * You are given an array representing the heights of neighboring buildings on 
 * a city street, from east to west. The city assessor would like you to write 
 * an algorithm that returns how many of these buildings have a view of the 
 * setting sun, in order to properly value the street.
 * 
 * For example, given the array [3, 7, 8, 3, 6, 1], you should return 3, since 
 * the top floors of the buildings with heights 8, 6, and 1 all have an unobstructed 
 * view to the west.
 * 
 * -----------------------------------------------------------------------------
 * Can you do this using just one backwards pass through the array?
 * Can you do this using just one forward pass through the array?
 * -----------------------------------------------------------------------------
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 21, 2021
 * @updates:
 ****************************************************************************/
public class SkylineView {

	/**
	 * Gets the number of views working from the back of the array to forward
	 * @param buildings Array of building heights
	 * @return Number of buildings with a view
	 */
	public int getNumViewsBackwards(int[] buildings) {
		if (ArrayUtils.isEmpty(buildings)) return 0;
		else if (buildings.length < 2) return 1;
		int result = 0;
		int count = 0;
		int highest = 0;
		for (int i = buildings.length - 1; i >= 0; i--) {
			System.out.println("height = " + buildings[i]);
			if (buildings[i] > highest) {
				++count;
				if (count > result) result = count;
				highest = buildings[i];
			} 
			System.out.println("count " + count + " highest " + highest);
		}
		return result;
	}
	
	/**
	 * Gets the number of views working from the front of the array to the back
	 * @param buildings Array of building heights
	 * @return Number of buildings with a view
	 */
	public int getNumViewsForward(int[] buildings) {
		if (ArrayUtils.isEmpty(buildings)) return 0;
		else if (buildings.length < 2) return 1;
		int result = 0;
		int count = 1;
		int highest = 0;
		int lowest = 0;
		for (int i = 0; i < buildings.length; i++) {
			if (lowest == 0) {
				if (buildings[i] > highest) {
					highest = buildings[i];
				} else if (buildings[i] < highest) {
					++count;
					if (count > result) result = count;
					lowest = buildings[i];
				}
			} else {
				if (buildings[i] < highest && buildings[i] > lowest) {
					lowest = buildings[i];
				} else if (buildings[i] < lowest) {
					++count;
					if (count > result) result = count;
				} else if (buildings[i] == highest) {
					if (count > result) result = count;
					count = 1;
					lowest = 0;
				}
			}
			if (count > result) result = count;
		}
		return result;
	}

}
