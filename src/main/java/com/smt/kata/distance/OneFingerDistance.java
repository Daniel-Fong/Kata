package com.smt.kata.distance;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title:</b> OneFingerDistance.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> One-Finger Distance
 * 
 * Given a linear , alphabetic keyboard of the letters of the alphabet, 
 * how many letters in total does your finger have to jump over in order to 
 * type a given word?
 * 
 * Consider the linear keyboard of the upper case letters of the alphabet laid 
 * out like this:
 * 
 * | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
 * 
 *  The word "boost" has a one-finger distance of 15 because there are 12, 0, 3, 0 
 *  letters between b and o, o and o, o and s, s and t, respectively.
 *   
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 30, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class OneFingerDistance {

	/**
	 * Calculates the finger distance on the keyboard
	 * @param word Word to calculate against
	 * @return distance between the letters
	 */
	public int calculate(String word) {
		if (StringUtils.isEmpty(word)) {
			return 0;
		}
		word = word.toUpperCase();
		int distance = 0;
		for (int i = 0; i < word.length() - 1; i++) {
			if (word.charAt(i) > 90 || word.charAt(i) < 65) {
				return 0;
			}
			if (Math.abs(word.charAt(i) - word.charAt(i + 1)) != 0) {
				distance += Math.abs(word.charAt(i) - word.charAt(i + 1)) - 1;;
			}
			
		}
		return distance;
	}
}
