package com.smt.kata.letters;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/****************************************************************************
 * <b>Title</b>: RearrangeCharacters.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Rearrange Charcters Kata
 * 
 * Given a string s, rearrange the characters so that any two adjacent characters 
 * are not the same. If this is not possible, return null.
 * 
 * For example, if s = yyz then return yzy. If s = yyy then return ""

 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 27, 2022
 * @updates:
 ****************************************************************************/
public class RearrangeCharacters {

	/**
	 * Rearranges letters in the word such that no two letters of the same are 
	 * adjacent to each other
	 * @param word Word to rearrange the letters
	 * @return Rearranged word
	 */
	public String arrange(String word) {
		if (word == null || word.length() <= 0) return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : word.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int num : map.values()) {
			if (num > Math.floor(word.length() / 2 + 1)) {
				return "";
			}
		}
		char[] arr = new char[word.length()];
		int evenIndex = 0;
		int oddIndex = 1;
		int count = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			while (entry.getValue() > count) {
				if (evenIndex < arr.length) {
					arr[evenIndex] = entry.getKey();
					evenIndex += 2;
				} else if (oddIndex < arr.length) { 
					arr[oddIndex] = entry.getKey();
					oddIndex += 2;
				}
				++count;
			} 
			count = 0;
		}
		String result = new String(arr);
		return result;
	}
}
