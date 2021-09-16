package com.smt.kata.data;

import org.hibernate.internal.build.AllowSysOut;

/****************************************************************************
 * <b>Title</b>: MatchingSubsequence.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Matching Subsequence Kata
 * 
 * Given a string s and an array of strings words, return the number of words[i] 
 * that is a subsequence of s.
 * 
 * A subsequence of a string is a new string generated from the original string 
 * with some characters (can be none) deleted without changing the relative order 
 * of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * Example 1:
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * 
 * Example 2:
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
public class MatchingSubsequence {

	/**
	 * Finds how many of the words in the array match as subsequences inside the source
	 * @param source Source string to compare against
	 * @param words Words to evaluate for subsequences in the source
	 * @return Number of matches
	 */
	public int match(String source, String[] words) {
		if (words == null || words.length == 0) return 0;
		if (source == null || source.length() == 0) return 0;
		source = source.toLowerCase();
		int result = 0;
		for (String word : words) {
			if (word == null) continue;
			int index = 0;
			word = word.toLowerCase();
			for (int i = 0; i < source.length(); i++) {
				if (word.charAt(index) == source.charAt(i)) {
					++index;
					if (index >= word.length()) {
						System.out.println("adding");
						++result;
						break;
					}
					continue;
				}
				System.out.println(word.charAt(index) + " | " + source.charAt(i));
			}
		}
		return result;
	}
}
