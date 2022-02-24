package com.smt.kata.game;

import java.util.ArrayList;
import java.util.Arrays;
// JDK 11.x
import java.util.Collection;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: AnagramGroup.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Anagram Group Kata
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given the following array:
 * 
 * ['eat', 'ate', 'apt', 'pat', 'tea', 'now']
 * 
 * Return:
 * 
 * [['eat', 'ate', 'tea'],
 *  ['apt', 'pat'],
 *  ['now']]
 *  
 *  Constraints
 *  All words must be lower case or converted to lower case if not.
 *  Return empty collection if source array is empty or null
 *  Skip all null words in the array
 *  
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 21, 2022
 * @updates:
 ****************************************************************************/
public class AnagramGroup {

	/**
	 * Groups all of the words into anagrams
	 * @param words Array of words to group
	 * @return A collection of lists grouping the 
	 */
	public Collection<List<String>> findGroups(String[] words) {
		List<List<String>> result = new ArrayList<>();
		if (words == null || words.length < 1) return result;
		for (String word : words) {
			boolean added = false;
			if (word == null) {
				continue;
			}
			word = word.toLowerCase();
			char[] wordArr = word.toCharArray();
			Arrays.sort(wordArr);
			String newWord = new String(wordArr);
			for (List<String> list : result) {
				char[] firstArr = list.get(0).toCharArray();
				Arrays.sort(firstArr);
				String newFirst = new String(firstArr);
				if (newWord.equals(newFirst)) {
					list.add(word);
					added = true;
				}		
			}
			if (!added) {
				List<String> newList = new ArrayList<>();
				newList.add(word);
				result.add(newList);
			}
		}
		return result;
	}
}
