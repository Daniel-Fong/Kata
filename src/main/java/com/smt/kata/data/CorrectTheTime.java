package com.smt.kata.data;

/****************************************************************************
 * <b>Title</b>: CorretTheTime.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Correct the Time.  You have to create a method, 
 * that corrects a given time string.  There was a problem in addition, 
 * so many of the time strings are broken.
 * Time is formatted using the 24-hour clock, so from 00:00:00 to 23:59:59:
 * Examples
 * "09:10:01" -> "09:10:01"  
 * "11:70:10" -> "12:10:10"  
 * "19:99:99" -> "20:40:39"  
 * "24:01:01" -> "00:01:01" 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 24, 2021
 * @updates:
 ****************************************************************************/
public class CorrectTheTime {

	/**
	 * 
	 */
	public CorrectTheTime() {
		super();
	}
	
	public String transform(String time) {
		
		if (time == null) {
			return "";
		}
		String[] arr = time.split(":");
		int hours = Integer.parseInt(arr[0]);
		int minutes = Integer.parseInt(arr[1]);
		int seconds = Integer.parseInt(arr[2]);
		
		if (seconds >= 60) {
			minutes ++;
			seconds = seconds % 60;
		}
		
		if (minutes >= 60) {
			hours ++;
			minutes = minutes % 60;
		}
		
		if (hours >= 24) {
			hours = hours % 24;
		}
		
		String h = hours + "";
		String m = minutes + "";
		String s = seconds + "";
		
		if (hours < 10) {
			h = "0" + hours;
		}
		if (minutes < 10) {
			m = "0" + minutes;
		}
		if (seconds < 10) {
			s = "0" + seconds;
		}

		String result = h + ":" + m + ":" + s;
		return result;
	}
}
