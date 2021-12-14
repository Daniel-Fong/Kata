package com.smt.kata.time;

/****************************************************************************
 * <b>Title</b>: DailyTemperatures.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Daily Temperatures Kata
 * 
 * Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days you have to 
 * wait after the ith day to get a warmer temperature. If there is no future day 
 * for which this is possible, keep answer[i] == 0 instead.
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * 
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 29, 2021
 * @updates:
 ****************************************************************************/
public class DailyTemperatures {

	/**
	 * Calculates the ith day until a warmer day
	 * @param temps Temperatures by day
	 * @return array matching the temps array that has the ith day for each day
	 */
	public int[] calculate(int[] temps) {
		if (temps == null || temps.length < 0) return new int[0];
		int[] results = new int[temps.length];
		for (int i = 0; i < temps.length; i++) {
			int cur = temps[i];
			int count = 1;
			boolean greater = false;
			for (int j = i + 1; j < temps.length; j++) {
				if (temps[j] > cur) {
					results[i] = count;
					greater = true;
					break;
				} else {
					++count;
				}
			}
			if (!greater) {
				results[i] = 0;
			}
		}
		return results;
	}
}
