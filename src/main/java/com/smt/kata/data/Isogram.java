package com.smt.kata.data;

import java.util.LinkedHashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: Isogram.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Isograms
 *
 * Determine if a word or phrase is an isogram.
 * 
 * Use the Unit Test to determine the rules for an Isogram
 * 
 * You MAY not use collections or anything other than primitives and Strings for this exercise
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 17, 2021
 * @updates:
 ****************************************************************************/
public class Isogram {

	/**
	 * Validates whether or not the phrase is an isogram
	 * @param phrase Phrase to check against the Isogram rules
	 * @return true if an isogram.  False if empty or not an isogram
	 */
	public boolean isValidIsogram(String phrase) {
		if (phrase == null || phrase == "") {
			return false;
		}
		String str = phrase.replaceAll("[()\\s-]+", "").toUpperCase();
		Map<Character, Integer> characters = new LinkedHashMap<Character,Integer>();
		for (int i=0; i<str.length(); i++) {
			if (characters.containsKey(str.charAt(i))) {
				characters.put(str.charAt(i), characters.get(str.charAt(i)) + 1);
			} else {
				characters.put(str.charAt(i), 0);
			}
		}
		int compare = characters.get(str.charAt(0));
		for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
			if (entry.getValue() != compare) {
				return false;
			}
		}
		return true;
	}
        
        return phrase == null;
    }
}
