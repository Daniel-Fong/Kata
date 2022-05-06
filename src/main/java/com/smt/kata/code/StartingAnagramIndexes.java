package com.smt.kata.code;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: StartingAnagramIndexes.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Starting Anagram Indexes Kata
 * 
 * Given a word W and a string S, find all starting indices in S which are anagrams of W.
 * 
 * For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
 * 
 * <b>Copyright:</b> Copyright (c) 2022
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 17, 2022
 * @updates:
 ****************************************************************************/
public class StartingAnagramIndexes {

	/**
	 * Finds the indexes of all of the matching permutations or anagrams of the word
	 * in the phrase
	 * @param word Word to find And its anagrams) in the phrase
	 * @param phrase Phrase to match against
	 * @return Collection of the matching indexes
	 */
	public List<Integer> find(String word, String phrase) {
		if (word == null || word.length() == 0 || phrase == null || phrase.length() == 0) return new ArrayList<>();
		phrase = phrase.toLowerCase();
		List<Integer> indices = new ArrayList<>();
		char[] wordArr = word.toLowerCase().toCharArray();
		Arrays.sort(wordArr);
		String sortedWord = String.valueOf(wordArr);
		for (int i = 0; i <= phrase.length() - word.length(); i++) {
			char[] check = phrase.substring(i, i + word.length()).toCharArray();
			Arrays.sort(check);
			String checkStr = String.valueOf(check);
			if (checkStr.equals(sortedWord)) {
				indices.add(i);
			}
		}
		return indices;		
	}
	
	public void getAnagrams(String word) {
		
	}
}
