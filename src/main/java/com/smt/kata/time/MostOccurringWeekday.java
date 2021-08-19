package com.smt.kata.time;

// JDK 11.x
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MostOccurringWeekday.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Most-Occurring Weekdays in a Year
 * 
 * Find the weekdays that occur the most in a given year.
 * 
 * Write a function MostOccurringWeekday that takes an integer representing a 
 * year as input and returns a list of the most-occurring weekdays throughout that year.
 * 
 * =MostOccurringWeekday[2018]
 * {Monday}
 * 
 * MostOccurringWeekday[2009]
 * {Thursday}
 * 
 * Multiple weekdays occurred the most in 2012:
 * 
 * MostOccurringWeekday[2012]
 * {Sunday, Monday}
 * 
 * ******** Note: Be careful.  Dates may be negative (IE, BC dates)
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 10, 2021
 * @updates:
 ****************************************************************************/
public class MostOccurringWeekday {
	/**
	 * Enum for the day of the week
	 */
	public enum WeekDay {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	/**
	 * Calculates the most occurring week day fo rthe given year 
	 * @param year Year to calculate against
	 * @return Collection of weekdays
	 */
	public List<WeekDay> calculate(int year) {
		ArrayList results = new ArrayList<>();
		if (year == 0) {
			return results;
		}
		HashMap<Integer, WeekDay> list = new HashMap<>();
		list.put(1, WeekDay.SUNDAY);
		list.put(2, WeekDay.MONDAY);
		list.put(3, WeekDay.TUESDAY);
		list.put(4, WeekDay.WEDNESDAY);
		list.put(5, WeekDay.THURSDAY);
		list.put(6, WeekDay.FRIDAY);
		list.put(7, WeekDay.SATURDAY);
		GregorianCalendar gcal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance();
		if(year < 0) {
            cal.set(Calendar.ERA, GregorianCalendar.BC);
        }
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		if (year > 0 && gcal.isLeapYear(year)) {
			results.add(list.get(cal.get(Calendar.DAY_OF_WEEK) + 1));
		}
			results.add(list.get(cal.get(Calendar.DAY_OF_WEEK)));
		return results;
	}

}
