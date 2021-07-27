package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/****************************************************************************
 * <b>Title</b>: ValidSherlockString.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Sherlock considers a string to be valid if all characters of the string appear 
 * the same number of times. It is also valid if he can remove just 1 character at 
 * 1 index in the string, and the remaining characters will occur the same number of times. 
 * Given a string str, determine if it is valid. If so, return "YES", otherwise return "NO".
 * 
 * For example, If str = "abc", the string is valid because the frequencies of characters 
 * are all the same. If str = "abcc", the string is also valid, because we can 
 * remove 1 "c" and have one of each character remaining in the string. However, 
 * if str = "abccc", the string is not valid, because removing one character does not 
 * result in the same frequency of characters.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class ValidSherlockString {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean isValid(String sequence) {
		Map<Character, Integer> map = new HashMap<>();
		String lower = sequence.toLowerCase();
		for (int i = 0; i < lower.length(); i++) {
			if (map.containsKey(lower.charAt(i))) {
				map.put(lower.charAt(i), map.get(lower.charAt(i)) + 1);
			} else {
				map.put(lower.charAt(i), 1);
			}
		}
		int min = Integer.MAX_VALUE;
        for (Map.Entry<Character,Integer> entry : map.entrySet())
            min = Math.min(entry.getValue(), min);

        int removed = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet())
            if(entry.getValue() != min)
                removed += entry.getValue() - min;

        if (removed <= 1) return true;
        return false;
	}
}
