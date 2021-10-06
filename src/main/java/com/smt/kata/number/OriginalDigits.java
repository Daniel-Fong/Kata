package com.smt.kata.number;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: OriginalDigits.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reconstruct Original Digits from English
 * 
 * Given a string s containing an out-of-order English representation of digits 0-9, 
 * return the digits in ascending order.
 * 
 * Example 1:
 * Input: s = "owoztneoer"
 * Output: "012"
 * 
 * Example 2:
 * Input: s = "fviefuro"
 * Output: "45"
 * 
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
public class OriginalDigits {
	
	private List<String> list = new ArrayList<>();
	
	/**
	 * Initializes the class 
	 */
	public OriginalDigits() {
		super();
		list.add("zero");
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("seven");
		list.add("eight");
		list.add("nine");
	}
	
	/**
	 * Calculates the digits in the word
	 * @param source Source to find digits
	 * @return Digits in order
	 */
	public String calculate(String source) {
		if (source == null || source.length() == 0) return "";
		source = source.toLowerCase();
		String result = "";
		StringBuilder copy = new StringBuilder();
		copy.append(source);
		for (String num : list) {
			boolean isIn = true;
			for (char c : num.toCharArray()) {
				if (!source.contains(c + "")) {
					isIn = false;
				}
			}
			if (isIn) {
				boolean delete = false
				for (char c : num.toCharArray()) {
					if (copy.indexOf(c + "") > -1) {
						copy.deleteCharAt(copy.indexOf(c + ""));
					} else ()
					
					System.out.println(copy);
				}
				result += list.indexOf(num);
			}
		}
		return result;
	}
}
