package com.smt.kata.letters;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: ReorderLetters.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Reorder Letters Kata
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters. 
 * If there are multiple characters with the same count, the letters should be
 * sorted alphabetically.  Same letter with different case should be consider as 
 * 2 different characters
 * 
 * Example One
 * Input: tweet
 * Output: eettw
 * 
 * Example Two
 * Input: TwEet
 * Output: ETetw
 * 
 * Empty/Null
 * Input: null or ""
 * Output: ""
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 31, 2022
 * @updates:
 ****************************************************************************/
public class ReorderLetters {
	String result = "";
	/**
	 * Reorders the letters based upon the total number each character is present and 
	 * then ordered alphabetically.
	 * @param word Word to reorder it's letters
	 * @return Reordered word
	 */
	public String process(String word) {
		if (word == null || word.length() < 1) return "";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (char c : word.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey())
			.sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
			.forEach(entry -> {
				for (int i = 0; i < entry.getValue(); i++) {
					result += entry.getKey();
				}
			});
		return result;
	}
}
