package com.smt.kata.code;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: StringWindow.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> String Window Kata
 * 
 * Given a string, find the length of the smallest window that contains every 
 * distinct character. Characters may appear more than once in the window.
 * 
 * For example, given "jiujitsu", you should return 5, corresponding to the final 
 * five letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 30, 2021
 * @updates:
 ****************************************************************************/
public class StringWindow {

	/**
	 * Find the length of the smallest window
	 * @param word Word to find the window
	 * @return Smallest Window.  0 is returned if invalid data.
	 */
	public int find(String word) {
		if (word == null || word.length() < 1) return 0;
		String lower = word.toLowerCase();
		List<Character> unique = new ArrayList<>();
		for (char c : lower.toCharArray()) {
			if (!unique.contains(c)) {
				unique.add(c);
			}
		}
		int length = word.length();
		for (int i = 0; i < lower.length(); i++) {
			List<Character> checkList = new ArrayList<>();
			for (Character c2 : unique) {
				checkList.add(c2);
			}
			for (int j = i; j < lower.length(); j++) {
				if (checkList.contains(lower.charAt(j))) {
					checkList.remove(Character.valueOf(lower.charAt(j)));
				}
				if (checkList.size() < 1 && j + 1 - i < length) {
					length = j+1-i;
				}
			}
		}
		return length;
	}

}
