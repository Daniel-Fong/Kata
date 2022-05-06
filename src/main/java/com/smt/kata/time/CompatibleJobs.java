package com.smt.kata.time;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

/****************************************************************************
 * <b>Title</b>: CompatibleJobs.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compatible Jobs Kata
 * 
 * You are given a list of jobs to be done, where each job is represented by a 
 * start time and end time. Two jobs are compatible if they don't overlap. Find 
 * the largest subset of compatible jobs.
 * 
 * For example, given the following jobs (there is no guarantee that jobs will be sorted):
 * 
 * [(0, 6),
 * (1, 4),
 * (3, 5),
 * (3, 8),
 * (4, 7),
 * (5, 9),
 * (6, 10),
 * (8, 11)]
 * Return:
 * 
 * [(1, 4),
 * (4, 7),
 * (8, 11)]
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 17, 2022
 * @updates:
 ****************************************************************************/
public class CompatibleJobs {

	/**
	 * Calculates the compatible jobs form the array of jobs
	 * @param arrJobs Jobs to check for compatibility
	 * @return Max compatible jobs
	 */
	public int[][] calculate(int[][] arrJobs) {
		if (arrJobs == null || arrJobs.length == 0 || arrJobs[0] == null || arrJobs[0].length == 0) return new int[0][0];
		List<int[]> results = new ArrayList<>();
		int startTime = 0;
		for (int i = 0; i < arrJobs.length; i++) {
			int min = Integer.MAX_VALUE;
			int[] temp = new int[0];
			for (int j = 0; j < arrJobs.length; j++) {
				if (!results.contains(arrJobs[j]) && arrJobs[j][1] < min && arrJobs[j][0] >= startTime) {
					temp = arrJobs[j];
					min = temp[1];
				}
			}
			if (temp.length > 0) {
				results.add(temp);
				startTime = temp[1];
			} else {
				break;
			}
		}
		int[][] resultsArr = new int[results.size()][];
		for (int i = 0; i < results.size(); i++) {
			resultsArr[i] = results.get(i);
		}
		return resultsArr;
	}
}
