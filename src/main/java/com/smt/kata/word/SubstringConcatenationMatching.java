package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;

import java.util.Iterator;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SubstringConcatenationMatching.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Substring with Concatenation of All Words Kata
 * 
 * You are given a string s and an array of strings words of the same length. 
 * Return all starting indices of substring(s) in s that is a concatenation of 
 * each word in words exactly once, in any order, and without any intervening 
 * characters.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * 
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 

Constraints:
1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 4, 2021
 * @updates:
 ****************************************************************************/
public class SubstringConcatenationMatching {

	List<String> combos = new ArrayList<>();
	List<Integer> indices = new ArrayList<>();
	/**
	 * Finds the indexes of the matches of the words in any order in the phrase
	 * @param phrase Phrase to locate the substrings
	 * @param words Words to find
	 * @return List of matching indexes
	 */
	public List<Integer> find(String phrase, String[] words) {
		if (phrase == null || phrase.length() == 0 || words == null || words.length == 0) return new ArrayList<>();
		String phr = phrase.toLowerCase();
		List<String> l = new ArrayList<>();
		for (String w : words) {
			l.add(w);
		}
		getStrings(l);
//		recurse(Arrays.asList(words), "", "");
		for (String str : combos) {
			System.out.println(str);
			String s = phr;
			while(s.indexOf(str) >= 0) {
				indices.add(s.indexOf(str));
				s = s.substring(0, s.indexOf(str)) + s.substring(s.indexOf(str) + str.length(), phrase.length());
			};
		}
		return indices;
	}
	
	public void getStrings(List<String> wordsList) {
		Map<String, List<String>> map = new HashMap<>();
		List<String> l = new ArrayList<>();
		for (String w : wordsList) {
			l.add(w);
		}
		for (String str : wordsList) {
			map.put(str, l);
		}
		for (int i = 0; i < wordsList.size(); i++) {
			System.out.println("loop");
			Map<String, List<String>> newMap = new HashMap<>();
			for (var entry : map.entrySet()) {
				System.out.println(entry.getKey());
				entry.getValue().remove(entry.getKey());
			}
			for (var entry : map.entrySet()) {
				List<String> l1 = new ArrayList<>();
				for (String w1 : entry.getValue()) {
					l1.add(w1);
				}
				for (String s : entry.getValue()) {
					System.out.println(entry.getKey() + s);
					newMap.put(entry.getKey() + s, l1);
				}
			}
			map = newMap;
			if (i == wordsList.size() - 1) {
				System.out.println("adding");
				for (String result : map.keySet()) {
					System.out.println("adding " + result);
					combos.add(result);
				}
			}
		}
	}
	
//	public void recurse(List<String> wordsList, String word, String last) {
//		List<String> list = new ArrayList<>();
//		String removed = "";
//		for (String str : wordsList) {
//			if ((str != null && str.length() > 0) && (!str.equals(last) || removed.equals(last))) {
//				list.add(str.toLowerCase());
//			} else {
//				removed = last;
//			}
//		}
//		if (list.size() < 1) {
//			combos.add(word);
//			return;
//		}
//		for (String s : list) {
//			recurse(list, word + s, s);
//		}
//	}
}
