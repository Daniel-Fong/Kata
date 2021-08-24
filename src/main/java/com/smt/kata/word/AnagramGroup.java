package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: AnagramGroup.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Group Anagrams
 * 
 * Given an array of strings strs, group the anagrams together. You can return 
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different 
 * word or phrase, typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * 
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * Constraints:
 * strs[i] consists of lower-case English letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class AnagramGroup {

	/**
	 * Group the anagrams together
	 * @param words Array of words to group 
	 * @return Groups of anagrams
	 */
	public Collection<List<String>> assign(String[] words) {	
		List<List<String>> results = new ArrayList<>();
		if (words == null || words.length < 0) return results;
		words = Arrays.stream(words)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);    
		for (String str : words) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			StringBuilder word = new StringBuilder();
			word.append(arr);
			boolean added = false;
			if (results.size() > 0) {
				for (List<String> list : results) {
					char[] arr2 = list.get(0).toCharArray();
					Arrays.sort(arr2);
					StringBuilder word2 = new StringBuilder();
					word2.append(arr2);
					if (word.toString().equals(word2.toString())) {
						list.add(str);
						added = true;
						break;
					} 
				}
				if (!added) {
					List<String> newList = new ArrayList<>();
					newList.add(str);
					results.add(newList);
					continue;
				}
			} else {
				List<String> newList = new ArrayList<>();
				newList.add(str);
				results.add(newList);
			}
		}
		return results;
	}

}
