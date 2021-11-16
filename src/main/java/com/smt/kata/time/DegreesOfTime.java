package com.smt.kata.time;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: DegreesOfTime.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Degrees of Time
 * 
 * Given a clock time in hh:mm format, determine, to the nearest degree, the angle 
 * in degrees, between the hour and the minute hands.  The hour will be in 24 hour format.
 * 
 * Example One:
 * Input : 01:05
 * Output: 0 degrees as the hands are in the same location
 * 
 * Example two
 * Input: 00:15
 * Output: 90 degrees as the hour hand is vertical and the minute had is at 90 gegrees
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 10, 2021
 * @updates:
 ****************************************************************************/
public class DegreesOfTime {

	/**
	 * Calculate the difference in degrees for the provided time
	 * @param time Time to calculate in hh:mm 24 hour format
	 * @return difference in degrees between the minute and hour hand.  0 if invalid data
	 */
	public int calculate(String time) {
		if (time == null) return 0;
		String[] times = time.split(":");
		if (times.length < 2) return 0;
		String hour = times[0];
		String min = times[1];
		
		if (hour.length() > 2 || !hour.matches("^[0-9]+$") || Integer.parseInt(hour) < 0 ||Integer.parseInt(hour) > 24) return 0;
		if (min.length() > 2 || !min.matches("^[0-9]+$") || Integer.parseInt(min) < 0 ||Integer.parseInt(min) > 60) return 0;
		
		int h = Integer.parseInt(hour);
		if (h > 12) h = h - 12;
		int m = Integer.parseInt(min);
		
		return Math.abs(h * 30 - m * 6);
	}

}
