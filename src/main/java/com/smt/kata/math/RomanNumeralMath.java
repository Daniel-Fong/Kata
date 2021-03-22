package com.smt.kata.math;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.smt.kata.code.RomanNumerals;

/****************************************************************************
 * <b>Title</b>: RomanNumeralMath.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Roman Numeral Math
 * Take 2 roman numerals and return the sum or difference between the 2 values.
 * When subtracting, use absolute value for the difference to ensure the number
 * returned is always positive
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 15, 2021
 * @updates:
 ****************************************************************************/
public class RomanNumeralMath {
	
	/**
	 * Map of the roman numerals to decimal conversion
	 */
	private static Map<String, Integer> numerals = new LinkedHashMap<String, Integer>() {
		private static final long serialVersionUID = 1L; {
			put("M", 1000);
			put("D", 500);
			put("C", 100);
			put("L", 50);
			put("X", 10);
			put("V", 5);
			put("I", 1);
		}
	};

	/**
	 * Convert a number into its roman numeral counterpart
	 * @param startNumber
	 * @return
	 */
	public int getRomanValue(String str){
		
		int result = 0;
		
		// Loop the map of numeral
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'C' && str.charAt(i+1) == 'D') {
				result -= numerals.get(str.charAt(i) + "");
			} else if (str.charAt(i) == 'X' && str.charAt(i+1) == 'L') {
				result -= numerals.get(str.charAt(i) + "");
			} else if (i < str.length() && str.charAt(i) == 'I' && str.charAt(i+1) == 'V') {
				result -= numerals.get(str.charAt(i) + "");
			} else {
				int numVal = numerals.get(str.charAt(i) + "");
				result += numVal;
			}
		}
//		System.out.println(str);
//		System.out.println(result);
		return result;
	}
	
	/**
	 * Takes two roman numerals and adds them together
	 * @param first
	 * @param second
	 * @return
	 */
	public String add(String first, String second) {
		if (first == null || second ==null) {
			return "";
		}
		System.out.println(first);
		System.out.println(second);
		System.out.println(RomanNumerals.getRomanNumeral(getRomanValue(first) + getRomanValue(second)));
		return RomanNumerals.getRomanNumeral(getRomanValue(first) + getRomanValue(second));
	}
	
	/**
	 * Takes two roman numerals and subtracts them.  Absolute value is
	 * used to ensure a positive number
	 * @param first
	 * @param second
	 * @return
	 */
	public String subtract(String first, String second) {
		if (first == null || second ==null) {
			return "";
		}
		return RomanNumerals.getRomanNumeral(getRomanValue(first) - getRomanValue(second));
	}
}
